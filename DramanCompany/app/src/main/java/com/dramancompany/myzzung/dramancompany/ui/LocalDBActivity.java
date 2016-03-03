package com.dramancompany.myzzung.dramancompany.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.dramancompany.myzzung.dramancompany.R;
import com.dramancompany.myzzung.dramancompany.adapter.CardListAdapter;
import com.dramancompany.myzzung.dramancompany.model.MyCard;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LocalDBActivity extends AppCompatActivity {

    private final String TAG = "LocalDBActivity";

    private ListView listView;
    private CardListAdapter mAdapter;
    private ArrayList<MyCard> mList;

    private EditText input_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_db);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        listView = (ListView)findViewById(R.id.card_listview);

        input_search = (EditText)findViewById(R.id.input_search);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "textchange call"+s.toString());
            }
        };

        input_search.addTextChangedListener(watcher);

        mList = new ArrayList<MyCard>();

        mList.add(new MyCard("이준수","드라마앤컴퍼니","안드로이드","개발부서","010-7138-6209","서울"));
        mList.add(new MyCard("안녕안녕","삼성","서버","개발팀","010-111-1111","인천"));

//        mList.add(new MyCard("오오오","삼성","웹"));

        mAdapter = new CardListAdapter(mList);

        listView.setAdapter(mAdapter);

    }

    public void doSearch(View v){
        mAdapter.addItem(new MyCard("이름이름","엘지","안드로이드","개발준비","010-2222-2222","서울"));
        mAdapter.notifyDataSetChanged();
    }

}
