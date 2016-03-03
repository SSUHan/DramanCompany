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
            dbHelper.insertData(DCDBUtil.CARD_TABLE_NAME, new MyCard("김혜지", "드라마", "서버", "서버개발팀", "010-1111-6789", "서울"));
            dbHelper.insertData(DCDBUtil.CARD_TABLE_NAME, new MyCard("우정미", "이스트몹", "마케팅", "마케팅팀", "010-2222-6229", "인천"));
            dbHelper.insertData(DCDBUtil.CARD_TABLE_NAME, new MyCard("이호신", "원티드", "마케팅", "해외마케팅", "010-3333-5555", "부산"));
            dbHelper.insertData(DCDBUtil.CARD_TABLE_NAME, new MyCard("은원기", "코노랩스", "디자인", "UI디자인", "010-9999-6666", "부산"));
            dbHelper.insertData(DCDBUtil.CARD_TABLE_NAME, new MyCard("임선희", "드라마", "청소", "관리팀", "010-7138-6209", "대구"));
            dbHelper.insertData(DCDBUtil.CARD_TABLE_NAME, new MyCard("강도비", "가우디", "디자인", "디자인팀", "010-7138-6209", "대전"));
            dbHelper.insertData(DCDBUtil.CARD_TABLE_NAME, new MyCard("윤건택", "매버릭", "기술경영", "개발팀", "010-7138-6209", "대전"));
            dbHelper.insertData(DCDBUtil.CARD_TABLE_NAME, new MyCard("우우우", "카페인", "안드로이드", "기술팀", "010-7138-6209", "서울"));
            dbHelper.insertData(DCDBUtil.CARD_TABLE_NAME, new MyCard("김볼빵", "핀다", "영업", "영업팀", "010-7138-6209", "인천"));

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
