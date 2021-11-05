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
        LinearLayout mLayout = (LinearLayout)  findViewById(R.id.firstRow);
        RelativeLayout.LayoutParams mPagrams = (RelativeLayout.LayoutParams) mLayout.getLayoutParams();
        mPagrams.height = screenWidth/4;
        mPagrams.width = screenWidth;
        mLayout.setLayoutParams(mPagrams);


    }
}
