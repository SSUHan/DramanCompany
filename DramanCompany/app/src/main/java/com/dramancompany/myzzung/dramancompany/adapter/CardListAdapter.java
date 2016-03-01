package com.dramancompany.myzzung.dramancompany.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dramancompany.myzzung.dramancompany.R;
import com.dramancompany.myzzung.dramancompany.model.MyCard;

import java.util.ArrayList;

/**
 * Created by myZZUNG on 2016. 3. 1..
 */
public class CardListAdapter extends BaseAdapter {

    private ArrayList<MyCard> mList;

    public CardListAdapter(){

    }

    public CardListAdapter(ArrayList<MyCard> list){
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_custom_item, parent, false);
        }

        return convertView;
    }
}
