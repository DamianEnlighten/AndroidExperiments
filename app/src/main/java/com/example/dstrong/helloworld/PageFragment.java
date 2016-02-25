package com.example.dstrong.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dstrong on 2/25/2016.
 */
public class PageFragment extends Fragment {
    public final static String PAGE_TITLE="pageTitle";
    public final static String PAGE_DESC="pageDesc";
    public final static String PAGE_TITLE_SHORT="pageTitleShort";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View theView= inflater.inflate(R.layout.fragment_page_info,container,false);

        Bundle args = getArguments();
        if (args != null){
            String title = args.getString(PAGE_TITLE);
            String title_short = args.getString(PAGE_TITLE_SHORT);
            String desc = args.getString(PAGE_DESC);

            displayValues(theView, title,title_short,desc);
        }
        return theView;
    }

    private void displayValues(View theView, String title, String title_short, String desc) {
        TextView page_title = (TextView) theView.findViewById(R.id.title);
        TextView page_title_short = (TextView) theView.findViewById(R.id.title_short);
        TextView page_desc = (TextView) theView.findViewById(R.id.desc);

        page_title.setText(title);
        page_title_short.setText(title_short);
        page_desc.setText(desc);
    }
}
