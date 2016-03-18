package com.newthinktank.derekbanas.miniproject1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ProgressBar;
import android.os.CountDownTimer;

/*
 * Created by Huy on 6/30/2015.
 */

public class Question extends Activity {
    ProgressBar progressBar;
    MyCountDownTimer myCountDownTimer;

    int numberOfAnswer = 0;
    int point =0;
    int bookNumber;
    TextView POINT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent receivedActivity = getIntent();
        bookNumber = receivedActivity.getExtras().getInt("bookNumber");
        if(bookNumber == 0){
            setContentView(R.layout.questions_vol1);
        }else if(bookNumber ==1){
            setContentView(R.layout.questions_vol2);
        }else if(bookNumber == 2){
            setContentView(R.layout.questions_vol3);
        }else if(bookNumber == 3){
            setContentView(R.layout.questions_vol4);
        }else if(bookNumber == 4){
            setContentView(R.layout.questions_vol5);
        }else if(bookNumber == 5){
            setContentView(R.layout.questions_vol6);
        }else if(bookNumber == 6){
            setContentView(R.layout.questions_vol7);
        }

        POINT = (TextView) findViewById(R.id.point);
        POINT.append("" + point) ;
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setProgress(100);
        myCountDownTimer = new MyCountDownTimer(10000,100) ;
        myCountDownTimer.start();

    }

    public void correctAnswer(View view) {
        numberOfAnswer ++;
        point = point + 1;
        Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show();
        POINT.setText("Points: " + point);
        if(point == 3)
        {
            Toast.makeText(this, "Hoora, you know every thing about this Volume. You are almost Harry Potterer", Toast.LENGTH_SHORT).show();
        }
    }

    public void wrongAnswer(View view) {
        numberOfAnswer ++;
        point = point - 1;
        Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        POINT.setText("Points: " + point);
        if(point == -3)
        {
            Toast.makeText(getBaseContext(),"Time Over",Toast.LENGTH_LONG).show();
            Intent goBack = new Intent(Question.this,BookList.class);
            startActivity(goBack);
        }

    }

    private class MyCountDownTimer extends CountDownTimer {


        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int progress =(int) (millisUntilFinished/100);
            progressBar.setProgress(progress);
        }

        @Override
        public void onFinish() {
            progressBar.setProgress(0);
            myCountDownTimer.start();
            Toast.makeText(getBaseContext(),"Too Slow",Toast.LENGTH_SHORT).show();
            point--;
            TextView pointsView = (TextView) findViewById(R.id.point);
            pointsView.setText("Points: " + point);
            numberOfAnswer ++;
            if(point == -3)
            {
                Toast.makeText(getBaseContext(),"Time Over",Toast.LENGTH_LONG).show();
                Intent goBack = new Intent(Question.this,BookList.class);
                startActivity(goBack);
            }
        }
    }
}
