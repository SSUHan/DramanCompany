package com.dramancompany.myzzung.dramancompany.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dramancompany.myzzung.dramancompany.R;
import com.dramancompany.myzzung.dramancompany.adapter.RecycleListAdapter;
import com.dramancompany.myzzung.dramancompany.model.RecycleModel;
import com.dramancompany.myzzung.dramancompany.util.FragmentLifeInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myZZUNG on 2016. 3. 1..
 */
public class MaterialFragment2 extends Fragment implements FragmentLifeInterface{

    private RecyclerView recyclerView;
    private RecycleListAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ){
            getActivity().getWindow().setExitTransition(TransitionInflater.from(getActivity()).inflateTransition(R.transition.shared_element_transition));
        }
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);

        mAdapter = new RecycleListAdapter(getContext(), createList(), R.layout.recyclerview_custom_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());



        recyclerView.setAdapter(mAdapter);

        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private List<RecycleModel> createList(){
        List<RecycleModel> mList = new ArrayList<RecycleModel>();
        for(int i=0; i<20; i++){
            mList.add(new RecycleModel(i, "이름자리 "+i, "회사자리 "+i));
        }
        return mList;
    }


    @Override
    public void onOpenFragment() {

    }

    @Override
    public void onCloseFragment() {

    }
}
