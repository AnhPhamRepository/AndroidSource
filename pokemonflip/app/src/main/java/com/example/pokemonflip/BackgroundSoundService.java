package com.example.pokemonflip;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class BackgroundSoundService extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.setVolume(50, 50);
    }

    @Override
    public void onStart(Intent intent, int startId) { // start activity
        super.onStart(intent, startId);
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() { // stop activity
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
