package com.dramancompany.myzzung.dramancompany.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.TtsSpan;
import android.util.Log;

import com.dramancompany.myzzung.dramancompany.model.MyCard;
import com.dramancompany.myzzung.dramancompany.util.CardUtil;
import com.dramancompany.myzzung.dramancompany.util.DCDBUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by myZZUNG on 2016. 3. 1..
 */
public class CardDBHelper extends SQLiteOpenHelper {

    private final String TAG = "CardDBHelper";

    private Context mContext;

    private SQLiteDatabase readDB;

    public CardDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        this.mContext = context;
        readDB = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade");
    }

    public void createTable(String tableName){
        SQLiteDatabase db = getWritableDatabase();
        if(DCDBUtil.CARD_TABLE_NAME.equals(tableName)){
            String columns = "( "+DCDBUtil.CARD_COL_PK+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DCDBUtil.CARD_COL_NAME+" TEXT, " +
                    DCDBUtil.CARD_COL_COMPANY+" TEXT, "+
                    DCDBUtil.CARD_COL_POSITION+" TEXT, "+
                    DCDBUtil.CARD_COL_DEPARTMENT+" TEXT, "+
                    DCDBUtil.CARD_COL_PHONE+" TEXT, "+
                    DCDBUtil.CARD_COL_ADDRESS+" TEXT );";
            String _query = "CREATE TABLE IF NOT EXISTS "+tableName+" "+columns;
            Log.d(TAG, "create table : "+_query);
            db.execSQL(_query);
        }

        db.close();
    }

    public void dropTable(String tableName){
        SQLiteDatabase db = getWritableDatabase();
        String _query = "drop table if exists "+tableName;
        db.execSQL(_query);
        db.close();
    }

    public void insertData(String tableName, MyCard cardItem) {
        SQLiteDatabase db = getWritableDatabase();
        if(tableName.equals(DCDBUtil.CARD_TABLE_NAME)){
            String _query = "insert into "+tableName+
                    " values(null, '"+cardItem.getmName()+
                    "','"+cardItem.getmCompany()+
                    "','"+cardItem.getmPosition()+
                    "','"+cardItem.getmDepartment()+
                    "','"+cardItem.getmPhone()+
                    "','"+cardItem.getmAddress()+"');";
            Log.d(TAG, "insert : "+_query);
            db.execSQL(_query);
        }

        db.close();
    }

    public void update(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

//    public void delete(String tableName, String dele, int flag) {
//        SQLiteDatabase db = getWritableDatabase();
//        String _query;
//        switch(flag){
//            case DBSupport.BY_ID:
//                _query = "delete from "+tableName+" where _id = '" + dele + "';";
//                break;
//            case DBSupport.BY_NAME:
//                _query = "delete from "+tableName+" where name = '" + dele + "';";
//                break;
//            case DBSupport.BY_INGREDITENT:
//                _query = "delete from "+tableName+" where ingredient = '" + dele + "';";
//                break;
//            default:
//                db.close();
//                return;
//
//        }
//        db.execSQL(_query);
//        db.close();
//    }
//
    public String PrintData(String tableName) {
        SQLiteDatabase db = getReadableDatabase();
        String str = "";

        try{
            Cursor cursor = db.rawQuery("select * from "+tableName, null);
            while (cursor.moveToNext()) {
                str += cursor.getInt(cursor.getColumnIndex(DCDBUtil.CARD_COL_PK))
                        + " : name : "
                        + cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_NAME))
                        + " : company : "
                        + cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_COMPANY))
                        + " : position : "
                        + cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_POSITION))
                        + " : department : "
                        + cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_DEPARTMENT))
                        + " : phone : "
                        + cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_PHONE))
                        + " : address : "
                        + cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_ADDRESS))
                        + "\n";
            }
            return str;
        }catch(Exception e){
            return "no table";
        }
    }

    public ArrayList<MyCard> SearchData(String tableName, String target){
        ArrayList<MyCard> newList = new ArrayList<MyCard>();

        if(target==null || target.equals("")){
            return newList;
        }

        try{
            Cursor cursor = readDB.rawQuery("select * from "+tableName, null);
            while (cursor.moveToNext()){
                if(cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_NAME)).contains(target)){
                    MyCard item = new MyCard(cursor, CardUtil.SEARCH_TYPE_NAME);
                    newList.add(item);
                }else if(cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_COMPANY)).contains(target)){
                    MyCard item = new MyCard(cursor, CardUtil.SEARCH_TYPE_COMPANY);
                    newList.add(item);
                }else if(cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_POSITION)).contains(target)){
                    MyCard item = new MyCard(cursor, CardUtil.SEARCH_TYPE_POSITION);
                    newList.add(item);
                }else if(cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_DEPARTMENT)).contains(target)){
                    MyCard item = new MyCard(cursor, CardUtil.SEARCH_TYPE_DEPARTMENT);
                    newList.add(item);
                }else if(cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_PHONE)).contains(target)){
                    MyCard item = new MyCard(cursor, CardUtil.SEARCH_TYPE_PHONE);
                    newList.add(item);
                }else if(cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_ADDRESS)).contains(target)){
                    MyCard item = new MyCard(cursor, CardUtil.SEARCH_TYPE_ADDRESS);
                    newList.add(item);
                }
            }
        }catch (Exception e){
            return newList;
        }

        return  newList;
    }


}
