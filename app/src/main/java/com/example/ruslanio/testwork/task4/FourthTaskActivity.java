package com.example.ruslanio.testwork.task4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ruslanio.testwork.R;
import com.example.ruslanio.testwork.task4.util.MaxLengthCallback;
import com.example.ruslanio.testwork.task4.util.NumberTextWatcher;

public class FourthTaskActivity extends AppCompatActivity  implements MaxLengthCallback {
    private EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_task);

        etNumber = (EditText) findViewById(R.id.et_number);
        NumberTextWatcher watcher = new NumberTextWatcher();
        watcher.setMaxLengthCallback(this);
        etNumber.addTextChangedListener(watcher);

        if (savedInstanceState != null){
            etNumber.setText(savedInstanceState.getString("save"));
        }
    }

    @Override
    public void onMaxLengthReached() {
        Toast.makeText(this,"Max length of sequence",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("save",etNumber.getText().toString());
    }
}
