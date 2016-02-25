package com.example.dstrong.helloworld;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by dstrong on 2/25/2016.
 */
public class PageInfoAdapter extends FragmentPagerAdapter {

    String[] mTitles;
    String[] mTitlesShort;
    String[] mDescs;

    public PageInfoAdapter(FragmentManager fm, Context context) {
        super(fm);

        Resources resources = context.getResources();
        mTitles = resources.getStringArray(R.array.page_titles);
        mTitlesShort = resources.getStringArray(R.array.page_titles_short);
        mDescs = resources.getStringArray(R.array.page_desc);
    }

    @Override
    public Fragment getItem(int page) {
        Bundle args = new Bundle();
        args.putString(PageFragment.PAGE_TITLE, mTitles[page]);
        args.putString(PageFragment.PAGE_TITLE_SHORT, mTitlesShort[page]);
        args.putString(PageFragment.PAGE_DESC, mDescs[page]);

        PageFragment pageFragment= new PageFragment();
        pageFragment.setArguments(args);

        return pageFragment;
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitlesShort[position];
    }
}
