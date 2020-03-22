package com.example.s.game2;

import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    int player =0;
    int x[][] = new int[3][3];
    public void move(View view)
    {
        ImageView box = (ImageView) view;
        if(player%2 == 0)
        {
            box.setImageResource(R.drawable.red);
            switch(box.getId())
            {
                case (R.id.box00) : x[0][0] = 1;
                    //Log.i("Info","Set2");
                    break;
                case (R.id.box10) : x[1][0] = 1;
                    break;
                case (R.id.box20) : x[2][0] = 1;
                    break;
                case (R.id.box01) : x[0][1] = 1;
                    break;
                case (R.id.box11) : x[1][1] = 1;
                    break;
                case (R.id.box21) : x[2][1] = 1;
                    break;
                case (R.id.box02) : x[0][2] = 1;
                    break;
                case (R.id.box12) : x[1][2] = 1;
                    break;
                case (R.id.box22) : x[2][2] = 1;
                    break;
                default:
                    Log.i("Info", "No Data set");
            }
        }
        else{
            box.setImageResource(R.drawable.yellow);
            switch(box.getId())
            {
                case (R.id.box00) : x[0][0] = 2;
                    //Log.i("Info","Set2");
                    break;
                case (R.id.box10) : x[1][0] = 2;
                    break;
                case (R.id.box20) : x[2][0] = 2;
                    break;
                case (R.id.box01) : x[0][1] = 2;
                    break;
                case (R.id.box11) : x[1][1] = 2;
                    break;
                case (R.id.box21) : x[2][1] = 2;
                    break;
                case (R.id.box02) : x[0][2] = 2;
                    break;
                case (R.id.box12) : x[1][2] = 2;
                    break;
                case (R.id.box22) : x[2][2] = 2;
                    break;
                default:
                    Log.i("Info", "No Data set");
            }
        }
        player++;
        int ch = check();
        if(ch == 1)
        {
            final Toast t = Toast.makeText(MainActivity.this," Team Red Wins ", Toast.LENGTH_LONG);
            t.show();
            new CountDownTimer(2500, 1000)
            {
                public void onTick(long millisUntilFinished) {
                    //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                    //Toast.makeText(MainActivity.this, "seconds remaining " +  millisUntilFinished/1000, Toast.LENGTH_SHORT).show();
                }
                public void onFinish() {
                    t.cancel();
                    reset();
                }

            }.start();
        }
        else if(ch == 2)
        {
            final Toast t = Toast.makeText(MainActivity.this," Team Yellow wins ", Toast.LENGTH_SHORT);
            t.show();
            new CountDownTimer(2500, 1000)
            {
                public void onTick(long millisUntilFinished) {
                    //Toast.makeText(MainActivity.this, "seconds remaining " +  millisUntilFinished/1000, Toast.LENGTH_SHORT).show();//"seconds remaining: " + millisUntilFinished / 1000);
                }
                public void onFinish() {
                    t.cancel();
                    reset();
                }

            }.start();
        }
        else if(ch == 0)
        {
            final Toast t = Toast.makeText(MainActivity.this, "Next Turn", Toast.LENGTH_SHORT);//.show();
            t.show();
            new CountDownTimer(500,100)
            {
                public void onTick(long millisUntilFinished) {
                    //Toast.makeText(MainActivity.this, "seconds remaining " +  millisUntilFinished/1000, Toast.LENGTH_SHORT).show();//"seconds remaining: " + millisUntilFinished / 1000);
                }
                public void onFinish() {
                    t.cancel();
                }

            }.start();


        }
        if(player == 9)
        {
            final Toast t = Toast.makeText(MainActivity.this, "Game ends in a draw", Toast.LENGTH_SHORT);//.show();
            t.show();
            new CountDownTimer(2500, 1000)
            {
                public void onTick(long millisUntilFinished) {
                    //Toast.makeText(MainActivity.this, "seconds remaining " +  millisUntilFinished/1000, Toast.LENGTH_SHORT).show();//"seconds remaining: " + millisUntilFinished / 1000);
                }
                public void onFinish() {
                    t.cancel();
                    reset();
                }

            }.start();
        }
    }
    public int check()
    {
        for(int i=0;i<3;i++)
        {
            if(x[i][0] == x[i][1] && x[i][0] == x[i][2] && x[i][0] !=0)
                return x[i][0];
        }
        for(int j=0;j<3;j++)
        {
            if(x[0][j] == x[1][j]&& x[0][j] == x[2][j] && x[0][j] != 0)
                    return x[0][j];
        }
        if(((x[1][1] == x[2][2] && x[2][2] == x[0][0]) || (x[1][1] == x[0][2] && x[1][1] == x[2][0])) && x[1][1] != 0)
        {
            return x[1][1];
        }
        return (0);
    }
    public void reset()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                x[i][j] = 0;
            }
        }
        ImageView[] img = new ImageView[9];
        img[0] = (ImageView)findViewById(R.id.box00);
        img[1] = (ImageView)findViewById(R.id.box10);
        img[2] = (ImageView)findViewById(R.id.box20);
        img[3] = (ImageView)findViewById(R.id.box01);
        img[4] = (ImageView)findViewById(R.id.box11);
        img[5] = (ImageView)findViewById(R.id.box21);
        img[6] = (ImageView)findViewById(R.id.box02);
        img[7] = (ImageView)findViewById(R.id.box12);
        img[8] = (ImageView)findViewById(R.id.box22);
        for(int i=0;i<9;i++)
        {
            img[i].setImageResource(0);
        }
        player =0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
