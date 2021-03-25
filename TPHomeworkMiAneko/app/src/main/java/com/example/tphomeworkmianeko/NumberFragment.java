package com.example.tphomeworkmianeko;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NumberFragment extends Fragment {

    TextView numberTextView;
    DataModel data = new DataModel(0, 0);
    static final String data_color_key = "saved color";
    static final String data_number_key = "saved number";

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(data_color_key, data.mColor);
        outState.putInt(data_number_key, data.mNumber);

        super.onSaveInstanceState(outState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_with_number, container, false);
        MainActivity parent = (MainActivity) getActivity();
        if (savedInstanceState != null)
        {
            data.mNumber = savedInstanceState.getInt(data_number_key);
            data.mColor = savedInstanceState.getInt(data_color_key);
        }
        numberTextView = view.findViewById(R.id.fragment_num);
        numberTextView.setText(String.valueOf(data.mNumber));
        numberTextView.setTextColor(data.mColor);

        return view;
    }
    @Override
    public void onDestroyView() {
        MainActivity parent = (MainActivity) getActivity();
        super.onDestroyView();
    }
}
