package com.dramancompany.myzzung.dramancompany.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dramancompany.myzzung.dramancompany.R;
import com.dramancompany.myzzung.dramancompany.model.RecycleModel;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by myZZUNG on 2016. 3. 2..
 */
public class RecycleListAdapter extends RecyclerView.Adapter<RecycleListAdapter.ReviewHolder> implements View.OnClickListener{

    private List<RecycleModel> mList;

    private int item_custom_layout;

    private Context mContext;

    public RecycleListAdapter(Context context, List<RecycleModel> list, int itemLayout){
        this.mContext = context;
        this.mList = list;
        this.item_custom_layout = itemLayout;
    }

    @Override
    public ReviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item_custom_layout, parent, false);
        view.setOnClickListener(this);
        return new ReviewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewHolder holder, int position) {
        final RecycleModel item = mList.get(position);
        holder.itemView.setTag(item);
        holder.name_text.setText(item.getmName());
        holder.company_text.setText(item.getmCompany());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addItem(RecycleModel item, int position){
        mList.add(position, item);
        notifyItemInserted(position);
    }

    public void removeItem(RecycleModel item){
        int position = mList.indexOf(item);
        mList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onClick(View v) {
        RecycleModel clickedItem = (RecycleModel)v.getTag();
        Toast.makeText(v.getContext(), clickedItem.getmId()+" "+clickedItem.getmName(), Toast.LENGTH_SHORT).show();
    }

    public static class ReviewHolder extends RecyclerView.ViewHolder{

        public TextView name_text;
        public TextView company_text;

        public ReviewHolder(View itemView) {
            super(itemView);
            name_text = (TextView)itemView.findViewById(R.id.recyclerview_item_name);
            company_text = (TextView)itemView.findViewById(R.id.recyclerview_item_company);
        }
    }
}
