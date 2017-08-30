package com.kevin.photo_browse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.kevin.photo_browse.ui.ImageBrowseActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jabez on 2017/8/22.
 */

public class ImageBrowseIntent {
    public static String PARAM_FLAG_ENUM = "param_flag_enum";

    public static String PARAM_POSITION = "param_position";

    public static String PARAM_URL_GROUP = "image_url_group";
    public static String PARAM_URL_SINGLE = "image_url_single";
    public static String PARAM_RES_ID_GROUP = "image_res_id_group";
    public static String PARAM_RES_ID_SINGLE = "image_res_id_single";
    public static String PARAM_BITMAP_GROUP = "image_bitmap_group";
    public static String PARAM_BITMAP_SINGLE = "image_bitmap_single";

    /**
     * 浏览多张网络加载的图片
    * @param context
    * @param imageList
    * */
    public static void showUrlImageBrowse(Context context, ArrayList<String> imageList, int position){
        Intent intent = new Intent(context,ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM,ImageBrowseActivity.FLAG_ENUM[0]);
        bundle.putInt(PARAM_POSITION,position);
        bundle.putStringArrayList(PARAM_URL_GROUP,imageList);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     *  浏览单张网络加载的图片
     * @param context
     * @param imageUrl
     * **/
    public static void showUrlImageBrowse(Context context, String imageUrl){
        Intent intent = new Intent(context,ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM,ImageBrowseActivity.FLAG_ENUM[1]);
        bundle.putString(PARAM_URL_SINGLE,imageUrl);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     *  浏览多张资源文件的图片
     * @param context
     * @param imageResIds
     * **/
    public static void showResIdImageBrowse(Context context, ArrayList<Integer> imageResIds, int position){
        Intent intent = new Intent(context,ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM,ImageBrowseActivity.FLAG_ENUM[2]);
        bundle.putInt(PARAM_POSITION,position);
        bundle.putIntegerArrayList(PARAM_RES_ID_GROUP,imageResIds);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     *  浏览单张资源加载的图片
     * @param context
     * @param imageResId
     * **/
    public static void showResIdImageBrowse(Context context, int imageResId){
        Intent intent = new Intent(context,ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM,ImageBrowseActivity.FLAG_ENUM[3]);
        bundle.putInt(PARAM_RES_ID_SINGLE,imageResId);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     *  浏览多张Bitmap
     * @param context
     * @param bitmapList
     * **/
    public static void showBitmapBrowse(Context context, List<Bitmap> bitmapList, int position){
        Intent intent = new Intent(context,ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM,ImageBrowseActivity.FLAG_ENUM[4]);
        bundle.putInt(PARAM_POSITION,position);
        bundle.putSerializable(PARAM_BITMAP_GROUP, (Serializable) bitmapList);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
