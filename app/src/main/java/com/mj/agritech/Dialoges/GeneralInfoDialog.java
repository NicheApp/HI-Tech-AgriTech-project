package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.DialogFragment;

import com.mj.agritech.Familytable;
import com.mj.agritech.R;

import java.util.ArrayList;
import java.util.List;

public class GeneralInfoDialog extends DialogFragment {
    String FAMILY_ID;
    EditText baseline;
    Button submitquery;
    public GeneralInfoDialog(String FAMILY_ID)
    {
        this.FAMILY_ID=FAMILY_ID;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_generalinfo, container, false);


        submitquery= v.findViewById(R.id.submitinfo);
        baseline=v.findViewById(R.id.baselinesurvey);
        final Spinner spinner1 = v.findViewById(R.id.cast);
        final Spinner spinner2 =  v.findViewById(R.id.house);
        final Spinner spinner3=v.findViewById(R.id.toilet);
        final Spinner spinner4=v.findViewById(R.id.bls);
        final List<String> list = new ArrayList<String>();
        list.add("Caste/जाति");
        list.add("SC");
        list.add("ST");
        list.add("General");
        list.add("OBC");
        list.add("Others");
        final List<String> list2 = new ArrayList<String>();
        list2.add("House Type ");
        list2.add("Kutcha House");
        list2.add("Pucca House");

        final List<String> list3 = new ArrayList<String>();
        list3.add("Toilet Available");
        list3.add("YES");
        list3.add("NO");
        final List<String> list4 = new ArrayList<String>();
        list4.add("Year of BLS");
        list4.add("2019-20");
        list4.add("2020-21");
        list4.add("2021-22");
        list4.add("2022-23");
        list4.add("2023-24");


        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list2);
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list3);
        ArrayAdapter<String> myAdapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list4);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(myAdapter2);
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(myAdapter3);
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(myAdapter4);



        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=   list.get(spinner1.getSelectedItemPosition());
                String b= list2.get(spinner2.getSelectedItemPosition());
                String c= list3.get(spinner3.getSelectedItemPosition());
                String d= list4.get(spinner4.getSelectedItemPosition());
                String baselinesurvey=baseline.getText().toString();
                String type = "info";
                Familytable familytable = new Familytable(getContext(),v);
                familytable.execute(type, a, b, c, d,baselinesurvey,FAMILY_ID);

            }
        });

        // Do all the stuff to initialize your custom view

        return v;

    }






}
