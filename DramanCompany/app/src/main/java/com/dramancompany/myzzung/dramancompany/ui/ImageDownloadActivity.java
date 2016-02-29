package com.dramancompany.myzzung.dramancompany.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dramancompany.myzzung.dramancompany.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImageDownloadActivity extends AppCompatActivity {

    private final String TAG = "ImageDownloadActivity";

    private ImageView imageview1;
    private ImageView imageview2;
    private ImageView imageview3;

    private String image_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_download);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        imageview1 = (ImageView)findViewById(R.id.imageview_1);
        imageview2 = (ImageView)findViewById(R.id.imageview_2);
        imageview3 = (ImageView)findViewById(R.id.imageview_3);

        image_url = "http://ljs93kr.cafe24.com/mysky.png";

    }

    public void doImageBtn1(View v){
        GetImageByUrl(image_url,imageview1);
    }

    public void doImageBtn2(View v){
        GetImageByUrl(image_url,imageview2);
    }

    public void doImageBtn3(View v){
        GetImageByUrl(image_url,imageview3);
    }

    private Bitmap GetImageByUrl(String image_url, ImageView imageView){
        Bitmap bitmap = null;
        try{
            URL url = new URL(image_url);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.connect();

            int cSize = conn.getContentLength();
            Log.d(TAG,"cSize : "+cSize);
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream(),cSize);
            bitmap = BitmapFactory.decodeStream(bis);
            bis.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(bitmap == null){
            Toast.makeText(ImageDownloadActivity.this, "Bitmap이 null입니다", Toast.LENGTH_SHORT).show();
            return null;
        }else{
            imageView.setImageBitmap(bitmap);
            return bitmap;
        }
    }

}
