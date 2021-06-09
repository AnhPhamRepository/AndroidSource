package com.example.pokemonflip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

public class LoaderActivity extends AppCompatActivity {

    ProgressBar progressLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        progressLoader = (ProgressBar) findViewById(R.id.progressLoader);
        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progressCurrent = progressLoader.getProgress();
                progressLoader.setProgress(progressCurrent + 10);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(LoaderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        countDownTimer.start();
    }
}