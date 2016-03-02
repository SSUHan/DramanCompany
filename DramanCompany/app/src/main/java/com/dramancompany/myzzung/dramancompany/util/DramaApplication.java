package com.dramancompany.myzzung.dramancompany.util;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.dramancompany.myzzung.dramancompany.helper.CardDBHelper;
import com.dramancompany.myzzung.dramancompany.model.MyCard;

/**
 * Created by myZZUNG on 2016. 3. 2..
 */
public class DramaApplication extends Application {

    private final String TAG = "DramaApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        boolean do_insert = initLocalDB();
        Log.d(TAG, "do insert : "+do_insert);
    }

    /**
     * 처음에 단 한번만 디비에 예제를 위한 데이터를 입력합니다
     */
    private boolean initLocalDB(){
        SharedPreferences pref = getSharedPreferences("drama",MODE_PRIVATE);
        boolean is_fisrt = pref.getBoolean("is_first", true);
        CardDBHelper dbHelper = new CardDBHelper(this,DCDBUtil.DB_NAME, null, 1);
        if(is_fisrt){
            // do db insert data

            dbHelper.createTable(DCDBUtil.CARD_TABLE_NAME);
            dbHelper.insertData(DCDBUtil.CARD_TABLE_NAME, new MyCard("이준수", "드라마", "안드로이드", "개발팀", "010-7138-6209", "서울"));

            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("is_first",false);
            editor.commit();

            Log.d(TAG, dbHelper.PrintData(DCDBUtil.CARD_TABLE_NAME));
        }else{
            // do not db insert data
            Log.d(TAG, dbHelper.PrintData(DCDBUtil.CARD_TABLE_NAME));
        }
        return is_fisrt;
    }
}
