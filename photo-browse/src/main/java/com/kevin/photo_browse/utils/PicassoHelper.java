package com.kevin.photo_browse.utils;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.kevin.photo_browse.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Kevin on 2017/8/22.
 */

public final class PicassoHelper {
    public static void load(Object url, ImageView imageView) {
        if(url instanceof Integer){
            Picasso.get().load((int)url).placeholder(R.drawable.img_placeholder).error(R.drawable.img_error).into(imageView);
        }else if(url instanceof String){
            Picasso.get().load(url.toString()).placeholder(R.drawable.img_placeholder).error(R.drawable.img_error).into(imageView);
        }
    }

    public static void load(final Activity activity, Object url, ImageView imageView, boolean isClickFinish) {
        if(url instanceof Integer){
            Picasso.get().load((int)url).placeholder(R.drawable.img_placeholder).error(R.drawable.img_error).into(imageView);
        }else if(url instanceof String){
            Picasso.get().load(url.toString()).placeholder(R.drawable.img_placeholder).error(R.drawable.img_error).into(imageView);
        }
        if (isClickFinish) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
    }

    public static void load(Object url, ImageView imageView, int placeHolderRes, int errorRes) {
        if (url instanceof String) {
            Picasso.get().load(url.toString()).placeholder(placeHolderRes).error(errorRes).into(imageView);
        } else if (url instanceof Integer) {
            Picasso.get().load((int) url).placeholder(placeHolderRes).error(errorRes).into(imageView);
        }
    }

    public static void load(final Activity activity,Object url, ImageView imageView, int placeHolderRes, int errorRes,boolean isClickFinish) {
        if (url instanceof String) {
            Picasso.get().load(url.toString()).placeholder(placeHolderRes).error(errorRes).into(imageView);
        } else if (url instanceof Integer) {
            Picasso.get().load((int) url).placeholder(placeHolderRes).error(errorRes).into(imageView);
        }
        if (isClickFinish) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
    }
}
