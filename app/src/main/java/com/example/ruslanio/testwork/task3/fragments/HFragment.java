package com.example.ruslanio.testwork.task3.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ruslanio.testwork.R;

/**
 * Created by Ruslanio on 27.08.2017.
 */

public class HFragment extends Fragment {
    private EditText etText;
    private Button btnTest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3_h,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etText = (EditText) view.findViewById(R.id.et_3_h);
        btnTest = (Button) view.findViewById(R.id.btn_3_h);
        etText.addTextChangedListener(new SpecialTextWatcher());

    }

    private class SpecialTextWatcher implements TextWatcher {
        private static final String STOP_LETTER = "Я";

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().contains(STOP_LETTER)){
                btnTest.setVisibility(View.INVISIBLE);
            } else {
                btnTest.setVisibility(View.VISIBLE);
            }
        }
    }
}
