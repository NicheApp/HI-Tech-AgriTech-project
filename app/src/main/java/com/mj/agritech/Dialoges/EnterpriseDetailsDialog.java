package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class EnterpriseDetailsDialog extends DialogFragment {
    String FAMILY_ID;
    Button submitquery;
    public EnterpriseDetailsDialog(String FAMILY_ID)
    {
        this.FAMILY_ID=FAMILY_ID;

    }
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
        nameofperson=v.findViewById(R.id.personenvolved);
        expenditure=v.findViewById(R.id.annexpenditure);
        annualincome=v.findViewById(R.id.annincomeenterprise);
        netincome=v.findViewById(R.id.netincomeenterprise);
        submitquery=v.findViewById(R.id.submitlocation);



        spinner1.setPrompt("Crop Category");
        spinner2.setPrompt("Choose Crop");
        final List<String> list = new ArrayList<String>();
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

        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=   spinner1.getSelectedItem().toString();
                String b=  spinner2.getSelectedItem().toString();

                String type = "enterprise_details";
                Familytable familytable = new Familytable(getContext());
                familytable.execute(type,Microenterprice.getText().toString(),
                        enterpenuername.getText().toString(),
                        nameofperson.getText().toString() ,
                        expenditure.getText().toString(),annualincome.getText().toString(),
                        netincome.getText().toString(),a,b,
                        FAMILY_ID);

            }
        });


        // Do all the stuff to initialize your custom view

        return v;

    }





}
