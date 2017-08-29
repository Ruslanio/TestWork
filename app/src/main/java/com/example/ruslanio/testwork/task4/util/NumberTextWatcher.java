package com.example.ruslanio.testwork.task4.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.example.ruslanio.testwork.task4.util.MaxLengthCallback;

/**
 * Created by Ruslanio on 26.08.2017.
 */

public class NumberTextWatcher implements TextWatcher {
    private boolean isFormatting = false;
    private boolean isBackSpaceClicked = false;
    private int currentPos = 0;
    private static final String TEXT_WATCHER_TAG = "text_watcher";
    private MaxLengthCallback maxLengthCallback;

    public void setMaxLengthCallback(MaxLengthCallback maxLengthCallback) {
        this.maxLengthCallback = maxLengthCallback;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d(TEXT_WATCHER_TAG, "beforeTextChanged" + " | start = " + start + " | count = " + count + " | after = " + after);
        if (after < count) {
            isBackSpaceClicked = true;
        } else {
            isBackSpaceClicked = false;
        }
        currentPos = start;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d(TEXT_WATCHER_TAG, "onTextChanged" + " | start = " + start + " | before = " + before + " | count = " + count);
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.d(TEXT_WATCHER_TAG, "afterTextChanged(outSide)");
        if (!isFormatting) {
            isFormatting = true;
            Log.d(TEXT_WATCHER_TAG, "afterTextChanged(inside)");
            Log.d(TEXT_WATCHER_TAG, "is backspace clicked: " + isBackSpaceClicked);

            if (!isBackSpaceClicked){
                switch (currentPos){
                    case 2:
                        s.append("-");
                        break;
                    case 5:
                        s.append("-");
                        break;
                    case 9:
                        s.append("_");
                        break;
                    case 12:
                        s.delete(currentPos -1, currentPos);
                        maxLengthCallback.onMaxLengthReached();
                        break;
                    case 10:
                        s.insert(currentPos,"_");
                        break;
                    case 6:
                        s.insert(currentPos,"-");
                        break;
                    case 3:
                        s.insert(currentPos,"-");
                        break;
                }
            }
            isFormatting = false;
        }
    }

}
