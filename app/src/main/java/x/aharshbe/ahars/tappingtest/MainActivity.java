package x.aharshbe.ahars.tappingtest;

import android.content.DialogInterface;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    TextView textView, timer, instr;
    Button face, start;
    int counter, timer_time;
    Animation myAnim;
    String download_on_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = 0;
        textView = findViewById(R.id.tv);
        timer = findViewById(R.id.timer);
        face = findViewById(R.id.face);
        start = findViewById(R.id.start);
        instr = findViewById(R.id.instr);
        myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        face.setBackgroundColor(Color.YELLOW);
        download_on_play = "https://goo.gl/U83epc";


        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
        builder2.setMessage("How long would you like to play for?");
        builder2.setCancelable(false);
        builder2.setNeutralButton(
                "60 seconds",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        timer_time = 60000;

                    }
                });
        builder2.setNegativeButton(
                "30 seconds",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        timer_time = 30000;

                    }
                });

        builder2.setPositiveButton(
                "10 seconds",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        timer_time = 10000;

                    }
                });

        AlertDialog alert112 = builder2.create();
        alert112.show();

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

        start.setText(" Tap as fast you can! ");
        face.setVisibility(View.VISIBLE);
        instr.setVisibility(View.INVISIBLE);
        start.setClickable(false);

        new CountDownTimer(timer_time, 1000) {
            @Override
            public void onTick(long l) {

                timer.setText("You have: " + l / 1000 + " seconds left");

            }

            @Override
            public void onFinish() {

                timer.setText("Time is up.");
                textView.setText("");

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Your score was: " + counter + ". Would you like to play again or share your results?");
                builder1.setCancelable(false);
                builder1.setNegativeButton(
                        "Play again",
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
                                instr.setVisibility(View.VISIBLE);
                                start.setClickable(true);


                                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                builder2.setMessage("How long would you like to play for?");
                                builder2.setCancelable(false);
                                builder2.setNeutralButton(
                                        "60 seconds",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                                timer_time = 60000;

                                            }
                                        });
                                builder2.setNegativeButton(
                                        "30 seconds",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                                timer_time = 30000;

                                            }
                                        });

                                builder2.setPositiveButton(
                                        "10 seconds",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                                timer_time = 10000;

                                            }
                                        });



                                AlertDialog alert112 = builder2.create();
                                alert112.show();
                            }
                        });

                builder1.setPositiveButton(
                        "Share",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                                sharingIntent.setType("text/plain");
                                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I scored a " + counter + " on Bouncy Cube within " +
                                timer_time / 1000 + " seconds. How fast are you? Download on Google Play: " + download_on_play);
                                startActivity(Intent.createChooser(sharingIntent,"Share using"));

                                counter = 0;
                                textView.setText(String.valueOf(counter));
                                face.setText("-_-");
                                face.setBackgroundColor(Color.CYAN);
                                timer.setText(" ");
                                dialog.cancel();
                                start.setText("Start Game");
                                face.setVisibility(View.INVISIBLE);
                                instr.setVisibility(View.VISIBLE);
                                start.setClickable(true);


                                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                builder2.setMessage("How long would you like to play for?");
                                builder2.setCancelable(false);
                                builder2.setNeutralButton(
                                        "60 seconds",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                                timer_time = 60000;

                                            }
                                        });
                                builder2.setNegativeButton(
                                        "30 seconds",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                                timer_time = 30000;

                                            }
                                        });

                                builder2.setPositiveButton(
                                        "10 seconds",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                                timer_time = 10000;

                                            }
                                        });



                                AlertDialog alert112 = builder2.create();
                                alert112.show();
                            }
                        });







                AlertDialog alert11 = builder1.create();
                alert11.show();


            }
        }.start();
    }


}
