package com.example.tphomeworkmianeko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
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
                    .addToBackStack(null)
                    .commit();
            setButton(viewFragment);
        }

    }

    protected void setButton(RecyclerViewFragment viewFragment)
    {
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
              {
                  @Override
                  public void onClick(View v) {
                      DataSource.getInstance().setData();
                      viewFragment.changeRecyclerView();
                  }
              }
        );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    protected void Callback(DataModel data) {
        NumberFragment fragment = new NumberFragment();
        fragment.data = data;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();

    }


}

