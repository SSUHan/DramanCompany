package com.dramancompany.myzzung.dramancompany.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
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
    private LruCache<String, Bitmap> mCache;

    public ImageDownHelper(){

    }

    /**
     *
     * @param context
     * @param image_url 이미지 url 주소
     * @param imageView 적용시킬 이미지 View 주소
     * @param cache 메모리캐시 주소
     */
    public ImageDownHelper(Context context, String image_url, ImageView imageView, LruCache<String, Bitmap> cache){
        mContext = context;
        mImageUrl = image_url;
        mImageView = imageView;
        this.mCache = cache;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = null;
        publishProgress(0);
        if(mCache.get(mImageUrl) != null){
            bitmap = mCache.get(mImageUrl);
            Log.d(TAG,"캐시에서 가져옵니다");
            publishProgress(1);
        }else{
            // network only do when there is no cache memory
            try{
                URL url = new URL(mImageUrl);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.connect();
                publishProgress(1);

                int cSize = conn.getContentLength();
                Log.d(TAG, "cSize : " + cSize);
                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream(),cSize);
                bitmap = BitmapFactory.decodeStream(bis);
                bis.close();
                publishProgress(2);

                if(bitmap != null){
                    mCache.put(mImageUrl, bitmap);
                    Log.d(TAG, "캐시에 저장합니다");
                    publishProgress(3);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        publishProgress(4);

        return bitmap;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate : ["+values[0]+"]");
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        if(bitmap == null){
            Toast.makeText(mContext, "Bitmap이 null입니다", Toast.LENGTH_SHORT).show();

        }else{
            //BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            //mImageView.setBackground(bitmapDrawable);
            mImageView.setImageBitmap(bitmap);

        }
    }
}
