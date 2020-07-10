package com.example.splashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class numberActivity extends AppCompatActivity {

    private static String ERROR_TAG = "Error";
    private static String COMPILER = "Compiler";

    private Context mContext;

    Button generatBt;

    EditText min_nr, max_nr;

    ImageView goBackBt;

    TextView rdNumber;

    String min, max;

    int Lmax, Lmin;

    MediaPlayer mp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        generatBt = (Button) findViewById(R.id.generat_buttom);
        goBackBt = (ImageView) findViewById(R.id.goBack);

        min_nr = (EditText) findViewById(R.id.min_nr);
        max_nr = (EditText) findViewById(R.id.max_nr);

        rdNumber = (TextView) findViewById(R.id.number_rd);

        mContext = getBaseContext();

        mp = MediaPlayer.create(mContext,R.raw.penclick);

        generatBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect();
                randomGenerate();
            }
        });

        goBackBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect();
                onBackPressed();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void randomGenerate() {

        min = min_nr.getText().toString();
        max = max_nr.getText().toString();
        Log.d(COMPILER , "Extract number success!  min="+min+"  max="+max);

        try {

            Lmin = Integer.parseInt(min);
            Log.d(COMPILER , "String in int for min success!");
            try {
                Lmax = Integer.parseInt(max);
                Log.d(COMPILER , "String in int for max success!");

                Random rn = new Random();

                // If min number is bigger of max number // Inversion
                if(Lmin>Lmax){
                    int jr = Lmax;
                    Lmax=Lmin;
                    Lmin=jr;
                    Log.d(COMPILER , "Inversion success!");

                }

                int RandNum = rn.nextInt(Lmax-Lmin+1) + Lmin;
                Log.d(COMPILER , "Randomized success :"+RandNum);


                rdNumber.setText(""+RandNum);
            }
            catch (NumberFormatException e)
            {
                Log.e(ERROR_TAG,e.toString());
                @SuppressLint("WrongConstant")
                Toast toast = Toast.makeText(mContext, R.string.Error_max_toast, Toast.LENGTH_SHORT );
                toast.show();
                Log.e(ERROR_TAG,e.toString());
            }
        }
        catch (NumberFormatException e)
        {
            @SuppressLint("WrongConstant")
            Toast toast = Toast.makeText(mContext, R.string.Error_min_toast, Toast.LENGTH_SHORT );
            toast.show();
            Log.e(ERROR_TAG,e.toString());
        }

    }

    public void soundEffect(){

        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(this, R.raw.penclick);
            } mp.start();
        } catch(Exception e) { e.printStackTrace(); }

    }
}