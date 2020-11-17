package com.kevin.photo_browse.callabck;

import android.app.Activity;
import android.net.Uri;

public interface IClickCallback {
    void onClick(Activity activity, String url, int position);

    void onClick(Activity activity, int res, int position);

    void onClick(Activity activity, Uri uri, int position);

    void onLongClick(Activity activity, String url, int position);

    void onLongClick(Activity activity, int res, int position);

    void onLongClick(Activity activity, Uri uri, int position);
}
