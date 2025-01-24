package com.example.zapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {
    private TextView timerText;
    private Button startButton;
    private Button resetButton;

    private Button returnhomeButton;
    private NumberPicker minutePicker;
    private CountDownTimer countDownTimer;
    private boolean isTimerRunning = false;
    private long timeLeftInMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerText = findViewById(R.id.timerText);
        startButton = findViewById(R.id.startButton);
        resetButton = findViewById(R.id.resetButton);
        minutePicker = findViewById(R.id.minutePicker);
        returnhomeButton = findViewById(R.id.btnHome);

        // Set up minute picker
        minutePicker.setMinValue(1);
        minutePicker.setMaxValue(60);
        minutePicker.setValue(1);

        returnhomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // return to the previous activity
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTimerRunning) {
                    startTimer();
                    startButton.setText("PAUSE");
                } else {
                    pauseTimer();
                    startButton.setText("START");
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    private void startTimer() {
        if (!isTimerRunning) {
            timeLeftInMillis = minutePicker.getValue() * 60000; // Convert minutes to milliseconds
        }

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                isTimerRunning = false;
                startButton.setText("START");
                minutePicker.setEnabled(true);
            }
        }.start();

        isTimerRunning = true;
        minutePicker.setEnabled(false);
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        isTimerRunning = false;
        minutePicker.setEnabled(true);
    }

    private void resetTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        isTimerRunning = false;
        startButton.setText("START");
        minutePicker.setEnabled(true);
        timerText.setText("00:00");
    }

    private void updateTimerText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        timerText.setText(timeLeftFormatted);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}