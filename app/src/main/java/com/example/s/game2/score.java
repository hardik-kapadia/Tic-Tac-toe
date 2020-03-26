package com.example.s.game2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class score extends AppCompatActivity
{
    public void return2(View v)
    {
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }
    public void reset(View v)
    {
        MainActivity.red_s = 0;
        MainActivity.yellow_s = 0;
        TextView red =  (TextView) findViewById(R.id.red_score);
        TextView yellow = (TextView) findViewById(R.id.yellow_score);
        red.setText("0");
        yellow.setText("0");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent it = getIntent();
       // int red_scor, yellow_scor;
        //red_scor = it.getIntExtra("red scorez",0);
        //yellow_scor = it.getIntExtra("yellow scorez",0);
        TextView red =  (TextView) findViewById(R.id.red_score);
        TextView yellow = (TextView) findViewById(R.id.yellow_score);
        red.setText(Integer.toString(MainActivity.red_s));
        yellow.setText(Integer.toString(MainActivity.yellow_s));
    }
}
