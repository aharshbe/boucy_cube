package com.example.ahars.tappingtest;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

import static java.lang.Boolean.FALSE;

public class MainActivity extends AppCompatActivity {

    TextView textView, timer;
    Button face, start;
    int counter;
    Animation myAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = 0;
        textView = findViewById(R.id.tv);
        timer = findViewById(R.id.timer);
        face = findViewById(R.id.face);
        start = findViewById(R.id.start);
        myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        face.setBackgroundColor(Color.YELLOW);

    }

    public void clickingButton(View view) {


        counter++;
        Log.d("Incrementor", String.valueOf(counter));

        String counter_string = String.valueOf(counter);

        textView.setText(counter_string);

        String test_forbool = "-_-";

        if(test_forbool.equals(face.getText())) {

            face.setText("*_^");
            face.setBackgroundColor(Color.RED);

        }else{
            face.setText("-_-");
            face.setBackgroundColor(Color.YELLOW);
        }


        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        face.startAnimation(myAnim);

    }

    public void clickingStart(View view) {

        String click_start = "Start Game";
        if (click_start.equals(start.getText())){

            start.setText(" Click as fast you can! ");
        }

        face.setVisibility(View.VISIBLE);

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {

                timer.setText("You have: " + l / 1000 + " seconds left");

            }

            @Override
            public void onFinish() {

                timer.setText("Time is up.");

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Your score was: " + counter);
                builder1.setNegativeButton(
                        "Reset",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                counter = 0;
                                textView.setText(String.valueOf(counter));
                                face.setText("-_-");
                                face.setBackgroundColor(Color.CYAN);
                                timer.setText(" ");
                                dialog.cancel();
                                start.setText("Start Game");
                                face.setVisibility(View.INVISIBLE);
                            }
                        });



                AlertDialog alert11 = builder1.create();
                alert11.show();


            }
        }.start();
    }


}
