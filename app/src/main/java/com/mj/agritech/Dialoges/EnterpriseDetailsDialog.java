package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.DialogFragment;

import com.mj.agritech.R;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseDetailsDialog extends DialogFragment {
EditText Microenterprice,enterpenuername,nameofperson,expenditure,annualincome,netincome;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_enterprise, container, false);


        final Spinner spinner1 = v.findViewById(R.id.registrationenterprise);
        final Spinner spinner2 =  v.findViewById(R.id.partofgroup);
        Microenterprice=v.findViewById(R.id.enterprice);
        enterpenuername=v.findViewById(R.id.entrpenuername);
        nameofperson=v.findViewById(R.id.nameperson);
        expenditure=v.findViewById(R.id.annexpenditure);
        annualincome=v.findViewById(R.id.annincomeenterprise);
        netincome=v.findViewById(R.id.netincomeenterprise);



        spinner1.setPrompt("Crop Category");
        spinner2.setPrompt("Choose Crop");
        List<String> list = new ArrayList<String>();
        list.add("Registration");
        list.add("Registered");
        list.add("Non-Registered");


        final List<String> list2 = new ArrayList<String>();
        list2.add("Part of any group");
        list2.add("SHG");
        list2.add("Farmer's Group");
        list2.add("Co-operative");
        list2.add("FPO");
        list2.add("None");


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list2);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(myAdapter2);

        annualincome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {

                    netincome.setText((Double.parseDouble(annualincome.getText().toString())-Double.parseDouble(expenditure.getText().toString())) + "");
                }
                catch(Exception e)
                {

                    netincome.setText("");
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
