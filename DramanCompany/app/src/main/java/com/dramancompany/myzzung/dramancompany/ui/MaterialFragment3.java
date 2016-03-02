package com.dramancompany.myzzung.dramancompany.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.dramancompany.myzzung.dramancompany.R;
import com.dramancompany.myzzung.dramancompany.util.FragmentLifeInterface;

import org.w3c.dom.Text;

/**
 * Created by myZZUNG on 2016. 3. 1..
 */
public class MaterialFragment3 extends Fragment implements FragmentLifeInterface{
    private final String TAG = "MaterialFragment3";


    private Animation intoAnimation;
    private Animation outtoAnimation;

    private ImageView frag3_image_view;
    private TextView frag3_text_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_thrid, container, false);
        Log.d(TAG,"onCreateView");

        intoAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.frag3_into_anim);
        outtoAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.frag3_outto_anim);

        frag3_image_view = (ImageView)rootView.findViewById(R.id.frag3_image_view);
        frag3_text_view = (TextView)rootView.findViewById(R.id.frag3_text_view);

        viewAnimationFadein();

        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public MaterialFragment3() {
        super();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.d(TAG, "onContextItemSelected");
        return super.onContextItemSelected(item);

    }

    @Override
    public void onOpenFragment() {
        Log.d(TAG, "onOpenFragment");

        viewAnimationFadein();
    }

    @Override
    public void onCloseFragment() {
        Log.d(TAG, "onCloseFragment");

        viewAnimationFadeout();
    }

    private void viewAnimationFadein(){
        frag3_image_view.startAnimation(intoAnimation);
        frag3_text_view.startAnimation(intoAnimation);
    }

    private void viewAnimationFadeout(){
        frag3_image_view.startAnimation(outtoAnimation);
        frag3_text_view.startAnimation(outtoAnimation);
    }
}
