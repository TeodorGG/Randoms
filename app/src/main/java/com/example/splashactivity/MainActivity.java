package com.example.splashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable {

    private static int TimeSplashScreen = 2*1000; //Splash Screen Time


    Context mContext;

    TextView title_text;

    ImageView dice1,dice2,dice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title_text = (TextView) findViewById(R.id.title_app);

        dice1 = (ImageView) findViewById(R.id.dice1);
        dice2 = (ImageView) findViewById(R.id.dice2);
        dice3 = (ImageView) findViewById(R.id.dice3);

        mContext = getBaseContext();


        // Animation of dice levitation  //
        animationDice1();
        animationDice2();
        animationDice3();

        //Hide the notificatiob bar //
        hideNavigetionBar();

        //SplashScreen  //
        scheduleSplashScreen();


    }



    private void animationDice1() {

        TranslateAnimation mAnimation = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.05f);
        mAnimation.setDuration(2500);
        mAnimation.setRepeatCount(-1);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());
        dice1.setAnimation(mAnimation);

        dice1.animate()
                .rotationBy(360)
                .withEndAction(this)
                .setDuration(10000)
                .setInterpolator(new LinearInterpolator())
                .start();

    }


    private void animationDice2() {

        TranslateAnimation mAnimation = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.05f);
        mAnimation.setDuration(3000);
        mAnimation.setRepeatCount(-1);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());
        dice2.setAnimation(mAnimation);

        dice2.animate()
                .rotationBy(360)
                .withEndAction(this)
                .setDuration(10000)
                .setInterpolator(new LinearInterpolator())
                .start();

    }


    private void animationDice3() {

        TranslateAnimation mAnimation = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.02f);
        mAnimation.setDuration(2000);
        mAnimation.setRepeatCount(-1);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());
        dice3.setAnimation(mAnimation);

        dice3.animate()
                .rotationBy(360)
                .withEndAction(this)
                .setDuration(10000)
                .setInterpolator(new LinearInterpolator())
                .start();
    }

    private void scheduleSplashScreen() {

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }
        },TimeSplashScreen);
    }


    @Override
    protected void onResume() {
        super.onResume();

        hideNavigetionBar();

    }

    private void hideNavigetionBar(){
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN|
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }

    @Override
    public void run() {

    }
}