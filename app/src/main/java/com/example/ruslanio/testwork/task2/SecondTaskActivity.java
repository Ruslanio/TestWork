package com.example.ruslanio.testwork.task2;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ruslanio.testwork.R;
import com.example.ruslanio.testwork.ViewPagerAdapter;
import com.example.ruslanio.testwork.task2.fragments.AFragment;
import com.example.ruslanio.testwork.task2.fragments.DFragment;

import java.util.ArrayList;
import java.util.List;

public class SecondTaskActivity extends AppCompatActivity {
    private ViewPager vpMain;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task);

        vpMain = (ViewPager) findViewById(R.id.vp_main_2);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        setUpFragmentsList();
        adapter.setFragments(fragments);
        vpMain.setAdapter(adapter);
    }

    private void setUpFragmentsList() {
        fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new DFragment());
    }
}
