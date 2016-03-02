package com.dramancompany.myzzung.dramancompany.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.dramancompany.myzzung.dramancompany.R;
import com.dramancompany.myzzung.dramancompany.adapter.CardListAdapter;
import com.dramancompany.myzzung.dramancompany.model.MyCard;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LocalDBActivity extends AppCompatActivity {


    private ListView listView;
    private CardListAdapter mAdapter;
    private ArrayList<MyCard> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_db);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        listView = (ListView)findViewById(R.id.card_listview);

        mList = new ArrayList<MyCard>();

//        mList.add(new MyCard("이준수","드라마앤컴퍼니","안드로이드"));
//        mList.add(new MyCard("안녕안녕","삼성","서버"));
//        mList.add(new MyCard("이름이름","엘지","안드로이드"));
//        mList.add(new MyCard("오오오","삼성","웹"));

        mAdapter = new CardListAdapter(mList);

        listView.setAdapter(mAdapter);

    }

}
