package com.kevin.photo_browse;

import android.net.Uri;

import com.kevin.IClickCallback;

import java.util.List;

/**
 * 参数数据储存服务
 */
public class DataServer {

    private List<String> imageUrlList;
    private String imageUrl;

    private List<String> titleList;
    private String title;

    private List<Integer> imageResIdList;
    private Integer imageResId;

    private List<Uri> imageUriList;
    private Uri imageUri;

    private int position;
    private ClickCallback clickCallback;

    public static class ClickCallback implements IClickCallback {
        @Override
        public void onClick(String imageUrl) {

        }

        @Override
        public void onClick(int resId) {

        }

        @Override
        public void onClick(Uri imageUri) {

        }

        @Override
        public void onLongClick(String imageUrl) {

        }

        @Override
        public void onLongClick(int resId) {

        }

        @Override
        public void onLongClick(Uri imageUri) {

        }
    }

    public List<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<String> titleList) {
        this.titleList = titleList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getImageResIdList() {
        return imageResIdList;
    }

    public void setImageResIdList(List<Integer> imageResIdList) {
        this.imageResIdList = imageResIdList;
    }

    public Integer getImageResId() {
        return imageResId;
    }

    public void setImageResId(Integer imageResId) {
        this.imageResId = imageResId;
    }

    public List<Uri> getImageUriList() {
        return imageUriList;
    }

    public void setImageUriList(List<Uri> imageUriList) {
        this.imageUriList = imageUriList;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ClickCallback getClickCallback() {
        return clickCallback;
    }

    public void setClickCallback(ClickCallback clickCallback) {
        this.clickCallback = clickCallback;
    }

    public void clear() {
        this.imageUrlList = null;
        this.imageUrl = null;
        this.titleList = null;
        this.title = null;
        this.imageResIdList = null;
        this.imageResId = null;
        this.imageUriList = null;
        this.imageUri = null;
        this.position = 0;
        this.clickCallback = null;
    }

    private static class SingletonHolder {
        private static final DataServer INSTANCE = new DataServer();
    }

    private DataServer() {
    }

    public static DataServer getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
