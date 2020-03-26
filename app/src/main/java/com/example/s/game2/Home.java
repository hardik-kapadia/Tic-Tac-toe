package com.example.s.game2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Home extends AppCompatActivity
{
    public void ng(View v)
    {
        Intent i = new Intent(Home.this, MainActivity.class);
        startActivity(i);
    }
    public void disp_info(View v)
    {
        Intent i = new Intent(Home.this, about.class);
        startActivity(i);
    }
    public void score(View v)
    {
        Intent i = new Intent(Home.this, score.class);
        /*i.putExtra("red scorez",red_sco);
        i.putExtra("red scorez",yellow_sco);*/
        startActivity(i);
        Log.i("Info","Score demanded");
    }
    public void close(View v)
    {
        System.exit(0);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);/*
        Intent it = getIntent();
        red_sco = it.getIntExtra("red score",0);
        yellow_sco = it.getIntExtra("yellow score",0);*/
    }
}
