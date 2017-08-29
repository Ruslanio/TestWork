package com.example.ruslanio.testwork.task1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ruslanio.testwork.R;
import com.example.ruslanio.testwork.ViewPagerAdapter;
import com.example.ruslanio.testwork.task1.fragments.AFragment;
import com.example.ruslanio.testwork.task1.fragments.BFragment;
import com.example.ruslanio.testwork.task1.fragments.FFragment;
import com.example.ruslanio.testwork.task1.fragments.GFragment;
import com.example.ruslanio.testwork.task1.fragments.HFragment;

import java.util.ArrayList;
import java.util.List;

public class FirstTaskActivity extends AppCompatActivity {
    private ViewPager vpMain;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_task);

        vpMain = (ViewPager) findViewById(R.id.vp_main_1);

        setUpFragmentsList();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);

        vpMain.setAdapter(adapter);

    }

    private void setUpFragmentsList(){
        fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new FFragment());
        fragments.add(new GFragment());
        fragments.add(new HFragment());
    }

}
