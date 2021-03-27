package com.example.tphomeworkmianeko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnNumberClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerViewFragment viewFragment;

        if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
            viewFragment = new RecyclerViewFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, viewFragment)
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void Callback(DataModel data) {
        NumberFragment fragment = new NumberFragment();
        fragment.data = data;

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }


}

