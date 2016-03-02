package com.dramancompany.myzzung.dramancompany.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.TextView;

import com.dramancompany.myzzung.dramancompany.R;

public class SharedElementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition));
        }
        setContentView(R.layout.activity_shared_element);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);

        /**
         * transitionName 은 자리를 지정해주는 것이지, 그 내용물까지 지정해주지 않는다
         * 따라서 Intent로 그 내용물은 보내 주고 받아야 한다
         */
        Intent intent = getIntent();
        TextView shared_textview = (TextView)findViewById(R.id.shared_textview);
        shared_textview.setText(intent.getStringExtra("shared_key"));



    }

}
