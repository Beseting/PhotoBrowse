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
     *
     * @param context
     * @param imageList
     */
    public static void showUrlImageBrowse(Context context, List<String> imageList, int position) {
        showUrlImageBrowse(context, imageList, position, null, null);
    }

    /**
     * 浏览多张网络加载的图片 带标题数组
     *
     * @param context
     * @param imageList
     */
    public static void showUrlImageBrowse(Context context, List<String> imageList, int position, List<String> titleList, DataServer.ClickCallback clickCallback) {
        Intent intent = new Intent(context, ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM, ImageBrowseActivity.FLAG_ENUM[0]);
        DataServer.getInstance().setImageUrlList(imageList);
        DataServer.getInstance().setPosition(position);
        DataServer.getInstance().setTitleList(titleList);
        DataServer.getInstance().setClickCallback(clickCallback);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 浏览单张网络加载的图片
     *
     * @param context
     * @param imageUrl
     **/
    public static void showUrlImageBrowse(Context context, String imageUrl) {
        showUrlImageBrowse(context, imageUrl, null);
    }

    /**
     * 浏览单张网络加载的图片 带标题
     *
     * @param context
     * @param imageUrl
     **/
    public static void showUrlImageBrowse(Context context, String imageUrl, String title) {
        Intent intent = new Intent(context, ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM, ImageBrowseActivity.FLAG_ENUM[1]);
        DataServer.getInstance().setImageUrl(imageUrl);
        DataServer.getInstance().setTitle(title);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 浏览多张资源文件的图片
     *
     * @param context
     * @param imageResIdList
     **/
    public static void showResIdImageBrowse(Context context, List<Integer> imageResIdList, int position) {
        showResIdImageBrowse(context, imageResIdList, position, null);
    }

    /**
     * 浏览多张资源文件的图片 带标题数组
     *
     * @param context
     * @param imageResIdList
     **/
    public static void showResIdImageBrowse(Context context, List<Integer> imageResIdList, int position, List<String> titleList) {
        Intent intent = new Intent(context, ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM, ImageBrowseActivity.FLAG_ENUM[2]);
        DataServer.getInstance().setPosition(position);
        DataServer.getInstance().setImageResIdList(imageResIdList);
        DataServer.getInstance().setTitleList(titleList);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 浏览单张资源加载的图片
     *
     * @param context
     * @param imageResId
     **/
    public static void showResIdImageBrowse(Context context, int imageResId) {
        showResIdImageBrowse(context, imageResId, null);
    }

    /**
     * 浏览单张资源加载的图片 带标题
     *
     * @param context
     * @param imageResId
     **/
    public static void showResIdImageBrowse(Context context, int imageResId, String title) {
        Intent intent = new Intent(context, ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM, ImageBrowseActivity.FLAG_ENUM[3]);
        DataServer.getInstance().setImageResId(imageResId);
        DataServer.getInstance().setTitle(title);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 浏览多张Uri文件的图片
     *
     * @param context
     * @param imageUriList
     **/
    public static void showUriImageBrowse(Context context, List<Uri> imageUriList, int position) {
        showUriImageBrowse(context, imageUriList, position, null);
    }

    /**
     * 浏览多张Uri文件的图片 带标题数组
     *
     * @param context
     * @param imageUriList
     **/
    public static void showUriImageBrowse(Context context, List<Uri> imageUriList, int position, List<String> titleList) {
        Intent intent = new Intent(context, ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM, ImageBrowseActivity.FLAG_ENUM[4]);
        DataServer.getInstance().setPosition(position);
        DataServer.getInstance().setImageUriList(imageUriList);
        DataServer.getInstance().setTitleList(titleList);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 浏览单张Uri加载的图片
     *
     * @param context
     * @param imageUri
     **/
    public static void showUriImageBrowse(Context context, Uri imageUri) {
        showUriImageBrowse(context, imageUri, null);
    }

    /**
     * 浏览单张Uri加载的图片 带标题
     *
     * @param context
     * @param imageUri
     **/
    public static void showUriImageBrowse(Context context, Uri imageUri, String title) {
        Intent intent = new Intent(context, ImageBrowseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_FLAG_ENUM, ImageBrowseActivity.FLAG_ENUM[5]);
        DataServer.getInstance().setImageUri(imageUri);
        DataServer.getInstance().setTitle(title);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
