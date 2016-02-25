package com.example.dstrong.helloworld;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by dstrong on 2/24/2016.
 */
public class TitlesFragment extends ListFragment {
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        OnCourseSelectorChangeListener listener = (OnCourseSelectorChangeListener) getActivity();
        listener.onCourseSelectionChanged(position);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] titles = getResources().getStringArray(R.array.course_titles);
        ArrayAdapter<String> titleAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, titles);
        setListAdapter(titleAdapter);
    }
}
