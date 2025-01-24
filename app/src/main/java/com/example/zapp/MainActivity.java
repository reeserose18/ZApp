package com.example.zapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  buttons
        Button btnGuideW = findViewById(R.id.btnCGW);
        Button btnGuideX = findViewById(R.id.btnCGX);
        Button btnGuideY = findViewById(R.id.btnCGY);
        Button btnGuideZ = findViewById(R.id.btnCGZ);
        Button syllabusButton = findViewById(R.id.btnSyllabus);

        // click listeners
        btnGuideW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseGuideWActivity.class);
                startActivity(intent);
            }
        });

        btnGuideX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseGuideXActivity.class);
                startActivity(intent);
            }
        });

        btnGuideY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseGuideYActivity.class);
                startActivity(intent);
            }
        });

        btnGuideZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseGuideZActivity.class);
                startActivity(intent);
            }
        });

        syllabusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseGuideActivity.class);
                startActivity(intent);
            }

        });
        Button timerButton = findViewById(R.id.btnTimer);
        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(intent);
            }
        });
    }
}