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

public class livestockDialog extends DialogFragment {
EditText Numbers,Annualincomelivestock,Rearing,Netannual;
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

        spinner1.setPrompt("Name of the LiveStock");

        List<String> list = new ArrayList<String>();
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

        // Do all the stuff to initialize your custom view

        return v;

    }


}
