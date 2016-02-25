package com.example.dstrong.helloworld;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dstrong on 2/24/2016.
 */
public class DescriptionFragment extends Fragment {
    String[] mCourseDescriptions;
    TextView mCourseDescriptionTextView;
    final static String CURRENT_DESC= "currentDescription";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mCourseDescriptions = getResources().getStringArray(R.array.course_descriptions);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View theView = inflater.inflate(R.layout.fragment_description, container, false);

        mCourseDescriptionTextView = (TextView) theView.findViewById(R.id.courseDescription);
        //Restores state when phone rotates or on resume from child activity
        if (savedInstanceState != null){
            restoreState(savedInstanceState);
        }
        return theView;
    }

    private void restoreState(Bundle savedInstanceState) {
        //(key,default if not found)
        String desc = savedInstanceState.getString(CURRENT_DESC, "");
        mCourseDescriptionTextView.setText(desc);
    }

    public void setCourse(int courseIndex)
    {
        mCourseDescriptionTextView.setText(mCourseDescriptions[courseIndex]);
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        //Store current text
        outState.putString(CURRENT_DESC, (String) mCourseDescriptionTextView.getText());
    }
}
