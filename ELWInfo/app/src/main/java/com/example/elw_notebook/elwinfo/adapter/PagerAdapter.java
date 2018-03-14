package com.example.elw_notebook.elwinfo.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.elw_notebook.elwinfo.fragments.ELWFragment;

/**
 * A {@link android.support.v4.app.FragmentPagerAdapter} that returns a fragment representing an
 * ELW data set. Switch to a {@link android.support.v4.app.FragmentStatePagerAdapter} if the
 * application uses to much memory.
 *
 */
public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new ELWFragment();
        Bundle args = new Bundle();
        args.putInt(ELWFragment.ARG_OBJECT, i + 1); // Our object is just an integer :-P
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        // For this contrived example, we have a 100-object collection.
        return 100;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
}
