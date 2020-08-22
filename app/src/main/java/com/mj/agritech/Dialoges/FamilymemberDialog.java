package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.fragment.app.DialogFragment;

import com.mj.agritech.Familytable;
import com.mj.agritech.R;

import java.util.ArrayList;
import java.util.List;

public class FamilymemberDialog extends DialogFragment {
EditText memname,memage,skills,mobile;
RadioButton gender;
Button submitquery;
    String gen,FAMILY_ID;


    public FamilymemberDialog(String FAMILY_ID)
    {
        this.FAMILY_ID=FAMILY_ID;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_familymember, container, false);
        submitquery= v.findViewById(R.id.submitmember);
        memname=v.findViewById(R.id.memname);
        memage=v.findViewById(R.id.memage);
        skills=v.findViewById(R.id.memskill);
        mobile=v.findViewById(R.id.memnumber);
        gender=v.findViewById(R.id.radioMale);


        final Spinner spinner1 = v.findViewById(R.id.memqualification);

        final List<String> list = new ArrayList<String>();
        list.add("Caste/जाति");
        list.add("SC");
        list.add("ST");
        list.add("General");
        list.add("OBC");
        list.add("Others");


        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);



        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(gender.isChecked())
                  gen ="Male";
              else
              {
                  gen="Female";
              }

                String type = "familymember";
                Familytable familytable = new Familytable(getContext());
                familytable.execute(type, memname.getText().toString(),
                        memage.getText().toString(),gen, list.get(spinner1.getSelectedItemPosition()),
                        skills.getText().toString(),memage.getText().toString()
                        ,FAMILY_ID);

            }
        });

        return v;

    }





}
