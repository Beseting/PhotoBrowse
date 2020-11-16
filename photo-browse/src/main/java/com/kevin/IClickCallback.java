package com.kevin;

import android.net.Uri;

public interface IClickCallback {
    void onClick(String imageUrl);

    void onClick(int resId);

    void onClick(Uri imageUri);

    void onLongClick(String imageUrl);

    void onLongClick(int resId);

    void onLongClick(Uri imageUri);
}
