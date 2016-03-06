package com.dramancompany.myzzung.dramancompany.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.annotation.Suppress;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dramancompany.myzzung.dramancompany.R;
import com.dramancompany.myzzung.dramancompany.model.RecycleModel;
import com.dramancompany.myzzung.dramancompany.ui.SharedElementActivity;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by myZZUNG on 2016. 3. 2..
 */
public class RecycleListAdapter extends RecyclerView.Adapter<RecycleListAdapter.ReviewHolder>{

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



    public class ReviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView name_text;
        public TextView company_text;

        public ReviewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name_text = (TextView)itemView.findViewById(R.id.recyclerview_item_name);
            company_text = (TextView)itemView.findViewById(R.id.recyclerview_item_company);
        }


        @Override
        public void onClick(View v) {
            //RecycleModel clickedItem = (RecycleModel)v.getTag();

            Intent intent = new Intent(mContext, SharedElementActivity.class);
            intent.putExtra("shared_key", name_text.getText().toString());
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                ActivityOptionsCompat optionComapt = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, name_text, name_text.getTransitionName());
                name_text.setTransitionName("name_text");
                mContext.startActivity(intent, optionComapt.toBundle());
            }else{
                mContext.startActivity(intent);
            }
        }
    }
}
