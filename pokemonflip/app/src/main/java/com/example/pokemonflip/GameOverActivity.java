package com.example.pokemonflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class GameOverActivity extends AppCompatActivity {

    Button btRestart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

//        btRestart = (Button) findViewById(R.id.btrestart);
//        btRestart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}