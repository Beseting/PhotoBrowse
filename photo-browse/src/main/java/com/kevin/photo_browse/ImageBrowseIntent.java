package com.kevin.photo_browse;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.kevin.photo_browse.ui.ImageBrowseActivity;

import java.util.List;

/**
 * Created by Kevin on 2017/8/22.
 */

public class ImageBrowseIntent {
    public static String PARAM_FLAG_ENUM = "param_flag_enum";

    /**
     * 浏览多张网络加载的图片
    * @param context
    * @param imageList
    * */
    public static void showUrlImageBrowse(Context context, List<String> imageList, int position){
        Intent intent = new Intent(context,ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM,ImageBrowseActivity.FLAG_ENUM[0]);
        DataServer.getInstance().setImageUrlList(imageList);
        DataServer.getInstance().setPosition(position);
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
        DataServer.getInstance().setImageUrl(imageUrl);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     *  浏览多张资源文件的图片
     * @param context
     * @param imageResIdList
     * **/
    public static void showResIdImageBrowse(Context context, List<Integer> imageResIdList, int position){
        Intent intent = new Intent(context,ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM,ImageBrowseActivity.FLAG_ENUM[2]);
        DataServer.getInstance().setPosition(position);
        DataServer.getInstance().setImageResIdList(imageResIdList);
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
        DataServer.getInstance().setImageResId(imageResId);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     *  浏览多张Uri文件的图片
     * @param context
     * @param imageUriList
     * **/
    public static void showUriImageBrowse(Context context, List<Uri> imageUriList, int position){
        Intent intent = new Intent(context,ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM,ImageBrowseActivity.FLAG_ENUM[4]);
        DataServer.getInstance().setPosition(position);
        DataServer.getInstance().setImageUriList(imageUriList);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     *  浏览单张Uri加载的图片
     * @param context
     * @param imageUri
     * **/
    public static void showUriImageBrowse(Context context, Uri imageUri){
        Intent intent = new Intent(context,ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM,ImageBrowseActivity.FLAG_ENUM[5]);
        DataServer.getInstance().setImageUri(imageUri);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
