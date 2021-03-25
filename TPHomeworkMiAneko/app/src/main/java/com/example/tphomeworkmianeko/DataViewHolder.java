package com.example.tphomeworkmianeko;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

class DataViewHolder extends RecyclerView.ViewHolder {

    private final TextView number;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        number = itemView.findViewById(R.id.number);
    }

    public void bind(DataModel model, View.OnClickListener listener) {
        number.setText(String.valueOf(model.mNumber));
        number.setTextColor(model.mColor);

        number.setOnClickListener(listener);
    }
}
