package com.example.splashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;

import java.util.Random;

public class diceActivity extends AppCompatActivity implements Runnable {

    private static String TAG = "Compiler";

    ImageView goBackBt;

    SeekBar nrSeekBar;

    TextView nrOfDice;

    ImageView dice1,dice2,dice3,dice4;

    Button generateBt;

    Space sp1,sp2;

    Context mContext;

    MediaPlayer mp1 ;
    MediaPlayer mp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        nrSeekBar = (SeekBar) findViewById(R.id.seekbarNr);

        nrOfDice = (TextView) findViewById(R.id.nrOfDice);

        goBackBt = (ImageView) findViewById(R.id.goBack);

        dice1 = (ImageView) findViewById(R.id.imgD1);
        dice2 = (ImageView) findViewById(R.id.imgD2);
        dice3 = (ImageView) findViewById(R.id.imgD3);
        dice4 = (ImageView) findViewById(R.id.imgD4);

        generateBt = (Button) findViewById(R.id.generatBt);

        sp1 = (Space) findViewById(R.id.sp1);
        sp2 = (Space) findViewById(R.id.sp2);

        mContext = getBaseContext();

        mp = MediaPlayer.create(getBaseContext(),R.raw.penclick);
        mp1 = MediaPlayer.create(getBaseContext(),R.raw.dicesound);

        goBackBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffectClick();
                onBackPressed();
            }
        });

        //Base setting //
        dice2.setVisibility(View.GONE);
        dice3.setVisibility(View.GONE);
        dice4.setVisibility(View.GONE);

        sp1.setVisibility(View.GONE);
        sp2.setVisibility(View.GONE);

        // to get the data from seekBar / number of dice 1-4 //
        nrSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                nrOfDice.setText(""+progress);
                Log.d(TAG, "Number of dice is change :"+progress);

                soundEffectClick();

                // visualisation the dice 1-4 //
                visualizationDice(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect();
                generateRand();
            }
        });



    }

    public void soundEffectClick(){

        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(this, R.raw.penclick);
            } mp.start();
        } catch(Exception e) { e.printStackTrace(); }

    }

    public void soundEffect(){

        try {
            if (mp1.isPlaying()) {
                mp1.stop();
                mp1.release();
                mp1 = MediaPlayer.create(this, R.raw.dicesound);
            } mp1.start();
        } catch(Exception e) { e.printStackTrace(); }

    }

    private void generateRand() {

        Random rn = new Random();

        animationDices();

        for(int i=1;i<=4;i++) {
            int valueOfDice = rn.nextInt(7);
            Log.d(TAG, "For dice "+ i + " Value is: "+valueOfDice);

            setValorInDice(valueOfDice, i);
        }

    }

    private void animationDices() {
        Log.d(TAG, "Animation starting");

        dice1.animate()
                .rotationBy(9720)
                .withEndAction(this)
                .setDuration(800)
                .setInterpolator(new LinearInterpolator())
                .start();

        dice2.animate()
                .rotationBy(9720)
                .withEndAction(this)
                .setDuration(800)
                .setInterpolator(new LinearInterpolator())
                .start();

        dice3.animate()
                .rotationBy(11720)
                .withEndAction(this)
                .setDuration(800)
                .setInterpolator(new LinearInterpolator())
                .start();

        dice4.animate()
                .rotationBy(5720)
                .withEndAction(this)
                .setDuration(800)
                .setInterpolator(new LinearInterpolator())
                .start();

        TranslateAnimation mAnimation = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.07f);
        mAnimation.setDuration(400);
        mAnimation.setRepeatCount(1);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());
        dice1.setAnimation(mAnimation);

        TranslateAnimation mAnimation1 = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, -0.09f);
        mAnimation.setDuration(400);
        mAnimation.setRepeatCount(1);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());
        dice2.setAnimation(mAnimation1);

        TranslateAnimation mAnimation2 = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0.07f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.09f);
        mAnimation.setDuration(400);
        mAnimation.setRepeatCount(1);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());
        dice3.setAnimation(mAnimation2);

        TranslateAnimation mAnimation3 = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, -0.09f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.07f);
        mAnimation.setDuration(400);
        mAnimation.setRepeatCount(1);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());
        dice4.setAnimation(mAnimation3);
    }

    private void setValorInDice(int valueOfDice, int i) {
        ImageView img = null;
        if(i == 1) {
             img = dice1;
        } else if(i == 2) {
             img = dice2;
        } else if(i == 3) {
             img = dice3;
        } else if(i == 4) {
             img = dice4;
        }

        assert img != null;

        // Set svg image for dice //
        if(valueOfDice == 1) {
            img.setImageResource(R.drawable.ic_diceone);
        } else if(valueOfDice == 2) {
            img.setImageResource(R.drawable.ic_dicetwo);
        } else if(valueOfDice == 3) {
            img.setImageResource(R.drawable.ic_dicethree);
        } else if(valueOfDice == 4) {
            img.setImageResource(R.drawable.ic_dicefoor);
        } else if(valueOfDice == 5) {
            img.setImageResource(R.drawable.ic_dicefive);
        } else if(valueOfDice == 6) {
            img.setImageResource(R.drawable.ic_dicesix);
        }


    }


    private void visualizationDice(int nrOfDice) {


        //Visualisation the image and space //
        dice2.setVisibility(View.GONE);
        dice3.setVisibility(View.GONE);
        dice4.setVisibility(View.GONE);

        sp1.setVisibility(View.GONE);
        sp2.setVisibility(View.GONE);

        if (nrOfDice == 1){
           dice1.setVisibility(View.VISIBLE);
        } else if (nrOfDice == 2){
            dice1.setVisibility(View.VISIBLE);
            dice2.setVisibility(View.VISIBLE);

            sp1.setVisibility(View.VISIBLE);
        } else if (nrOfDice == 3){
            dice1.setVisibility(View.VISIBLE);
            dice2.setVisibility(View.VISIBLE);

            sp1.setVisibility(View.VISIBLE);

            dice3.setVisibility(View.VISIBLE);
        }else if (nrOfDice == 4){
            dice1.setVisibility(View.VISIBLE);
            dice2.setVisibility(View.VISIBLE);

            sp1.setVisibility(View.VISIBLE);
            sp2.setVisibility(View.VISIBLE);

            dice3.setVisibility(View.VISIBLE);
            dice4.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void run() { //I don't now what is this // Is for getContent(); //

    }
}