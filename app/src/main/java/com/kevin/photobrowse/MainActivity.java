package com.kevin.photobrowse;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kevin.photo_browse.DataServer;
import com.kevin.photo_browse.ImageBrowseIntent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Button btn_url_single, btn_url_group, btn_res_single, btn_res_group, btn_uri_single, btn_uri_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mContext = this;
        init();
    }

    private void init() {
        btn_url_single = findViewById(R.id.btn_url_single);
        btn_url_group = findViewById(R.id.btn_url_group);
        btn_res_single = findViewById(R.id.btn_res_single);
        btn_res_group = findViewById(R.id.btn_res_group);
        btn_uri_single = findViewById(R.id.btn_uri_single);
        btn_uri_group = findViewById(R.id.btn_uri_group);

        //浏览单张网络图片
        btn_url_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageBrowseIntent.showUrlImageBrowse(mContext, "http://n.sinaimg.cn/fashion/transform/233/w440h593/20180918/mIou-hkhfqns5235732.png");
            }
        });

        //浏览多张网络图片
        btn_url_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> imageList = new ArrayList<>();
                imageList.add("https://b-ssl.duitang.com/uploads/item/201902/18/20190218234338_fhjiw.jpg");
                imageList.add("http://p9.itc.cn/q_70/images03/20200605/0f15bc7a29e24ce88ac3028d30f68fb4.gif");
                imageList.add("https://b-ssl.duitang.com/uploads/item/201902/14/20190214225951_tjinr.jpg");
                List<String> titleList = new ArrayList<>();
                titleList.add("测试标1");
                titleList.add("");
                titleList.add("测试标3");
                ImageBrowseIntent.showUrlImageBrowse(mContext, imageList, 0, titleList, new DataServer.ClickCallback() {
                    @Override
                    public void onLongClick(Activity activity,String imageUrl) {
                        super.onLongClick(activity,imageUrl);
                        Log.d("-->", imageUrl);
                    }
                });
            }
        });

        //浏览单张资源图片
        btn_res_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageBrowseIntent.showResIdImageBrowse(mContext, R.mipmap.jcw, "测试测试测试测试测试测试测试测试测试测试测试测试");
            }
        });

        //浏览多张资源图片
        btn_res_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> imageResList = new ArrayList<>();
                imageResList.add(R.mipmap.wyz);
                imageResList.add(R.mipmap.ywl);
                ImageBrowseIntent.showResIdImageBrowse(mContext, imageResList, 1);
            }
        });

        //浏览单张uri图片
        btn_uri_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ImageBrowseIntent.showUriImageBrowse(mContext,uri)", Toast.LENGTH_SHORT).show();
            }
        });

        //浏览多张uri图片
        btn_uri_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ImageBrowseIntent.showUriImageBrowse(mContext,imageUriList,position)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
