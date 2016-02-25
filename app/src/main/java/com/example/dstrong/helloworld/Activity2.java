package com.example.dstrong.helloworld;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

    static final String activityText= "this is 2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        setupUIEvents();

        //Restores state when phone rotates or on resume from child activity
        if (savedInstanceState != null){
            restoreState(savedInstanceState);
        }
    }

    private void restoreState(Bundle savedInstanceState) {
        //(key,default if not found)
        String textValue = savedInstanceState.getString(activityText, activityText);
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(textValue);
    }

    void setupUIEvents() {
        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButton1Click((Button) view);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButton2Click((Button) view);
            }
        });
    }

    void handleButton1Click(View view){
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText("Clicked button");
    }
    void handleButton2Click(View view){
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText("Clicked other button");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState){
        //Store current text
        TextView text = (TextView) findViewById(R.id.textView);
        outState.putString(activityText, (String) text.getText());
    }
}
