package com.example.ruslanio.testwork.task2.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruslanio.testwork.R;
import com.example.ruslanio.testwork.task2.util.DBHelper;

/**
 * Created by Ruslanio on 28.08.2017.
 */

public class DFragment extends Fragment implements View.OnClickListener {
    private DBHelper dbHelper;
    private StringBuilder query;
    private static final String TABLE_NAME = "g_task_table";
    private Button btnLog;
    private TextView tvLog;
    private static final String UPDATE_QUERY = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN i5 INTEGER";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2_d, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLog = (Button) view.findViewById(R.id.btn_2_d);
        btnLog.setOnClickListener(this);

        tvLog = (TextView) view.findViewById(R.id.tv_2_d);
        if (savedInstanceState != null){
            tvLog.setText(savedInstanceState.getString("log"));
        }

        setUpTheQuery();
        dbHelper = new DBHelper(getContext(), query.toString());
        dbHelper.getReadableDatabase().execSQL(query.toString());
        dbHelper.close();
    }

    private void setUpTheQuery() {

        query = new StringBuilder();
        query.append("CREATE TABLE IF NOT EXISTS ").append(TABLE_NAME)
                .append("(i1 INTEGER,")
                .append("i2 INTEGER,")
                .append("i3 INTEGER,")
                .append("i4 INTEGER);");


    }

    @Override
    public void onClick(View v) {
        try {
            dbHelper.getReadableDatabase().execSQL(UPDATE_QUERY);
            ContentValues contentValues = new ContentValues();
            contentValues.put("i1", 1);
            contentValues.put("i2", 2);
            contentValues.put("i3", 3);
            contentValues.put("i4", 4);
            contentValues.put("i5", 5);
            dbHelper.getReadableDatabase().insert(TABLE_NAME, null, contentValues);
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Column is already exists", Toast.LENGTH_LONG).show();
        }

        tvLog.setText(getValuesFromDB());
    }

    private String getValuesFromDB(){
        Cursor cursor = dbHelper.getReadableDatabase().query(TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        int currentIndex;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < 6; i++) {
            currentIndex = cursor.getColumnIndex("i" + i);
            result.append("i" + i + " = " + cursor.getString(currentIndex) + " ; ");
        }
        dbHelper.close();
        return result.toString();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("log", tvLog.getText().toString());
    }
}
