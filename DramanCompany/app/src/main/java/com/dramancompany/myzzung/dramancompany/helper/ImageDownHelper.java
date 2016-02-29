package com.dramancompany.myzzung.dramancompany.helper;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Created by myZZUNG on 2016. 3. 1..
 */
public class ImageDownHelper extends AsyncTask {

    private String mImageUrl;
    private ImageView mImageView;

    public ImageDownHelper(){

    }

    public ImageDownHelper(String image_url, ImageView imageView){
        mImageUrl = image_url;
        mImageView = imageView;
    }
    @Override
    protected Bitmap doInBackground(Object[] params) {
        return null;
    }

    
}
