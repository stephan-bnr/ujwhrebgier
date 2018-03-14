package com.example.elw_notebook.elwinfo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.elw_notebook.elwinfo.adapter.PagerAdapter;
import com.example.elw_notebook.elwinfo.backend.Connection;
import com.example.elw_notebook.elwinfo.backend.ConnectionStub;
import com.example.elw_notebook.elwinfo.dataObjects.Vehicle;
import com.example.elw_notebook.elwinfo.dataObjects.VehicleList;

import java.util.ArrayList;
import java.util.List;

/**
 * Program entry point and main representation of the application.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The maximum of pages the application is allowed to have at one point in time.
     */
    public static final int MAX_PAGE_NUMBER = 10;

    /**
     * State if test environment or not.
     */
    public static final boolean TEST = true;

    private static Context mContext = null;

    public static Context getContext() {
        return mContext;
    }

    private VehicleList currentVehicleList = new VehicleList();

    public VehicleList getCurrentVehicleList() {
        return currentVehicleList;
    }

    public void setCurrentVehicleList(VehicleList currentVehicleList) {
        this.currentVehicleList = currentVehicleList;
    }

    public int getCurrentPageNumber() {
        return currentVehicleList.getVehicles().size();
    }


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
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.main_activity);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mPagerAdapter);

        //If test environment, on start fill with test data.
        Connection connection;
        if (TEST) {
            connection = new ConnectionStub();
            for (String name : connection.getAvailableVehicles()) {
                currentVehicleList.addVehicle(connection.getVehicleByName(name));
            }
        }
    }
}
