package com.kevin.photo_browse.ui;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.jaeger.library.StatusBarUtil;
import com.kevin.photo_browse.DataServer;
import com.kevin.photo_browse.ImageBrowseIntent;
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
    private DataServer.ClickCallback clickCallback;

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

        this.clickCallback = DataServer.getInstance().getClickCallback();

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
                final List<String> imageUrlList = DataServer.getInstance().getImageUrlList();
                for (int i = 0; i < imageUrlList.size(); i++) {
                    final View view = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                    PhotoView photo_view = view.findViewById(R.id.photo_view);
                    Glide.with(this)
                            .load(imageUrlList.get(i))
                            .placeholder(R.drawable.img_placeholder)
                            .error(R.drawable.img_error)
                            .into(photo_view);
//                    photo_view.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            finish();
//                        }
//                    });
                    TextView titleTv = view.findViewById(R.id.titleTv);
                    if (DataServer.getInstance().getTitleList() != null && DataServer.getInstance().getTitleList().size() > i)
                        titleTv.setText(DataServer.getInstance().getTitleList().get(i));
                    if(clickCallback!=null){
                        final int finalI = i;
                        photo_view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        });
                        photo_view.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View view) {
                                clickCallback.onLongClick(ImageBrowseActivity.this,imageUrlList.get(finalI));
                                return true;
                            }
                        });
                    }
                    views.add(view);
                }
                indicator.setVisibility(View.VISIBLE);
                position = DataServer.getInstance().getPosition();
                break;
            case 1://Url单
                View urlView = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                PhotoView url_photo_view = urlView.findViewById(R.id.photo_view);
                Glide.with(this)
                        .load(DataServer.getInstance().getImageUrl())
                        .placeholder(R.drawable.img_placeholder)
                        .error(R.drawable.img_error)
                        .into(url_photo_view);
                if (DataServer.getInstance().getTitle() != null)
                    ((TextView) urlView.findViewById(R.id.titleTv)).setText(DataServer.getInstance().getTitle());
                url_photo_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
                if(clickCallback!=null){
                    urlView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            clickCallback.onClick(DataServer.getInstance().getImageUrl());
                        }
                    });
                    urlView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View view) {
                            clickCallback.onClick(DataServer.getInstance().getImageUrl());
                            return true;
                        }
                    });
                }
                views.add(urlView);
                indicator.setVisibility(View.GONE);
                break;
            case 2://本地资源组
                final List<Integer> imageResIdList = DataServer.getInstance().getImageResIdList();
                //动态添加View
                for (int i = 0; i < imageResIdList.size(); i++) {
                    View view = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                    PhotoView photo_view = view.findViewById(R.id.photo_view);
                    Glide.with(this)
                            .load(imageResIdList.get(i))
                            .placeholder(R.drawable.img_placeholder)
                            .error(R.drawable.img_error)
                            .into(photo_view);
                    photo_view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                        }
                    });
                    TextView titleTv = view.findViewById(R.id.titleTv);
                    if (DataServer.getInstance().getTitleList() != null && DataServer.getInstance().getTitleList().size() > i)
                        titleTv.setText(DataServer.getInstance().getTitleList().get(i));
                    if(clickCallback!=null){
                        final int finalI = i;
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clickCallback.onClick(imageResIdList.get(finalI));
                            }
                        });
                        view.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View view) {
                                clickCallback.onLongClick(imageResIdList.get(finalI));
                                return true;
                            }
                        });
                    }
                    views.add(view);
                }
                indicator.setVisibility(View.VISIBLE);
                position = DataServer.getInstance().getPosition();
                break;
            case 3://本地资源单
                View resIdView = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                PhotoView res_id_photo_view = resIdView.findViewById(R.id.photo_view);
                Glide.with(this)
                        .load(DataServer.getInstance().getImageResId())
                        .placeholder(R.drawable.img_placeholder)
                        .error(R.drawable.img_error)
                        .into(res_id_photo_view);
                res_id_photo_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
                if (DataServer.getInstance().getTitle() != null)
                    ((TextView) resIdView.findViewById(R.id.titleTv)).setText(DataServer.getInstance().getTitle());
                if(clickCallback!=null){
                    resIdView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            clickCallback.onClick(DataServer.getInstance().getImageResId());
                        }
                    });
                    resIdView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View view) {
                            clickCallback.onClick(DataServer.getInstance().getImageResId());
                            return true;
                        }
                    });
                }
                views.add(resIdView);
                indicator.setVisibility(View.GONE);
                break;
            case 4://uri组
                final List<Uri> imageUriList = DataServer.getInstance().getImageUriList();
                //动态添加View
                for (int i = 0; i < imageUriList.size(); i++) {
                    View view = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                    PhotoView photo_view = view.findViewById(R.id.photo_view);
                    Glide.with(this)
                            .load(imageUriList.get(i))
                            .placeholder(R.drawable.img_placeholder)
                            .error(R.drawable.img_error)
                            .into(photo_view);
                    photo_view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                        }
                    });
                    TextView titleTv = view.findViewById(R.id.titleTv);
                    if (DataServer.getInstance().getTitleList() != null && DataServer.getInstance().getTitleList().size() > i)
                        titleTv.setText(DataServer.getInstance().getTitleList().get(i));
                    if(clickCallback!=null){
                        final int finalI = i;
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clickCallback.onClick(imageUriList.get(finalI));
                            }
                        });
                        view.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View view) {
                                clickCallback.onLongClick(imageUriList.get(finalI));
                                return true;
                            }
                        });
                    }
                    views.add(view);
                }
                indicator.setVisibility(View.VISIBLE);
                position = DataServer.getInstance().getPosition();
                break;
            case 5://uri单
                View uriIdView = LayoutInflater.from(this).inflate(R.layout.adapter_image, null);
                PhotoView uri_photo_view = uriIdView.findViewById(R.id.photo_view);
                Glide.with(this)
                        .load(DataServer.getInstance().getImageUri())
                        .placeholder(R.drawable.img_placeholder)
                        .error(R.drawable.img_error)
                        .into(uri_photo_view);
                uri_photo_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
                if (DataServer.getInstance().getTitle() != null)
                    ((TextView) uriIdView.findViewById(R.id.titleTv)).setText(DataServer.getInstance().getTitle());
                if(clickCallback!=null){
                    uriIdView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            clickCallback.onClick(DataServer.getInstance().getImageUri());
                        }
                    });
                    uriIdView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View view) {
                            clickCallback.onClick(DataServer.getInstance().getImageUri());
                            return true;
                        }
                    });
                }
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
        DataServer.getInstance().clear();//清空数据服务储存
    }
}