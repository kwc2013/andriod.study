package com.example.user.quickcoding05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView Tv1;
    TextView Tv2;
    EditText Ed;
    Button input;
    Button finish;

    String int_text;
    String str_text;

    int cnt1 = 0;
    int cnt2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> stringList = new LinkedList<>();
        final List<Integer> intList = new LinkedList<>();

        Tv1 = (TextView)findViewById(R.id.IntText);
        Tv2 = (TextView)findViewById(R.id.StrText);

        Ed = (EditText)findViewById(R.id.text) ;

        input = (Button)findViewById(R.id.BTNInput);
        finish = (Button)findViewById(R.id.BTNend);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sr = String.valueOf(Ed.getText());
                try {
                    int i = Integer.parseInt(sr);
                    intList.add(i);
                    int_text += intList.get(cnt1++) + ", ";
                }catch(NumberFormatException e){
                    stringList.add(sr);
                    str_text += stringList.get(cnt2++) + ", ";
                }
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tv1.setText(int_text);
                Tv2.setText(str_text);
            }
        });
    }
}