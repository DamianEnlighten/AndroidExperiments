package com.example.dstrong.helloworld;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity implements OnCourseSelectorChangeListener
        , ListView.OnItemClickListener {

    final static int EXPERIMENT_ONE=0;
    final static int EXPERIMENT_TWO=1;
    final static int EXPERIMENT_THREE=2;
    final static int EXPERIMENT_FOUR=4;
    NavigationDrawerHelper mNavDrawerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavDrawerHelper = new NavigationDrawerHelper();
        mNavDrawerHelper.init(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled=true;
        int id = item.getItemId();
        switch (id) {
            case R.id.action_experiment_one:
                onClickMenuExperimentOne(item);
                break;
            case R.id.action_experiment_two:
                onClickMenuExperimentTwo(item);
                break;
            case R.id.action_experiment_three:
                onClickMenuExperimentThree(item);
                break;
            case R.id.action_experiment_four:
                onClickMenuExperimentFour(item);
                break;
            case R.id.action_exit:
                onClickMenuExit(item);
                break;
            default:
                handled = super.onOptionsItemSelected(item);
                break;
        }
        mNavDrawerHelper.handleOnOptionsItemSelected(item);
        return handled;
    }

    private void onClickMenuExperimentFour(MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:555.555.5555"));
        startActivity(intent);
    }

    private void onClickMenuExperimentThree(MenuItem item) {
        Intent intent = new Intent(this, SwipeActivity.class);
        startActivity(intent);
    }


    //region Click Events
    public void onClickMenuExperimentOne(MenuItem item) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void onClickMenuExperimentTwo(MenuItem item) {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public void onClickMenuExit(MenuItem item) {
        finish();
    }

    @Override
    public void onCourseSelectionChanged(int courseIndex) {
        FragmentManager fm = getFragmentManager();
        DescriptionFragment descFragment = (DescriptionFragment) fm.findFragmentById(R.id.descFragment);
        descFragment.setCourse(courseIndex);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mNavDrawerHelper.handleSelect(position);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceBundle){
        super.onPostCreate(savedInstanceBundle);

        mNavDrawerHelper.syncSate();
    }

    @Override
    public void onConfigurationChanged(Configuration config){
        mNavDrawerHelper.syncSate();
        super.onConfigurationChanged(config);
    }
    //endregion
}

