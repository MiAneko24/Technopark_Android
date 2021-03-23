package com.example.tphomeworkmianeko;


import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private final List<DataModel> mData;
    private static DataSource sInstance;



    public DataSource() {
        mData = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            int number = i;
            int color = (number % 2 == 0) ? Color.RED : Color.BLACK;
            mData.add(new DataModel(number, color));
        }
    }

    public List<DataModel> getRemoteData() {
        return mData;
    }

    public synchronized static DataSource getInstance() {
        if (sInstance == null) {
            sInstance = new DataSource();
        }
        return sInstance;
    }
}