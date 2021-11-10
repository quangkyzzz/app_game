package com.example.find_same_picture_game;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class Mdialog extends DialogFragment {

    public TextView mText1;
    public TextView mText2;

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
                //Intent intent = new Intent(getView().getContext(), PlayingActivity.class);
                //startActivity(intent);
            }
        });
        builder.setNegativeButton(R.string.exit_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Intent intent = new Intent(getView().getContext(), MainActivity.class);
                //startActivity(intent);
            }
        });


        return builder.create();
    }
}
