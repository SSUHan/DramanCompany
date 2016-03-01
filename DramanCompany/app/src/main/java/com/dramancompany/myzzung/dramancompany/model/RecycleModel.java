package com.dramancompany.myzzung.dramancompany.model;

/**
 * Created by myZZUNG on 2016. 3. 2..
 */
public class RecycleModel {

    private int mId;
    private String mName;
    private String mCompany;

    public RecycleModel(int id, String name, String company){
        this.mId = id;
        this.mName = name;
        this.mCompany = company;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
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
}
