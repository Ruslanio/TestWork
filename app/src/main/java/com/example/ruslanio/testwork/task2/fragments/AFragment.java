package com.example.ruslanio.testwork.task2.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruslanio.testwork.R;
import com.example.ruslanio.testwork.task2.util.DBHelper;

/**
 * Created by Ruslanio on 27.08.2017.
 */

public class AFragment extends Fragment implements View.OnClickListener {
    private DBHelper dbHelper;
    private StringBuilder query;
    private static final String TABLE_NAME = "a_task_table";
    private static final String TAG_DB = "test_db";
    private Button btnLog;
    private TextView tvLog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2_a,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLog = (Button) view.findViewById(R.id.btn_2_a);
        btnLog.setOnClickListener(this);

        tvLog = (TextView) view.findViewById(R.id.tv_2_a);
        if (savedInstanceState != null){
            tvLog.setText(savedInstanceState.getString("log"));
        }

        setUpTheQuery();
        dbHelper = new DBHelper(getContext(),query.toString());
        ContentValues cv = new ContentValues();
        for (int i = 0;i < 50;i++){
            cv.put("i" + i, (i+1)*(i+1));
        }
        dbHelper.getWritableDatabase().insert(TABLE_NAME,null,cv);
        dbHelper.close();
    }

    private void setUpTheQuery() {
        query = new StringBuilder();
        query.append("CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
        " (");
        for (int i = 0; i < 50; i++){
            query.append("i" + i + " INTEGER,");
        }
        query.deleteCharAt(query.length() - 1); //get rid of ","
        query.append(");");
    }

    @Override
    public void onClick(View v) {
        Cursor cursor = dbHelper.getWritableDatabase().query(TABLE_NAME,null,null,null,null,null,null);
        int currentIndex;
        StringBuilder result = new StringBuilder();
        cursor.moveToFirst();
        for (int i = 0;i < 50; i++){
            currentIndex = cursor.getColumnIndex("i" + i);
            result.append("i")
                    .append(i)
                    .append(" = ")
                    .append(cursor.getString(currentIndex))
                    .append(" ; ");
        }
        Log.d(TAG_DB,result.toString());
        dbHelper.close();
        tvLog.setText(result.toString());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("log",tvLog.getText().toString());
    }
}
