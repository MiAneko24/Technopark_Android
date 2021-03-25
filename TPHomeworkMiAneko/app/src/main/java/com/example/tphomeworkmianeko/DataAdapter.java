package com.example.tphomeworkmianeko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;

class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {

    MainActivity activity;

    public void SetActivity(MainActivity parent)
    {
        activity = parent;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item, parent, false);
        return new DataViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        DataModel model = DataSource.getInstance().getRemoteData().get(position);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.Callback(model);
            }
        };
        holder.bind(model, listener);
    }

    @Override
    public int getItemCount() {
            return DataSource.getInstance().getRemoteData().size();
        }
}

