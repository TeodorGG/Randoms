package com.example.splashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MenuActivity extends AppCompatActivity {

    RelativeLayout rvNumber, rvDice, rvCoin;

    ImageView moreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        rvNumber = (RelativeLayout) findViewById(R.id.rvNumber);
        rvDice = (RelativeLayout) findViewById(R.id.rvDice);
        rvCoin = (RelativeLayout) findViewById(R.id.rvCoins);

        moreInfo = (ImageView) findViewById(R.id.moreInfo);

        rvNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect();
                Intent numberGoActivity = new Intent(MenuActivity.this, numberActivity.class);
                startActivity(numberGoActivity);
            }
        });


        rvDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect();
                Intent diceGoActivity = new Intent(MenuActivity.this, diceActivity.class);
                startActivity(diceGoActivity);
            }
        });

        rvCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect();
                Intent coinGoActivity = new Intent(MenuActivity.this, coinsActivity.class);
                startActivity(coinGoActivity);
            }
        });

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect();
                Intent moreIGoActivity = new Intent(MenuActivity.this, DeveloperActivity.class);
                startActivity(moreIGoActivity);
            }
        });

    }
    public void soundEffect(){
        MediaPlayer mp = MediaPlayer.create(getBaseContext(),R.raw.penclick);
        mp.start();

    }
}