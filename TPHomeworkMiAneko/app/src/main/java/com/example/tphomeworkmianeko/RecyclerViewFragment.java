package com.example.tphomeworkmianeko;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerViewFragment extends Fragment {
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);

        recyclerView = view.findViewById(R.id.data_show);

        recyclerView.setItemViewCacheSize(10);
        MainActivity activity = (MainActivity) getActivity();
        if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(activity, 3));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(activity, 4));

        }

        DataAdapter adapter = new DataAdapter();
        adapter.SetActivity((MainActivity) getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void changeRecyclerView() {
        recyclerView.getAdapter().notifyItemInserted(DataSource.getInstance().getRemoteData().size() - 1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
