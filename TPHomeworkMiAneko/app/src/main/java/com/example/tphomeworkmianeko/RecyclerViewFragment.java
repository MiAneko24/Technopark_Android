package com.example.tphomeworkmianeko;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressWarnings("ConstantConditions")
public class RecyclerViewFragment extends Fragment {
    RecyclerView recyclerView;
    static final String data_len_key = "data_length";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);

        if (savedInstanceState != null) {
            int amount = savedInstanceState.getInt(data_len_key);
            DataSource.getInstance().setAmount(amount);
        }

        int columns = getResources().getInteger(R.integer.amount_of_columns);

        DataAdapter adapter = new DataAdapter();
        //noinspection ConstantConditions
        if (getActivity().getClass().equals(MainActivity.class))
            adapter.setOnNumberClickListener((MainActivity) getActivity());

        recyclerView = view.findViewById(R.id.data_show);
        recyclerView.setItemViewCacheSize(10);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columns));
        recyclerView.setAdapter(adapter);

        setButton(view);

        return view;
    }

    protected void setButton(View main_view) {
        Button button = main_view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
                    DataSource.getInstance().addData();
                    changeRecyclerView();
                }
        );
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        int amount = DataSource.getInstance().getRemoteData().size();
        outState.putInt(data_len_key, amount);

        super.onSaveInstanceState(outState);
    }

    public void changeRecyclerView() {
        if (recyclerView.getAdapter() != null) {

            recyclerView.getAdapter().notifyItemInserted(DataSource
                            .getInstance()
                            .getRemoteData()
                            .size() - 1);
        }
    }
}
