package com.kevin.photo_browse;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Jabez on 2017/8/29.
 */

public class BitmapModel implements Serializable {
    private Bitmap bitmap;

    public BitmapModel() {
    }

    public BitmapModel(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
