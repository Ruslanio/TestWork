package com.example.ruslanio.testwork.task3;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ruslanio.testwork.R;
import com.example.ruslanio.testwork.ViewPagerAdapter;
import com.example.ruslanio.testwork.task3.fragments.AFragment;
import com.example.ruslanio.testwork.task3.fragments.EFragment;
import com.example.ruslanio.testwork.task3.fragments.FFragment;
import com.example.ruslanio.testwork.task3.fragments.HFragment;

import java.util.ArrayList;
import java.util.List;

public class ThirdTaskActivity extends AppCompatActivity {
    private ViewPager vpMain;
    private ViewPagerAdapter adapter;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_task);


        vpMain = (ViewPager) findViewById(R.id.vp_main_3);

        setUpFragmentsList();
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);

        vpMain.setAdapter(adapter);
    }

    private void setUpFragmentsList() {
        fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new EFragment());
        fragments.add(new HFragment());
        fragments.add(new FFragment());
    }
}
