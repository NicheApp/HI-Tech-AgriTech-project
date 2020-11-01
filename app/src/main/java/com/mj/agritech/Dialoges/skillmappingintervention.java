package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.mj.agritech.R;
import com.mj.agritech.interventiondata;

public class skillmappingintervention extends DialogFragment {
    EditText nameoftheperson,professional,training,institute,annualincome;
    String FAMILY_ID,year;
    Button submitquery;
    public skillmappingintervention(String FAMILY_ID,String year)
    {
        this.FAMILY_ID=FAMILY_ID;
        this.year=year;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_skillmapping, container, false);
        nameoftheperson=v.findViewById(R.id.nameperson);
        professional=v.findViewById(R.id.typeofvocational);
        training=v.findViewById(R.id.durationoftraining);
        institute=v.findViewById(R.id.institution);
        annualincome=v.findViewById(R.id.annincomeskillmapping);
        nameoftheperson=v.findViewById(R.id.nameperson);
        submitquery=v.findViewById(R.id.submitlocation);


        // Do all the stuff to initialize your custom view


        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String type = "skillmapping";

                interventiondata interventiondata = new interventiondata(getContext());
                interventiondata.execute(type,nameoftheperson.getText().toString(),
                        professional.getText().toString(),training.getText().toString() ,
                        institute.getText().toString(),annualincome.getText().toString(),
                        year,
                        FAMILY_ID);

            }
        });



        return v;

    }

}
