package com.example.splashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class coinsActivity extends AppCompatActivity implements Runnable {

    RelativeLayout rvForToss;
    TextView optionText;

    ImageView goBackBt;

    ImageView coinVar1,coinVar2 ,coinToss;

    MediaPlayer mp ;
    MediaPlayer mp1 ;


    int var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coins);

        rvForToss = (RelativeLayout) findViewById(R.id.rvTouch);

        optionText= (TextView) findViewById(R.id.optionTextView);

        goBackBt = (ImageView) findViewById(R.id.goBack);

        coinVar1 = (ImageView)  findViewById(R.id.varCoinsOne);
        coinVar2 = (ImageView)  findViewById(R.id.varCoinsSecond);

        coinToss = (ImageView)  findViewById(R.id.coinIm);

        ToastCenter();


        mp = MediaPlayer.create(getBaseContext(),R.raw.penclick);
        mp1 = MediaPlayer.create(getBaseContext(),R.raw.coinflic);

        rvForToss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect();
                CoinToss();
            }
        });

        goBackBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffectClick();
                onBackPressed();
            }
        });

    }

    private void ToastCenter() {

        Toast Touch = Toast.makeText(this, "Click here", Toast.LENGTH_SHORT);
        Touch.setGravity(Gravity.CENTER,0,0);
        Touch.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void CoinToss() {

        optionText.setVisibility(View.INVISIBLE);
        coinToss.setVisibility(View.INVISIBLE);

        Random rn = new Random();
        int randomVar = rn.nextInt(2);
        Log.d("tests",""+randomVar);

        if(randomVar == 0){
             var = R.drawable.ic_coinsvarone;
            animationMove();

        } else if(randomVar == 1){
             var = R.drawable.ic_coinsvarsecond;
            animationMove();

        }


    }



    private void animationMove() {

        coinVar1.animate()
                .rotationBy(9720)
                .withEndAction(this)
                .setDuration(1000)
                .setInterpolator(new LinearInterpolator())
                .start();

        coinVar2.animate()
                .rotationBy(9720)
                .withEndAction(this)
                .setDuration(1000)
                .setInterpolator(new LinearInterpolator())
                .start();


        TranslateAnimation mAnimatio = new TranslateAnimation(0,100,0,0);
        mAnimatio.setDuration(1000);
        mAnimatio.setRepeatCount(0);
        mAnimatio.setInterpolator(new LinearInterpolator());

        mAnimatio.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                coinVar1.setVisibility(View.INVISIBLE);
                coinVar2.setVisibility(View.INVISIBLE);

                startToss();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        coinVar1.startAnimation(mAnimatio);

        TranslateAnimation mAnimation1 = new TranslateAnimation(0, -100 ,0 ,0);
        mAnimation1.setDuration(1000);
        mAnimation1.setRepeatCount(0);
        mAnimation1.setInterpolator(new LinearInterpolator());
        coinVar2.startAnimation(mAnimation1);


    }

    private void startToss() {

        coinToss.setVisibility(View.VISIBLE);
        coinToss.setImageResource(var);

        coinToss.animate()
                .rotationBy(360)
                .withEndAction(this)
                .setDuration(600)
                .setInterpolator(new LinearInterpolator())
                .start();


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
                mp1 = MediaPlayer.create(this, R.raw.coinflic);
            } mp1.start();
        } catch(Exception e) { e.printStackTrace(); }

    }

    @Override
    public void run() {

    }
}