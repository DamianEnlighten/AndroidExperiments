package com.example.dstrong.helloworld;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SwipeActivity extends AppCompatActivity {

    PageInfoAdapter mPageInfoAdapter;
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        mPageInfoAdapter = new PageInfoAdapter(getSupportFragmentManager(),this);

        mViewPager = (ViewPager) findViewById(R.id.pager);

        mViewPager.setAdapter(mPageInfoAdapter);
    }

}
