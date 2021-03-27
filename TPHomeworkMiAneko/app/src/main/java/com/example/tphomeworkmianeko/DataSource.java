package com.example.tphomeworkmianeko;


import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private final List<DataModel> mData;
    private static DataSource sInstance;
    private int end_number = 100;


    public DataSource() {
        mData = new ArrayList<>();

        for (int i = 1; i <= end_number; i++) {
            mData.add(new DataModel(i));
        }
    }

    public void setAmount(int amount) {

        for (int i = end_number + 1; i <= amount; i++) {
            mData.add(new DataModel(i));
        }

        end_number = amount;
    }

    public List<DataModel> getRemoteData() {
        return mData;
    }

    public void addData() {
        DataModel last = mData.get(mData.size() - 1);
        int number = last.mNumber + 1;
        mData.add(new DataModel(number));
        end_number++;
    }


    public synchronized static DataSource getInstance() {
        if (sInstance == null) {
            sInstance = new DataSource();
        }

        return sInstance;
    }
}