package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.mj.agritech.Familytable;
import com.mj.agritech.R;

public class DailyWageDialoge extends DialogFragment {

    String FAMILY_ID;
    Button submitquery;
    public DailyWageDialoge(String FAMILY_ID)
    {
        this.FAMILY_ID=FAMILY_ID;

    }
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
        submitquery=v.findViewById(R.id.submitlocation);


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

        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String type = "daily_wage";
                Familytable familytable = new Familytable(getContext());
                familytable.execute(type, familymembers.getText().toString(),
                        days.getText().toString(),cultivatedarea.getText().toString() ,
                        placeofwork.getText().toString(),distance.getText().toString(),
                        wage.getText().toString(),annualincome.getText().toString(),

                        FAMILY_ID);

            }
        });


        // Do all the stuff to initialize your custom view

        return v;

    }



}
