package com.example.find_same_picture_game;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Collections;

public class PlayingActivity extends AppCompatActivity implements View.OnClickListener, Mdialog.ClickListener {

    public  ArrayList<Integer> mImageList = new ArrayList<Integer>();
    public  ArrayList<Integer> mButtonList = new ArrayList<Integer>();
    public  int count;
    Integer score=0;
    Integer complete=0;
    public  ArrayList<Integer> checkOpen = new ArrayList<Integer>();
    public  TextView scoretext;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        DisplayMetrics myDisplaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(myDisplaymetrics);
        int screenWidth = myDisplaymetrics.widthPixels;


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



        mImageList.add(R.drawable.ic_bloom);
        mImageList.add(R.drawable.ic_butterfree);
        mImageList.add(R.drawable.ic_clefairy);
        mImageList.add(R.drawable.ic_cyndaquil);
        mImageList.add(R.drawable.ic_eevee);
        mImageList.add(R.drawable.ic_jiggly);
        mImageList.add(R.drawable.ic_pikachu);
        mImageList.add(R.drawable.ic_spinda);
        mImageList.add(R.drawable.ic_whiscash);
        mImageList.add(R.drawable.ic_wooper);
        mImageList.add(R.drawable.ic_bloom);
        mImageList.add(R.drawable.ic_butterfree);
        mImageList.add(R.drawable.ic_clefairy);
        mImageList.add(R.drawable.ic_cyndaquil);
        mImageList.add(R.drawable.ic_eevee);
        mImageList.add(R.drawable.ic_jiggly);
        mImageList.add(R.drawable.ic_pikachu);
        mImageList.add(R.drawable.ic_spinda);
        mImageList.add(R.drawable.ic_whiscash);
        mImageList.add(R.drawable.ic_wooper);

        mButtonList.add(R.id.button11);
        mButtonList.add(R.id.button12);
        mButtonList.add(R.id.button13);
        mButtonList.add(R.id.button14);
        mButtonList.add(R.id.button21);
        mButtonList.add(R.id.button22);
        mButtonList.add(R.id.button23);
        mButtonList.add(R.id.button24);
        mButtonList.add(R.id.button31);
        mButtonList.add(R.id.button32);
        mButtonList.add(R.id.button33);
        mButtonList.add(R.id.button34);
        mButtonList.add(R.id.button41);
        mButtonList.add(R.id.button42);
        mButtonList.add(R.id.button43);
        mButtonList.add(R.id.button44);
        mButtonList.add(R.id.button51);
        mButtonList.add(R.id.button52);
        mButtonList.add(R.id.button53);
        mButtonList.add(R.id.button54);

        scoretext = (TextView) findViewById(R.id.text1);

        Collections.shuffle(mImageList);

        count=0;
        for (int i=0; i<20; i++){
            checkOpen.add(0);
        }
    }

    public Boolean checkScored(int poss){
        for (int i=0; i<20; i++){
            if (checkOpen.get(i) == 1 ){
                if ( mImageList.get(i).equals(mImageList.get(poss)) ){
                    Animation anima = (Animation) AnimationUtils.loadAnimation(this, R.anim.rotate);
                    ImageButton mButton = (ImageButton) findViewById(mButtonList.get(i));
                    mButton.setAnimation(anima);
                    mButton.setVisibility(View.INVISIBLE);
                    mButton.setClickable(false);

                    mButton = (ImageButton) findViewById(mButtonList.get(poss));
                    mButton.setAnimation(anima);
                    mButton.setVisibility(View.INVISIBLE);
                    mButton.setClickable(false);
                    checkOpen.set(i,0);
                    complete++;
                    return true;
                }
                else return false;
            }
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        int poss = mButtonList.indexOf(v.getId());
        ImageButton mButton;

        if (checkOpen.get(poss) == 1) {
            mButton = (ImageButton) findViewById(mButtonList.get(poss));
        }
        else if (count < 2) {
            mButton = (ImageButton) findViewById(mButtonList.get(poss));
            mButton.setBackgroundResource(mImageList.get(poss));
            if (count == 0) {
                count++;
                checkOpen.set(poss, 1);
            }
            else if (count == 1){
                if (!checkScored(poss)){
                    score--;
                    if (score < 0) score=0;
                    scoretext.setText("score:"+score.toString());
                    count++;
                    checkOpen.set(poss,1);
                }
                else{
                    score+=10;
                    scoretext.setText("score:"+score.toString());
                    count=0;
                    if (complete==10) {
                        DialogFragment endDialog = new Mdialog();
                        Bundle mBundle = new Bundle();
                        mBundle.putInt("score",score);
                        endDialog.setArguments(mBundle);
                        endDialog.show(getSupportFragmentManager(),"tag");
                    }
                }
            }
        }
        else {
            for (int i=0; i<20; i++){
                if (checkOpen.get(i) == 1){
                    mButton = (ImageButton) findViewById(mButtonList.get(i));
                    mButton.setBackgroundResource(R.drawable.question_button_state_list);
                    checkOpen.set(i,0);
                    count--;
                }
            }

            mButton = (ImageButton) findViewById(mButtonList.get(poss));
            mButton.setBackgroundResource(mImageList.get(poss));
            checkOpen.set(poss,1);
            count++;

        }
    }

    public void resetState(){
        ImageButton mButton;
        for (int i=0; i<20; i++){
            mButton = (ImageButton) findViewById(mButtonList.get(i));
            mButton.setClickable(true);
            mButton.setVisibility(View.VISIBLE);
            mButton.setBackgroundResource(R.drawable.question_button_state_list);
            checkOpen.set(i,0);
        }
        count=0;
        score=0;
        complete=0;
        scoretext.setText("score:0");
        Collections.shuffle(mImageList);
    }

    @Override
    public void onMyClick(String message) {
        if (message == "continue") {
            resetState();
        }
        else if (message == "exit"){
            finish();
        }


    }
}
