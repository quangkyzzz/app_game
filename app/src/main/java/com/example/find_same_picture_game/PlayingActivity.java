package com.example.find_same_picture_game;

import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        DisplayMetrics myDisplaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(myDisplaymetrics);
        int screenHeight = myDisplaymetrics.heightPixels;
        int screenWidth = myDisplaymetrics.widthPixels;

        //EditText mytext = (EditText) findViewById(R.id.text1);
        //mytext.setText(Integer.toString(screenHeight));
        LinearLayout Layout1 = (LinearLayout)  findViewById(R.id.firstRow);
        RelativeLayout.LayoutParams mPagrams = (RelativeLayout.LayoutParams) Layout1.getLayoutParams();
        mPagrams.height = screenWidth/4;
        mPagrams.width = screenWidth;
        Layout1.setLayoutParams(mPagrams);

        LinearLayout Layout2 = (LinearLayout) findViewById(R.id.secondRow);
        mPagrams = (RelativeLayout.LayoutParams) Layout2.getLayoutParams();
        mPagrams.height = screenWidth/4;
        mPagrams.width = screenWidth;
        Layout2.setLayoutParams(mPagrams);

        LinearLayout Layout3 = (LinearLayout) findViewById(R.id.thirdRow);
        mPagrams = (RelativeLayout.LayoutParams) Layout3.getLayoutParams();
        mPagrams.height = screenWidth/4;
        mPagrams.width = screenWidth;
        Layout3.setLayoutParams(mPagrams);

        LinearLayout Layout4 = (LinearLayout) findViewById(R.id.fourthRow);
        mPagrams = (RelativeLayout.LayoutParams) Layout4.getLayoutParams();
        mPagrams.height = screenWidth/4;
        mPagrams.width = screenWidth;
        Layout4.setLayoutParams(mPagrams);

        LinearLayout Layout5 = (LinearLayout) findViewById(R.id.fifthRow);
        mPagrams = (RelativeLayout.LayoutParams) Layout5.getLayoutParams();
        mPagrams.height = screenWidth/4;
        mPagrams.width = screenWidth;
        Layout5.setLayoutParams(mPagrams);



    }
}
