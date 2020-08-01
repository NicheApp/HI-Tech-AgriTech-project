package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.DialogFragment;

import com.mj.agritech.R;

import java.util.ArrayList;
import java.util.List;


public class locationdialog extends DialogFragment {
Button submitquery;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_location, container, false);

        // Do all the stuff to initialize your custom view
        submitquery= v.findViewById(R.id.submitlocation);
        final Spinner spinner1 = v.findViewById(R.id.trdsspinner);
        final Spinner spinner2 =  v.findViewById(R.id.state);
        final Spinner spinner3=v.findViewById(R.id.district);
        List<String> list = new ArrayList<String>();
        list.add("TSRDS Operational Area");
        list.add("jamshedpur");
        list.add("West bokaro");
        list.add("jamabado");
        list.add("joda");

        final List<String> list2 = new ArrayList<String>();
        list2.add("State");

        final List<String> list3 = new ArrayList<String>();
        list3.add("District");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list2);
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list3);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(myAdapter2);
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(myAdapter3);



        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               

            }
        });



        return v;



    }





}
