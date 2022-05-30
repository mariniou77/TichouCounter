package com.example.tichoucounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.frame_container) != null){
            if (savedInstanceState != null){
                return;
            }

            fragmentManager.beginTransaction().add(R.id.frame_container, new StartingPage()).commit();
        }
    }
}