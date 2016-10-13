package com.example.user.quickcoding02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int answer = 42;
    Random random = new Random();
    int count = 0;
    int ran = random.nextInt(100)+1;
    int max = 100;
    int min = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyValue value = new MyValue();


        Button smaller = (Button) findViewById(R.id.smButton);
        Button bigger = (Button) findViewById(R.id.bButton);
        Button bingo = (Button) findViewById(R.id.bingoButton);

        final TextView answerView = (TextView) findViewById(R.id.answView);
        final TextView tailView = (TextView) findViewById(R.id.tailView);


        answerView.setText("answer " + answer);
        tailView.setText("your " + ran);


        smaller.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                max = ran;
                ran = value.binarySearch(min, max);
                tailView.setText("more bigger your number : " + ran);
                count++;
            }
        });

        bigger.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                min = ran;
                ran = value.binarySearch(min, max);
                tailView.setText("more smaller your number : " + ran);
                count++;
            }

        });

        bingo.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                tailView.setText("bingo");
            }

        });

    }
}
