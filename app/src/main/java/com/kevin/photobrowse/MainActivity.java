package com.kevin.photobrowse;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.kevin.photo_browse.ImageBrowseIntent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Button btn_url_single, btn_url_group, btn_res_single, btn_res_group;

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

        //浏览单张网络图片
        btn_url_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageBrowseIntent.showUrlImageBrowse(mContext, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574771473779&di=543ba9dd46968a7fe5677276bcc6c9a1&imgtype=0&src=http%3A%2F%2Fwx4.sinaimg.cn%2Fbmiddle%2F006XP2cxgy1g83uli0h4ij30u00mi4cu.jpg");
            }
        });

        //浏览多张网络图片
        btn_url_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> imageList = new ArrayList<>();
                imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574771505154&di=b61a231a622e4b40f508478d6d68ad5b&imgtype=0&src=http%3A%2F%2Fimg1.gtimg.com%2Fsports%2Fpics%2Fhv1%2F188%2F30%2F1074%2F69844688.jpg");
                imageList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2315464905,3405356132&fm=26&gp=0.jpg");
                imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574771604448&di=dcb58c9408a08113a5575943a695a164&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201606%2F20%2F20160620134552_uEXCj.thumb.700_0.jpeg");
                ImageBrowseIntent.showUrlImageBrowse(mContext, imageList, 0);
            }
        });

        //浏览单张资源图片
        btn_res_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageBrowseIntent.showResIdImageBrowse(mContext, R.mipmap.jcw);
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
    }
}
