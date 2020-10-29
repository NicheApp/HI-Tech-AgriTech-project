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

import com.mj.agritech.R;
import com.mj.agritech.interventiondata;

import java.util.ArrayList;
import java.util.List;

public class livestockintervention extends DialogFragment {
    EditText Numbers,Annualincomelivestock,Rearing,Netannual;
    EditText Nameintervention,Quantity,unitintervention,ammountintervention;
    String FAMILY_ID,year;
    Button submitquery;
    public livestockintervention(String FAMILY_ID,String year)
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
        View v = inflater.inflate(R.layout.dialoge_livestockintervention, container, false);
        final Spinner spinner1 = v.findViewById(R.id.livestock);
        Numbers=v.findViewById(R.id.numbers);
        Annualincomelivestock=v.findViewById(R.id.annualincome);
        Rearing=v.findViewById(R.id.costearning);
        Netannual=v.findViewById(R.id.netannual);
        submitquery=v.findViewById(R.id.submitlocation);

        Nameintervention=v.findViewById(R.id.nameintervention);
        Quantity=v.findViewById(R.id.qtyintervention);
        unitintervention=v.findViewById(R.id.unitmeasurement);
        ammountintervention=v.findViewById(R.id.ammountintervention);

        spinner1.setPrompt("Name of the LiveStock");

        final List<String> list = new ArrayList<String>();
        list.add("Name of the LiveStock");
        list.add("Cow");
        list.add("Ox");
        list.add("Buffallow");
        list.add("Got");
        list.add("Sheep");
        list.add("Pig");
        list.add("Hen");
        list.add("Duck");
        list.add("Others");
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);

        Rearing.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {

                    Netannual.setText((Double.parseDouble(Annualincomelivestock.getText().toString()) - Double.parseDouble(Rearing.getText().toString())) + "");
                }
                catch(Exception e)
                {

                    Netannual.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=list.get(spinner1.getSelectedItemPosition());


                String type = "livestock";
                interventiondata interventiondata = new interventiondata(getContext());
                interventiondata.execute(type, a,Numbers.getText().toString(),
                        Annualincomelivestock.getText().toString(),Rearing.getText().toString() ,
                        Netannual.getText().toString(),year,Nameintervention.getText().toString(),Quantity.getText().toString(),
                        unitintervention.getText().toString(),ammountintervention.getText().toString(),FAMILY_ID);

            }
        });


        // Do all the stuff to initialize your custom view

        return v;

    }


}
