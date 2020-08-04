package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.mj.agritech.R;

public class DailyWageDialoge extends DialogFragment {

    EditText familymembers,days,cultivatedarea,placeofwork,distance,wage,annualincome;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_dailywage, container, false);

        familymembers=v.findViewById(R.id.familymem);
        days=v.findViewById(R.id.daysenvolved);
        cultivatedarea=v.findViewById(R.id.cultivated_area);
        placeofwork=v.findViewById(R.id.placework);
        distance=v.findViewById(R.id.distance);
        wage=v.findViewById(R.id.wage);
        annualincome=v.findViewById(R.id.annincome);


        wage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {

                   annualincome.setText((Double.parseDouble(familymembers.getText().toString())*Double.parseDouble(days.getText().toString())*Double.parseDouble(wage.getText().toString())) + "");
                }
                catch(Exception e)
                {

                   annualincome.setText("");
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        // Do all the stuff to initialize your custom view

        return v;

    }



}
