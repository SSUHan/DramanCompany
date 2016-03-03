package com.dramancompany.myzzung.dramancompany.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

    public void addItem(MyCard newItem){
        mList.add(newItem);
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

        CardHolder holder = null;
        TextView tName, tCompany, tPosition, tMatchKey, tMatchValue;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_custom_item, parent, false);

            tName = (TextView)convertView.findViewById(R.id.listitem_name);
            tCompany = (TextView)convertView.findViewById(R.id.listitem_company);
            tPosition = (TextView)convertView.findViewById(R.id.listitem_position);
            tMatchKey = (TextView)convertView.findViewById(R.id.listitem_match_key);
            tMatchValue = (TextView)convertView.findViewById(R.id.listitem_match_value);

            holder = new CardHolder();
            holder.hName = tName;
            holder.hCompany = tCompany;
            holder.hPosition = tPosition;
            holder.hMatchKey = tMatchKey;
            holder.hMatchValue = tMatchValue;
            convertView.setTag(holder);
        }else{
            holder = (CardHolder)convertView.getTag();
            tName = holder.hName;
            tCompany = holder.hCompany;
            tPosition = holder.hPosition;
            tMatchKey = holder.hMatchKey;
            tMatchValue = holder.hMatchValue;
        }
        tName.setText(mList.get(pos).getmName());
        tCompany.setText(mList.get(pos).getmCompany());
        tPosition.setText(mList.get(pos).getmPosition());

        return convertView;
    }

    class CardHolder{
        public TextView hName, hCompany, hPosition, hMatchKey, hMatchValue;
    }
}
