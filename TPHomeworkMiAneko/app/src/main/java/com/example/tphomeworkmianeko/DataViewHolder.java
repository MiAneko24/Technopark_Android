package com.example.tphomeworkmianeko;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class DataViewHolder extends RecyclerView.ViewHolder {

    private final TextView number;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);

        number = itemView.findViewById(R.id.number);
    }

    public void bind(DataModel model, View.OnClickListener listener) {
        int color = (model.mNumber % 2 == 0) ? Color.RED : Color.BLUE;

        number.setText(String.valueOf(model.mNumber));
        number.setTextColor(color);
        number.setOnClickListener(listener);
    }
}
