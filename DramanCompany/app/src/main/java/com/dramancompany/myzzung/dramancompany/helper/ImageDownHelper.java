package com.dramancompany.myzzung.dramancompany.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by myZZUNG on 2016. 3. 1..
 */
public class ImageDownHelper extends AsyncTask<String, Integer, Bitmap> {

    private String TAG = "ImageDownHelper";

    private String mImageUrl;
    private ImageView mImageView;
    private Context mContext;

    public ImageDownHelper(){

    }

    public ImageDownHelper(Context context, String image_url, ImageView imageView){
        mContext = context;
        mImageUrl = image_url;
        mImageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = null;
        try{
            URL url = new URL(mImageUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.connect();

            int cSize = conn.getContentLength();
            Log.d(TAG, "cSize : " + cSize);
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream(),cSize);
            bitmap = BitmapFactory.decodeStream(bis);
            bis.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        if(bitmap == null){
            Toast.makeText(mContext, "Bitmap이 null입니다", Toast.LENGTH_SHORT).show();

        }else{
            mImageView.setImageBitmap(bitmap);
        }
    }
}
