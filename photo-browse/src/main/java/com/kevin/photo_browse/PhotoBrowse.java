package com.kevin.photo_browse;

import android.app.Activity;
import android.net.Uri;

import java.util.List;

/**
 * PhotoBrowse => PB
 * Create By Kevin on 2020/11/16
 */
public class PhotoBrowse {

    private Activity mActivity;
    private List<String> imageUrlList;
    private String imageUrl;

    private List<String> titleList;
    private String title;

    private List<Integer> imageResIdList;
    private Integer imageResId;

    private List<Uri> imageUriList;
    private Uri imageUri;

    private int position;

    private PhotoBrowse(Activity activity) {
        this.mActivity = activity;
    }

    public static PhotoBrowse with(Activity activity) {
        return new PhotoBrowse(activity);
    }

    public SourceTypeCreator sourceType(SourceType sourceType) {
        return new SourceTypeCreator(sourceType);
    }

    public void withUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}
