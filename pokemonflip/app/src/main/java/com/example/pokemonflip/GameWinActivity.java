package com.example.pokemonflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class GameWinActivity extends AppCompatActivity {

    Button btagain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);

//        btagain = (Button) findViewById(R.id.btagain);
//        btagain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // back MainActivity
//                Intent intent = new Intent(GameWinActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}