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

public class livestockDialog extends DialogFragment {
EditText Numbers,Annualincomelivestock,Rearing,Netannual;
    String FAMILY_ID;
    Button submitquery;
    public livestockDialog(String FAMILY_ID)
    {
        this.FAMILY_ID=FAMILY_ID;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_livestockdetails, container, false);
        final Spinner spinner1 = v.findViewById(R.id.livestock);
        Numbers=v.findViewById(R.id.numbers);
        Annualincomelivestock=v.findViewById(R.id.annualincome);
        Rearing=v.findViewById(R.id.costearning);
        Netannual=v.findViewById(R.id.netannual);
        submitquery=v.findViewById(R.id.submitlocation);

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
                String a=   list.get(spinner1.getSelectedItemPosition());


                String type = "livestock";
                Familytable familytable = new Familytable(getContext());
                familytable.execute(type, a,Numbers.getText().toString(),
                        Annualincomelivestock.getText().toString(),Rearing.getText().toString() ,
                        Netannual.getText().toString(),FAMILY_ID);

            }
        });


        // Do all the stuff to initialize your custom view

        return v;

    }


}
