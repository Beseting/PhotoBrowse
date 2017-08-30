package com.kevin.photo_browse.utils;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kevin.photo_browse.R;

/**
 * Created by Kevin on 2017/8/22.
 */

public class GlideUtils {
    public static void load(final Activity activity, Object url, ImageView imageView, boolean isClickFinish){
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.error(R.drawable.banner_default);
        requestOptions.placeholder(R.drawable.banner_default);
        Glide.with(activity).setDefaultRequestOptions(requestOptions).load(url).into(imageView);
        if(isClickFinish){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
    }
}
