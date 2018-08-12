package com.example.bennj.scoreapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
        /*timer declaration */
    private static final long start_time = 2700000;

    private TextView text_timer;
    private Button start_btn;
    private Button stop_btn;

    private CountDownTimer mtimer;

    private boolean mTimerRunning;

    private long mTimeLeftIMillis = start_time;

        /*point declaration*/
    int scoreteamA = 0;
    int scoreteamB = 0;
    int penaltyA = 0;
    int penaltyB = 0;
    int foulA = 0;
    int foulB = 0;
    int redA = 0;
    int redB = 0;
    int yellowA = 0;
    int yellowB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/**
 * closing the app
 *
 * */
     Button quit_btn =(Button) findViewById(R.id.quit);

     quit_btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             finish();
             System.exit(0);
         }
     });

        /**
         * Game timer
         * */

        text_timer = findViewById(R.id.timer);

       start_btn = findViewById(R.id.btn_start);
        stop_btn = findViewById(R.id.btn_stop);

       start_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(mTimerRunning){
                   pauseTimer();
               } else {
                   startTimer();
               }
           }
       });
       stop_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               reset();
           }
       });

       updateCountDownText();


    }

    private void startTimer(){
        mtimer = new CountDownTimer(mTimeLeftIMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftIMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                start_btn.setText("Start");

            }
        }.start();
            mTimerRunning = true;
            start_btn.setText("pause");

        }
    private void pauseTimer(){
        mtimer.cancel();
        mTimerRunning = false;
        start_btn.setText("Start");

    }
    private void reset(){
        mTimeLeftIMillis = start_time;
        updateCountDownText();

    }
    private void updateCountDownText(){
        int minutes = (int)(mTimeLeftIMillis / 1000)/60;
        int seconds = (int) (mTimeLeftIMillis / 1000) %60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        text_timer.setText(timeLeftFormatted);
    }

    /**
     * Team A score
     * @params
     */

    public void goalA(View v){
        scoreteamA = scoreteamA + 1;
        displayForTeamA(scoreteamA);
    }
    public void penaltyA(View v){
        penaltyA = penaltyA + 1;
        displayPenalty_A(penaltyA);
    }
    public void foulA(View v){
        foulA = foulA + 1;
        displayFoul_A(foulA);
    }
    public void redcardA (View v){
        redA = redA + 1;
        displayred_A(redA);
    }
    public void yellowcardA (View v){
        yellowA = yellowA + 1;
        displayyellow_A(yellowA);
    }

    /**
     * Team B score
     * @params
     */

    public void goalB(View v){
        scoreteamB = scoreteamB + 1;
        displayForTeamB(scoreteamB);
    }
    public void penaltyB(View v){
        penaltyB = penaltyB + 1;
        displayPenalty_B(penaltyB);
    }
    public void foulB(View v){
        foulB = foulB + 1;
        displayFoul_B(foulB);
    }
    public void redcardB (View v){
        redB = redB + 1;
        displayred_B(redB);
    }
    public void yellowcardB (View v){
        yellowB = yellowB + 1;
        displayyellow_B(yellowB);
    }

    /**
    *reset values
    */
    public void reset (View v){
        scoreteamA = 0;
        scoreteamB = 0;
        penaltyA = 0;
        penaltyB = 0;
        foulA = 0;
        foulB = 0;
        redA = 0;
        yellowB = 0;
        yellowA = 0;

        displayForTeamA(0);
        displayForTeamB(0);
        displayPenalty_A(0);
        displayPenalty_B(0);
        displayFoul_A(0);
        displayFoul_B(0);
        displayred_A(0);
        displayred_B(0);
        displayyellow_A(0);
        displayyellow_B(0);

    }

    /**
     * Goals for both teams
     * @param goal
     */
    public void displayForTeamA(int goal){
        TextView goalView = (TextView) findViewById(R.id.goal);
        goalView.setText(String.valueOf(goal));
    }
    public void displayForTeamB(int goal){
        TextView goalView = (TextView) findViewById(R.id.goal_value);
        goalView.setText(String.valueOf(goal));
    }

    /**
     * penalty for both teams
     * @param penalty
     */
    public void displayPenalty_A(int penalty){
        TextView penaltyView  = (TextView) findViewById(R.id.penalty_no1);
        penaltyView.setText(String.valueOf(penalty));
    }
    public void displayPenalty_B(int penalty){
        TextView penaltyView  = (TextView) findViewById(R.id.penalty_no2);
        penaltyView.setText(String.valueOf(penalty));
    }

    /**
     * fouls for both teams
     * @param foul
     */
    public void displayFoul_A(int foul){
        TextView foulView  = (TextView) findViewById(R.id.foul_no1);
        foulView.setText(String.valueOf(foul));
    }
    public void displayFoul_B(int foul){
        TextView foulView  = (TextView) findViewById(R.id.foul_no);
        foulView.setText(String.valueOf(foul));
    }
    /**
     * Red card for both teams
     * @param rcard
     */
    public void displayred_A(int rcard){
        TextView redView  = (TextView) findViewById(R.id.red_no1);
        redView.setText(String.valueOf(rcard));
    }
    public void displayred_B(int rcard){
        TextView redView  = (TextView) findViewById(R.id.red_no2);
        redView.setText(String.valueOf(rcard));
    }
    /**
     * fouls for both teams
     * @param ycard
     */
    public void displayyellow_A(int ycard){
        TextView yellowView  = (TextView) findViewById(R.id.yellow_card_A);
        yellowView.setText(String.valueOf(ycard));
    }
    public void displayyellow_B(int ycard){
        TextView yellowView  = (TextView) findViewById(R.id.yellow_card_B);
        yellowView.setText(String.valueOf(ycard));
    }

}
