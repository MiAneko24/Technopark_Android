package com.example.tphomeworkmianeko;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {

    OnNumberClickListener mListener;

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.data_item, parent, false);

        return new DataViewHolder(view);
    }

    void setOnNumberClickListener(OnNumberClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        DataModel model = DataSource
                .getInstance()
                .getRemoteData()
                .get(position);

        View.OnClickListener listener = v -> mListener.Callback(model);

        holder.bind(model, listener);
    }

    @Override
    public int getItemCount() {
        return DataSource
                .getInstance()
                .getRemoteData()
                .size();
    }
}

