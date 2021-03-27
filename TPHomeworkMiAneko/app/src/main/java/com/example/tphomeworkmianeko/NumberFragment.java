package com.example.tphomeworkmianeko;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NumberFragment extends Fragment {

    TextView numberTextView;
    DataModel data = new DataModel(0);
    static final String data_number_key = "saved number";

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(data_number_key, data.mNumber);

        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_with_number, container, false);

        if (savedInstanceState != null) {
            data.mNumber = savedInstanceState.getInt(data_number_key);
        }

        int color = (data.mNumber % 2 == 0) ? Color.RED : Color.BLUE;

        numberTextView = view.findViewById(R.id.fragment_num);
        numberTextView.setText(String.valueOf(data.mNumber));
        numberTextView.setTextColor(color);

        return view;
    }
}
