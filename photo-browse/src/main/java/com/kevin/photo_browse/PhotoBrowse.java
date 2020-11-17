package com.kevin.photo_browse;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.kevin.photo_browse.callabck.ClickCallback;
import com.kevin.photo_browse.ui.ImageBrowseActivity;

import java.util.List;

public class PhotoBrowse {

    private Activity activity;
    private ShowType showType;

    private PhotoBrowse(Activity activity) {
        this.activity = activity;
    }

    public static PhotoBrowse with(Activity activity) {
        return new PhotoBrowse(activity);
    }

    public PhotoBrowse showType(ShowType showType) {
        this.showType = showType;
        DataServer.getInstance().setShowType(showType);
        return this;
    }

    public PhotoBrowse title(String title) {
        DataServer.getInstance().setTitle(title);
        return this;
    }

    public PhotoBrowse title(List<String> titles) {
        DataServer.getInstance().setTitleList(titles);
        return this;
    }

    public PhotoBrowse position(Integer position) {
        DataServer.getInstance().setPosition(position);
        return this;
    }

    public PhotoBrowse url(String url) {
        DataServer.getInstance().setImageUrl(url);
        return this;
    }

    public PhotoBrowse url(List<String> urls) {
        DataServer.getInstance().setImageUrlList(urls);
        return this;
    }

    public PhotoBrowse res(Integer res) {
        DataServer.getInstance().setImageResId(res);
        return this;
    }

    public PhotoBrowse res(List<Integer> res) {
        DataServer.getInstance().setImageResIdList(res);
        return this;
    }

    public PhotoBrowse uri(Uri uri) {
        DataServer.getInstance().setImageUri(uri);
        return this;
    }

    public PhotoBrowse uri(List<Uri> uri) {
        DataServer.getInstance().setImageUriList(uri);
        return this;
    }

    public PhotoBrowse callback(ClickCallback clickCallback) {
        DataServer.getInstance().setClickCallback(clickCallback);
        return this;
    }

    /**
     * 显示
     */
    public void show() {
        if (this.showType == null)
            throw new RuntimeException("ShowType Not Configured!");
        if (isEmpty(DataServer.getInstance().getPosition()))
            DataServer.getInstance().setPosition(0);
        Intent intent = new Intent(activity, ImageBrowseActivity.class);
        switch (this.showType) {
            case SINGLE_URL:
                if (isEmpty(DataServer.getInstance().getImageUrl()))
                    throw new RuntimeException("ImageUrl Not Configured!");
                break;
            case MULTIPLE_URL:
                if (isEmpty(DataServer.getInstance().getImageUrlList()))
                    throw new RuntimeException("The ImageUrlList Not Be NULL And Size Must Greater Than Zero!");
                if (DataServer.getInstance().getPosition() > DataServer.getInstance().getImageUrlList().size() - 1)
                    throw new RuntimeException("The Position Greater Than List Size!");
                break;
            case SINGLE_RES:
                if (isEmpty(DataServer.getInstance().getImageResId()))
                    throw new RuntimeException("ImageRes Not Configured!");
                break;
            case MULTIPLE_RES:
                if (isEmpty(DataServer.getInstance().getImageResIdList()))
                    throw new RuntimeException("The ImageResList Not Be NULL And Size Must Greater Than Zero!");
                if (DataServer.getInstance().getPosition() > DataServer.getInstance().getImageResIdList().size() - 1)
                    throw new RuntimeException("The Position Greater Than List Size!");
                break;
            case SINGLE_URI:
                if (isEmpty(DataServer.getInstance().getImageUri()))
                    throw new RuntimeException("ImageUri Not Configured!");
                break;
            case MULTIPLE_URI:
                if (isEmpty(DataServer.getInstance().getImageUriList()))
                    throw new RuntimeException("The ImageUriList Not Be NULL And Size Must Greater Than Zero!");
                if (DataServer.getInstance().getPosition() > DataServer.getInstance().getImageUriList().size() - 1)
                    throw new RuntimeException("The Position Greater Than List Size!");
                break;
            default:
                return;
        }
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.anim_activity_in, 0);
    }

    /**
     * 判空
     *
     * @param obj
     * @return
     */
    private boolean isEmpty(Object obj) {
        if (obj == null)
            return true;
        if (obj instanceof String) {
            return String.valueOf(obj).equals("");
        } else if (obj instanceof Integer) {
            return Integer.parseInt(obj.toString()) == 0;
        } else if (obj instanceof List) {
            return ((List) obj).size() == 0;
        } else {
            return false;
        }
    }
}
