package com.example.android.lifecycles.my_solution;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;

import com.example.android.codelabs.lifecycle.R;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        MyChronometerViewModel chronometerViewModel
                = ViewModelProviders.of(this).get(MyChronometerViewModel.class);

        Chronometer chronometer = findViewById(R.id.chronometer);


        if (chronometerViewModel.getStartTime() == null) {
            // If the start date is not defined, it's a new ViewModel so set it.
            long startTime = SystemClock.elapsedRealtime();
            chronometerViewModel.setStartTime(startTime);
            chronometer.setBase(startTime);
        } else {
            // Otherwise the ViewModel has been retained, set the chronometer's base to the original
            // starting time.
            chronometer.setBase(chronometerViewModel.getStartTime());
        }
        chronometer.start();
    }
}
