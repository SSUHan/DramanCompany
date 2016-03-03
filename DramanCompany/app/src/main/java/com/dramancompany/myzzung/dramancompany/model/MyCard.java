package com.dramancompany.myzzung.dramancompany.model;

import android.database.Cursor;

import com.dramancompany.myzzung.dramancompany.util.CardUtil;
import com.dramancompany.myzzung.dramancompany.util.DCDBUtil;

/**
 * Created by myZZUNG on 2016. 2. 29..
 */
public class MyCard {

    private String mName;
    private String mCompany;
    private String mDepartment;
    private String mPosition;
    private String mPhone;
    private String mAddress;
    private int mSearch_type;

    public MyCard(){

    }

    public MyCard(Cursor cursor, int search_type){
        this.mName = cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_NAME));
        this.mCompany = cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_COMPANY));
        this.mPosition = cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_POSITION));
        this.mDepartment = cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_DEPARTMENT));
        this.mPhone = cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_PHONE));
        this.mAddress = cursor.getString(cursor.getColumnIndex(DCDBUtil.CARD_COL_ADDRESS));
        this.mSearch_type = search_type;
    }

    public MyCard(String name, String company, String position, String department, String phone, String address){
        this.mName = name;
        this.mCompany = company;
        this.mPosition = position;
        this.mDepartment = department;
        this.mPhone = phone;
        this.mAddress =address;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCompany() {
        return mCompany;
    }

    public void setmCompany(String mCompany) {
        this.mCompany = mCompany;
    }

    public String getmDepartment() {
        return mDepartment;
    }

    public void setmDepartment(String mDepartment) {
        this.mDepartment = mDepartment;
    }

    public String getmPosition() {
        return mPosition;
    }

    public void setmPosition(String mPosition) {
        this.mPosition = mPosition;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public int getmSearch_type() {
        return mSearch_type;
    }
    public String getMatchValue(){
        if(mSearch_type == CardUtil.SEARCH_TYPE_NAME){
            return getmName();
        }else if(mSearch_type == CardUtil.SEARCH_TYPE_COMPANY){
            return getmCompany();
        }else if(mSearch_type == CardUtil.SEARCH_TYPE_POSITION){
            return getmPosition();
        }else if(mSearch_type == CardUtil.SEARCH_TYPE_DEPARTMENT){
            return getmDepartment();
        }else if(mSearch_type == CardUtil.SEARCH_TYPE_PHONE){
            return getmPhone();
        }else if(mSearch_type == CardUtil.SEARCH_TYPE_ADDRESS){
            return getmAddress();
        }else{
            return "";
        }
    }
}
