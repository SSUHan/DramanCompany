package com.dramancompany.myzzung.dramancompany.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.TtsSpan;
import android.util.Log;

/**
 * Created by myZZUNG on 2016. 3. 1..
 */
public class CardDBHelper extends SQLiteOpenHelper {

    private final String TAG = "CardDBHelper";

    private Context mContext;

    public CardDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG,"onUpgrade");
    }
}
