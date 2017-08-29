package com.example.ruslanio.testwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ruslanio.testwork.task1.FirstTaskActivity;
import com.example.ruslanio.testwork.task2.SecondTaskActivity;
import com.example.ruslanio.testwork.task3.ThirdTaskActivity;
import com.example.ruslanio.testwork.task4.FourthTaskActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnFirst;
    private Button btnSecond;
    private Button btnThird;
    private Button btnFourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst = (Button) findViewById(R.id.btn_first_task);
        btnFirst.setOnClickListener(this);
        btnSecond = (Button) findViewById(R.id.btn_second_task);
        btnSecond.setOnClickListener(this);
        btnThird = (Button) findViewById(R.id.btn_third_task);
        btnThird.setOnClickListener(this);
        btnFourth = (Button) findViewById(R.id.btn_fourth_task);
        btnFourth.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.btn_first_task:
                intent = new Intent(MainActivity.this, FirstTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_second_task:
                intent = new Intent(MainActivity.this, SecondTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_third_task:
                intent = new Intent(MainActivity.this, ThirdTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_fourth_task:
                intent = new Intent(MainActivity.this, FourthTaskActivity.class);
                startActivity(intent);
                break;
        }

    }
}
