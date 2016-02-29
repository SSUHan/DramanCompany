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
import com.dramancompany.myzzung.dramancompany.helper.ImageDownHelper;

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
    private ImageDownHelper imageHelper;

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
        imageHelper = new ImageDownHelper(getApplicationContext(),image_url,imageview1);

    }

    public void doImageBtn1(View v){
        imageHelper.execute();
    }

    public void doImageBtn2(View v){
        //GetImageByUrl(image_url,imageview2);
    }

    public void doImageBtn3(View v){
        //GetImageByUrl(image_url,imageview3);
    }

//    private Bitmap GetImageByUrl(String image_url, ImageView imageView){
//
//    }

}
