package com.kevin;

import android.app.Activity;
import android.net.Uri;

public interface IClickCallback {
    void onClick(String imageUrl);

    void onClick(int resId);

    void onClick(Uri imageUri);

    void onLongClick(Activity activity,String imageUrl);

    void onLongClick(int resId);

    void onLongClick(Uri imageUri);
}
