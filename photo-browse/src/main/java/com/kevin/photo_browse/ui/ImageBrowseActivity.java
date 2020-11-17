package com.kevin.photo_browse.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.jaeger.library.StatusBarUtil;
import com.kevin.photo_browse.DataServer;
import com.kevin.photo_browse.R;
import com.kevin.photo_browse.adapter.MyPagerAdapter;

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
        initData();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initData() {
        container = findViewById(R.id.container);
        indicator = findViewById(R.id.indicator);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(10);
        views = new ArrayList<>();
        switch (DataServer.getInstance().getShowType()) {
            case SINGLE_URL://Url单
                View urlView = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                PhotoView url_photo_view = urlView.findViewById(R.id.photo_view);
                this.loadImage(DataServer.getInstance().getImageUrl(), url_photo_view);
                url_photo_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (DataServer.getInstance().getClickCallback() == null)
                            finish();
                        else
                            DataServer.getInstance().getClickCallback().onClick(ImageBrowseActivity.this, DataServer.getInstance().getImageUrl(), 0);
                    }
                });
                url_photo_view.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (DataServer.getInstance().getClickCallback() != null)
                            DataServer.getInstance().getClickCallback().onLongClick(ImageBrowseActivity.this, DataServer.getInstance().getImageUrl(), 0);
                        return true;
                    }
                });
                views.add(urlView);
                indicator.setVisibility(View.GONE);
                break;
            case MULTIPLE_URL://Url组
                //动态添加View
                final List<String> imageUrlList = DataServer.getInstance().getImageUrlList();
                for (int i = 0; i < imageUrlList.size(); i++) {
                    View view = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                    PhotoView photo_view = view.findViewById(R.id.photo_view);
                    this.loadImage(imageUrlList.get(i), photo_view);
                    final int finalPosition = i;
                    photo_view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (DataServer.getInstance().getClickCallback() == null)
                                finish();
                            else
                                DataServer.getInstance().getClickCallback().onClick(ImageBrowseActivity.this, imageUrlList.get(finalPosition), finalPosition);
                        }
                    });
                    photo_view.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View view) {
                            if (DataServer.getInstance().getClickCallback() != null)
                                DataServer.getInstance().getClickCallback().onLongClick(ImageBrowseActivity.this, imageUrlList.get(finalPosition), finalPosition);
                            return true;
                        }
                    });
                    views.add(view);
                }
                indicator.setVisibility(View.VISIBLE);
                break;
            case SINGLE_RES://本地资源单
                View resIdView = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                PhotoView res_id_photo_view = resIdView.findViewById(R.id.photo_view);
                this.loadImage(DataServer.getInstance().getImageResId(), res_id_photo_view);
                res_id_photo_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (DataServer.getInstance().getClickCallback() == null)
                            finish();
                        else
                            DataServer.getInstance().getClickCallback().onClick(ImageBrowseActivity.this, DataServer.getInstance().getImageResId(), 0);
                    }
                });
                res_id_photo_view.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (DataServer.getInstance().getClickCallback() != null)
                            DataServer.getInstance().getClickCallback().onLongClick(ImageBrowseActivity.this, DataServer.getInstance().getImageResId(), 0);
                        return true;
                    }
                });
                views.add(resIdView);
                indicator.setVisibility(View.GONE);
                break;
            case MULTIPLE_RES://本地资源组
                final List<Integer> imageResIdList = DataServer.getInstance().getImageResIdList();
                //动态添加View
                for (int i = 0; i < imageResIdList.size(); i++) {
                    View view = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                    PhotoView photo_view = view.findViewById(R.id.photo_view);
                    this.loadImage(imageResIdList.get(i), photo_view);
                    final int finalPosition = i;
                    photo_view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (DataServer.getInstance().getClickCallback() == null)
                                finish();
                            else
                                DataServer.getInstance().getClickCallback().onClick(ImageBrowseActivity.this, imageResIdList.get(finalPosition), finalPosition);
                        }
                    });
                    photo_view.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View view) {
                            if (DataServer.getInstance().getClickCallback() != null)
                                DataServer.getInstance().getClickCallback().onLongClick(ImageBrowseActivity.this, imageResIdList.get(finalPosition), finalPosition);
                            return true;
                        }
                    });
                    views.add(view);
                }
                indicator.setVisibility(View.VISIBLE);
                break;
            case SINGLE_URI://uri单
                View uriIdView = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                PhotoView uri_photo_view = uriIdView.findViewById(R.id.photo_view);
                this.loadImage(DataServer.getInstance().getImageUri(), uri_photo_view);
                uri_photo_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (DataServer.getInstance().getClickCallback() == null)
                            finish();
                        else
                            DataServer.getInstance().getClickCallback().onClick(ImageBrowseActivity.this, DataServer.getInstance().getImageUri(), 0);
                    }
                });
                uri_photo_view.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (DataServer.getInstance().getClickCallback() != null)
                            DataServer.getInstance().getClickCallback().onLongClick(ImageBrowseActivity.this, DataServer.getInstance().getImageUri(), 0);
                        return true;
                    }
                });
                views.add(uri_photo_view);
                indicator.setVisibility(View.GONE);
                break;
            case MULTIPLE_URI://uri组
                final List<Uri> imageUriList = DataServer.getInstance().getImageUriList();
                //动态添加View
                for (int i = 0; i < imageUriList.size(); i++) {
                    View view = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                    PhotoView photo_view = view.findViewById(R.id.photo_view);
                    this.loadImage(imageUriList.get(i), photo_view);
                    final int finalPosition = i;
                    photo_view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (DataServer.getInstance().getClickCallback() == null)
                                finish();
                            else
                                DataServer.getInstance().getClickCallback().onClick(ImageBrowseActivity.this, imageUriList.get(finalPosition), finalPosition);
                        }
                    });
                    photo_view.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View view) {
                            if (DataServer.getInstance().getClickCallback() != null)
                                DataServer.getInstance().getClickCallback().onLongClick(ImageBrowseActivity.this, imageUriList.get(finalPosition), finalPosition);
                            return true;
                        }
                    });
                    views.add(view);
                }
                indicator.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
        viewPager.setAdapter(new MyPagerAdapter(views));
        indicator.setViewPager(viewPager);
        viewPager.setCurrentItem(DataServer.getInstance().getPosition());
        //将父类的touch事件分发至viewPager，否则只能滑动中间的一个view对象
        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPager.dispatchTouchEvent(event);
            }
        });
    }

    /**
     * 图片加载
     *
     * @param obj
     * @param iv
     */
    private void loadImage(Object obj, ImageView iv) {
        if (obj == null || iv == null)
            return;
        if (obj instanceof String) {
            Glide.with(this)
                    .load(obj.toString())
                    .placeholder(R.drawable.img_placeholder)
                    .error(R.drawable.img_error)
                    .into(iv);
        } else if (obj instanceof Integer) {
            Glide.with(this)
                    .load((Integer) obj)
                    .placeholder(R.drawable.img_placeholder)
                    .error(R.drawable.img_error)
                    .into(iv);
        } else if (obj instanceof Uri) {
            Glide.with(this)
                    .load((Uri) obj)
                    .placeholder(R.drawable.img_placeholder)
                    .error(R.drawable.img_error)
                    .into(iv);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        DataServer.getInstance().clear();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.anim_activity_out);
    }
}