package com.kevin.photo_browse.ui;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.github.chrisbanes.photoview.PhotoView;
import com.jaeger.library.StatusBarUtil;
import com.kevin.photo_browse.DataServer;
import com.kevin.photo_browse.ImageBrowseIntent;
import com.kevin.photo_browse.R;
import com.kevin.photo_browse.adapter.MyPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Kevin on 2017/8/29.
 */

public class ImageBrowseActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<View> views;
    private RelativeLayout container;
    private CircleIndicator indicator;

    //类型枚举标志
    public static int[] FLAG_ENUM = new int[]{0, 1, 2, 3, 4, 5};
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        if (getActionBar() != null)
            getSupportActionBar().hide();
        setContentView(R.layout.activity_image_browse);
        StatusBarUtil.setColor(this, Color.BLACK, 0);
        container = findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();
    }

    private void initData() {
        indicator = findViewById(R.id.indicator);
        viewPager = findViewById(R.id.viewPager);
        // 1.设置幕后item的缓存数目
        viewPager.setOffscreenPageLimit(3);
        // 2.设置页与页之间的间距
        viewPager.setPageMargin(10);

        views = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        switch (bundle.getInt(ImageBrowseIntent.PARAM_FLAG_ENUM)) {
            case 0://Url组
                //动态添加View
                List<String> imageUrlList = DataServer.getInstance().getImageUrlList();
                for (int i = 0; i < imageUrlList.size(); i++) {
                    View view = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                    PhotoView photo_view = view.findViewById(R.id.photo_view);
                    Picasso.get().load(imageUrlList.get(i)).placeholder(R.drawable.img_placeholder).error(R.drawable.img_error).into(photo_view);
                    photo_view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                        }
                    });
                    views.add(view);
                }
                indicator.setVisibility(View.VISIBLE);
                position = DataServer.getInstance().getPosition();
                break;
            case 1://Url单
                View urlView = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                PhotoView url_photo_view = urlView.findViewById(R.id.photo_view);
                Picasso.get().load(DataServer.getInstance().getImageUrl()).placeholder(R.drawable.img_placeholder).error(R.drawable.img_error).into(url_photo_view);
                url_photo_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
                views.add(urlView);
                indicator.setVisibility(View.GONE);
                break;
            case 2://本地资源组
                List<Integer> imageResIdList = DataServer.getInstance().getImageResIdList();
                //动态添加View
                for (int i = 0; i < imageResIdList.size(); i++) {
                    View view = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                    PhotoView photo_view = view.findViewById(R.id.photo_view);
                    Picasso.get().load(imageResIdList.get(i)).placeholder(R.drawable.img_placeholder).error(R.drawable.img_error).into(photo_view);
                    photo_view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                        }
                    });
                    views.add(view);
                }
                indicator.setVisibility(View.VISIBLE);
                position = DataServer.getInstance().getPosition();
                break;
            case 3://本地资源单
                View resIdView = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                PhotoView res_id_photo_view = resIdView.findViewById(R.id.photo_view);
                Picasso.get().load(DataServer.getInstance().getImageResId()).placeholder(R.drawable.img_placeholder).error(R.drawable.img_error).into(res_id_photo_view);
                res_id_photo_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
                views.add(resIdView);
                indicator.setVisibility(View.GONE);
                break;
            case 4://uri组
                List<Uri> imageUriList = DataServer.getInstance().getImageUriList();
                //动态添加View
                for (int i = 0; i < imageUriList.size(); i++) {
                    View view = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                    PhotoView photo_view = view.findViewById(R.id.photo_view);
                    Picasso.get().load(imageUriList.get(i)).placeholder(R.drawable.img_placeholder).error(R.drawable.img_error).into(photo_view);
                    photo_view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                        }
                    });
                    views.add(view);
                }
                indicator.setVisibility(View.VISIBLE);
                position = DataServer.getInstance().getPosition();
                break;
            case 5://uri单
                View uriIdView = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                PhotoView uri_photo_view = uriIdView.findViewById(R.id.photo_view);
                Picasso.get().load(DataServer.getInstance().getImageUri()).placeholder(R.drawable.img_placeholder).error(R.drawable.img_error).into(uri_photo_view);
                uri_photo_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
                views.add(uri_photo_view);
                indicator.setVisibility(View.GONE);
                break;
            default:
                break;
        }
        viewPager.setAdapter(new MyPagerAdapter(views)); // 为viewpager设置adapter
        indicator.setViewPager(viewPager);
        container = findViewById(R.id.container);
        viewPager.setCurrentItem(position);
        // 3.将父类的touch事件分发至viewPgaer，否则只能滑动中间的一个view对象
        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPager.dispatchTouchEvent(event);
            }
        });
    }
}