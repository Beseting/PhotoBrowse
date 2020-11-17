package com.kevin.photobrowse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kevin.photo_browse.PhotoBrowse;
import com.kevin.photo_browse.ShowType;
import com.kevin.photo_browse.callabck.ClickCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Button btn_url_single = findViewById(R.id.btn_url_single);
        Button btn_url_group = findViewById(R.id.btn_url_group);
        Button btn_res_single = findViewById(R.id.btn_res_single);
        Button btn_res_group = findViewById(R.id.btn_res_group);
        Button btn_uri_single = findViewById(R.id.btn_uri_single);
        Button btn_uri_group = findViewById(R.id.btn_uri_group);

        //浏览单张网络图片
        btn_url_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhotoBrowse.with(MainActivity.this)
                        .showType(ShowType.SINGLE_URL)
                        .url("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1213917104,3274061808&fm=26&gp=0.jpg")
                        .title("港星女神周慧敏,被颜值盖过的十项全能才女,亚洲第一偶像天后!")
                        .show();
            }
        });

        //浏览多张网络图片
        btn_url_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> imageList = new ArrayList<>();
                imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605605280562&di=f0afe991cc0483d3775056a7fda7e16d&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn08%2F777%2Fw993h584%2F20181031%2Faa89-hnfikvc5826403.png");
                imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605605241688&di=47e02706355fb725aad783806f14e464&imgtype=0&src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_match%2F0%2F6212494362%2F0.jpg");
                imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605605410234&di=7a5ed0fff39f13f2167ea1507f1bb1c5&imgtype=0&src=http%3A%2F%2Fimg6.aili.com%2F201610%2F13%2F1476325737_52847600.jpg");
                List<String> titleList = new ArrayList<>();
                titleList.add("诺贝尔级“肽”抗衰领域全新应用，朱茵亲临樊文花新品发布会引领逆龄风潮");
                titleList.add("有一种爱情，叫黄贯中与朱茵");
                PhotoBrowse.with(MainActivity.this)
                        .showType(ShowType.MULTIPLE_URL)
                        .url(imageList)
                        .title(titleList)
                        .position(2)//初始预览位置 默认0
                        .callback(new ClickCallback() {
                            @Override
                            public void onClick(Activity activity, String url, int position) {
                                super.onClick(activity, url, position);
                                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onLongClick(Activity activity, String url, int position) {
                                super.onLongClick(activity, url, position);
                                Toast.makeText(MainActivity.this, "长按", Toast.LENGTH_LONG).show();
                            }
                        })//点击事件回调，默认点击退出
                        .show();
            }
        });

        //浏览单张资源图片
        btn_res_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhotoBrowse.with(MainActivity.this)
                        .showType(ShowType.SINGLE_RES)
                        .res(R.mipmap.jcw)
                        .show();
            }
        });

        //浏览多张资源图片
        btn_res_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Integer> imageResList = new ArrayList<>();
                imageResList.add(R.mipmap.wyz);
                imageResList.add(R.mipmap.ywl);
                PhotoBrowse.with(MainActivity.this)
                        .showType(ShowType.MULTIPLE_RES)
                        .res(imageResList)
                        .show();
            }
        });

        //浏览单张uri图片
        btn_uri_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "To See Source Code", Toast.LENGTH_SHORT).show();
            }
        });

        //浏览多张uri图片
        btn_uri_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "To See Source Code", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
