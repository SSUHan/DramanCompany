package com.dramancompany.myzzung.dramancompany.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dramancompany.myzzung.dramancompany.R;
import com.dramancompany.myzzung.dramancompany.adapter.ViewPagerAdapter;
import com.dramancompany.myzzung.dramancompany.util.FragmentLifeInterface;

public class MaterialActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter mPagerAdapter;

    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_material);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(new MaterialFragment1(),"Screen #1");
        mPagerAdapter.addFragment(new MaterialFragment2(),"Screen #2");
        mPagerAdapter.addFragment(new MaterialFragment3(),"Screen #3");

        viewPager.setAdapter(mPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int currentPosition=0;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                FragmentLifeInterface fragmentToShow = (FragmentLifeInterface)mPagerAdapter.getItem(position);
                fragmentToShow.onOpenFragment();

                FragmentLifeInterface fragmentToHide = (FragmentLifeInterface)mPagerAdapter.getItem(currentPosition);
                fragmentToHide.onCloseFragment();

                currentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);


    }

}
