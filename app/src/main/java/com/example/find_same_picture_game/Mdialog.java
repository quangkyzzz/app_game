package com.example.find_same_picture_game;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class Mdialog extends DialogFragment {

    public TextView mText1;
    public TextView mText2;
    ClickListener mClickListener;

    public interface ClickListener{
        public  void onMyClick(String message);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog,null);

        builder.setView(view);



        Bundle mBundle = getArguments();
        Integer score = mBundle.getInt("score");


        mText1 = (TextView) view.findViewById(R.id.dialog1);
        mText1.setText(R.string.congratulation);

        mText2 = (TextView) view.findViewById(R.id.dialog2);
        mText2.setText( getResources().getText(R.string.score_message)+score.toString() );


        builder.setPositiveButton(R.string.continue_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String message = "continue";
                mClickListener.onMyClick(message);
            }
        });
        builder.setNegativeButton(R.string.exit_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String message = "exit";
                mClickListener.onMyClick(message);
            }
        });


        return builder.create();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        Activity activity = (Activity) context;
        try{
            mClickListener = (ClickListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException((activity.toString()+" must override OnMessageRead..."));
        }
    }
}
