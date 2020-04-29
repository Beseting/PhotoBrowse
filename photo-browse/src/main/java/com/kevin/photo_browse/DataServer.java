package com.kevin.photo_browse;

import android.net.Uri;

import java.util.List;

/**
 * 参数数据储存服务
 */
public class DataServer {

    private List<String> imageUrlList;
    private String imageUrl;

    private List<Integer> imageResIdList;
    private Integer imageResId;

    private List<Uri> imageUriList;
    private Uri imageUri;

    private int position;

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

    private static class SingletonHolder {
        private static final DataServer INSTANCE = new DataServer();
    }

    private DataServer() {
    }

    public static final DataServer getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
