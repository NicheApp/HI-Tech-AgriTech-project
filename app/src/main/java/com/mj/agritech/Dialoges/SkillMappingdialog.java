package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.mj.agritech.Familytable;
import com.mj.agritech.R;

public class SkillMappingdialog extends DialogFragment {
    EditText nameoftheperson,professional,training,institute,annualincome;
    String FAMILY_ID;
    Button submitquery;
    public SkillMappingdialog(String FAMILY_ID)
    {
        this.FAMILY_ID=FAMILY_ID;

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
        annualincome=v.findViewById(R.id.annualincome);
        nameoftheperson=v.findViewById(R.id.nameperson);
        submitquery=v.findViewById(R.id.submitlocation);


        // Do all the stuff to initialize your custom view


        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String type = "skillmapping";
                Familytable familytable = new Familytable(getContext());
                familytable.execute(type,nameoftheperson.getText().toString(),
                        professional.getText().toString(),training.getText().toString() ,
                        institute.getText().toString(),annualincome.getText().toString(),
                        FAMILY_ID);

            }
        });



        return v;

}

}
