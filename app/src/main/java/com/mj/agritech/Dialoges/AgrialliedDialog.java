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

public class AgrialliedDialog extends DialogFragment {

EditText Nameintervention,Cityintervention,Unitintervention,Areaundercultivation,Production,Annualincome,Annualexp,Netannual;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_alliedactivities, container, false);
        Nameintervention=v.findViewById(R.id.nameintervention);
        Cityintervention=v.findViewById(R.id.qtyofintervention);
        Unitintervention=v.findViewById(R.id.unitintervention);
        Areaundercultivation=v.findViewById(R.id.areacultivation);
        Production=v.findViewById(R.id.productionqt);
        Annualincome=v.findViewById(R.id.alliedannuallincome);
        Annualexp=v.findViewById(R.id.alliedexpenditure);
        Netannual=v.findViewById(R.id.alliednetannual);


        final Spinner spinner1 = v.findViewById(R.id.alliedactivity);


       spinner1.setPrompt("Allied Activity");

        List<String> list = new ArrayList<String>();
        list.add("Allied Activity");
        list.add("Apiculture");
        list.add("Fishery");
        list.add("NTFP");
        list.add("Floriculture");
        list.add("Horiculture(Fruits)");
        list.add("Poultry");
        list.add("Sericulture");
        list.add("Tasar");list.add("LAC");
        list.add("Others");
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);
Annualexp.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        try {

            Netannual.setText((Double.parseDouble(Annualincome.getText().toString()) - Double.parseDouble(Annualexp.getText().toString())) + "");
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
