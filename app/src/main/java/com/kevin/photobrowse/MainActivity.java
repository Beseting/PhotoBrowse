package com.kevin.photobrowse;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kevin.photo_browse.ImageBrowseIntent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Button btn_url_single,btn_url_group,btn_res_single,btn_res_group,btn_bitmap_group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mContext = this;
        init();
    }

    private void init(){
        btn_url_single = (Button) findViewById(R.id.btn_url_single);
        btn_url_group = (Button) findViewById(R.id.btn_url_group);
        btn_res_single = (Button) findViewById(R.id.btn_res_single);
        btn_res_group = (Button) findViewById(R.id.btn_res_group);
        btn_bitmap_group = (Button) findViewById(R.id.btn_bitmap_group);

        //浏览单张网络图片
        btn_url_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageBrowseIntent.showUrlImageBrowse(mContext,"http://pic2.sc.chinaz.com/files/pic/pic9/201204/xpic4181.jpg");
            }
        });

        //浏览多张网络图片
        btn_url_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> imageList = new ArrayList<>();
                imageList.add("http://img3.duitang.com/uploads/item/201607/15/20160715171249_fmztu.gif");
                imageList.add("http://i0.hdslb.com/bfs/archive/dfd38947e9b971e06d113425a863e4e7b5715335.jpg");
                imageList.add("http://npic7.edushi.com/cn/zixun/zh-chs/2017-07/24/4050488-2017072415380279.jpg");
                ImageBrowseIntent.showUrlImageBrowse(mContext,imageList,0);
            }
        });

        //浏览单张资源图片
        btn_res_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageBrowseIntent.showResIdImageBrowse(mContext,R.mipmap.jcw);
            }
        });

        //浏览多张资源图片
        btn_res_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> imageResList = new ArrayList<>();
                imageResList.add(R.mipmap.wyz);
                imageResList.add(R.mipmap.ywl);
                ImageBrowseIntent.showResIdImageBrowse(mContext,imageResList,0);
            }
        });

        //浏览多张Bitmap
        btn_bitmap_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Bitmap> bitmapList = new ArrayList<>();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.tyl);
                bitmapList.add(bitmap);
//                bitmapList.add(BitmapFactory.decodeResource(getResources(),R.mipmap.zjl));
                ImageBrowseIntent.showBitmapBrowse(mContext,bitmapList,0);
            }
        });
    }
}
