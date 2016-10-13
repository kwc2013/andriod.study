package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Average = (Button) findViewById(R.id.avrg);
        Button min = (Button) findViewById(R.id.min);

        final TextView showResult = (TextView) findViewById(R.id.showResult);

        Average.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                GetAverage average = new GetAverage();
                String result = String.valueOf(average.getResult());
                showResult.setText("Average : "+result);
            }
        });

        min.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                GetMin min1 = new GetMin();
                String result = String.valueOf(min1.getResult());
                showResult.setText("Average : "+result);
            }
        });




    }
}
