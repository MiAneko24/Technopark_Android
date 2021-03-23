package com.example.tphomeworkmianeko;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;

class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {

    List<DataModel> data = DataSource.getInstance().getRemoteData();

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        DataModel model = data.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
            return data.size();
        }
}

