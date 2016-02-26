package com.example.dstrong.helloworld;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by dstrong on 2/25/2016.
 */
public class NavigationDrawerHelper {
    DrawerLayout mDrawerLayout;
    ListView mDrawerListView;
    Activity mActivity;
    private ActionBarDrawerToggle mDrawerToggle;

    public void init (Activity theActivity, ListView.OnItemClickListener listener){
        mDrawerLayout = (DrawerLayout) theActivity.findViewById(R.id.drawer_layout);
        mDrawerListView = (ListView) theActivity.findViewById(R.id.drawer);
        String[] navigationDrawerOptions =
                theActivity.getResources().getStringArray(R.array.course_titles);
        ArrayAdapter<String> navigationDrawerAdapter =
                new ArrayAdapter<>(theActivity, R.layout.drawer_option_item, navigationDrawerOptions);
        mDrawerListView.setAdapter(navigationDrawerAdapter);
        mDrawerListView.setOnItemClickListener(listener);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mActivity = theActivity;
        setupActionBar(theActivity);
    }

    private void setupActionBar(Activity theActivity){

        android.support.v7.app.ActionBar actionBar =((AppCompatActivity)theActivity).getSupportActionBar();
        if (actionBar !=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mDrawerToggle = new ActionBarDrawerToggle(
                theActivity,
                mDrawerLayout,
                R.string.open_drawer_message,
                R.string.close_drawer_message
        );
    }
    public void handleSelect(int option){
        mDrawerLayout.closeDrawer(mDrawerListView);
        Intent intent;
        switch (option)
        {
            case 0:
                intent = new Intent(mActivity, Activity2.class);
                mActivity.startActivity(intent);
                break;
            case 1:
                intent = new Intent(mActivity, Activity3.class);
                mActivity.startActivity(intent);
                break;
            case 2:
                intent = new Intent(mActivity, SwipeActivity.class);
                mActivity.startActivity(intent);
                break;
        }
    }
    public void syncSate(){
        mDrawerToggle.syncState();
    }
    public void handleOnOptionsItemSelected(MenuItem item){
        mDrawerToggle.onOptionsItemSelected(item);
    }
}
