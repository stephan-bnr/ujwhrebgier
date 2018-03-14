package com.example.elw_notebook.elwinfo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.elw_notebook.elwinfo.adapter.PagerAdapter;

/**
 * Program entry point and main representation of the application.
 */
public class MainActivity extends AppCompatActivity {
    private static Context mContext = null;
    /**
     * The maximum of pages the application is allowed to have at one point in time.
     */
    public static final int MAX_PAGE_NUMBER = 10;

    public static int getCurrentPageNumber() {
        return currentPageNumber;
    }

    /**
     * Does not set lager values then {@link #MAX_PAGE_NUMBER}.
     * @param currentPageNumber
     */
    public static void setCurrentPageNumber(int currentPageNumber) {
        if(currentPageNumber > MAX_PAGE_NUMBER) {
            MainActivity.currentPageNumber = MAX_PAGE_NUMBER;
        } else {
            MainActivity.currentPageNumber = currentPageNumber;
        }
    }

    /**
     * Current number of pages in the application.
     */
    private static int currentPageNumber = 2;

    /**
     * The {@link android.support.v4.view.PagerAdapter} providing fragments representing ELW
     * data sets. A {@link android.support.v4.app.FragmentPagerAdapter} should be sufficient
     * for the maximum of 10 pages. If the application becomes to large, switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}, which will destroy and
     * re-create fragments as needed, saving memory but also tanking more time.
     */
    private PagerAdapter mPagerAdapter;

    /**
     * The {@link android.support.v4.view.ViewPager} that will display the Pages.
     */
    private ViewPager mViewPager;

    /**
     * Program entry point.
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.main_activity);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mPagerAdapter);
    }

    public static Context getContext(){
        return mContext;
    }

}
