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

public class CropCultivationDialog extends DialogFragment {

    EditText Totalproduction,Cultivatedarea,Yield,Marketrate,Totalincome,Expenditure,CostofCultivation,Netincome;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_cropcultivationdetails, container, false);
        Cultivatedarea=v.findViewById(R.id.cultivated_area);
        Totalproduction=v.findViewById(R.id.total_production);

        Yield=v.findViewById(R.id.yield);
        Marketrate=v.findViewById(R.id.market_Rate);
        Totalincome=v.findViewById(R.id.totalincome);
        Expenditure=v.findViewById(R.id.expenditure);
        CostofCultivation=v.findViewById(R.id.costcultivation);
        Netincome=v.findViewById(R.id.netincome);
        final Spinner spinner1 = v.findViewById(R.id.cropcategory);
        final Spinner spinner2 =  v.findViewById(R.id.cropsubcategory);
          spinner1.setPrompt("Crop Category");
          spinner2.setPrompt("Choose Crop");
          List<String> list = new ArrayList<String>();
          list.add("Crop Category");
          list.add("Kharif");
          list.add("Rabi");
          list.add("Zaid");

        final List<String> list2 = new ArrayList<String>();
        list2.add("Choose Crop");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list2);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(myAdapter2);

       Totalproduction.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {

                    Yield.setText((Double.parseDouble(Totalproduction.getText().toString()) / Double.parseDouble(Cultivatedarea.getText().toString())) + "");
                }
                catch(Exception e)
                {

                    Yield.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        Marketrate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {

                    Totalincome.setText((Double.parseDouble(Marketrate.getText().toString()) * Double.parseDouble(Totalproduction.getText().toString())) + "");
                }
                catch(Exception e)
                {

                    Totalincome.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        Expenditure.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {

                   CostofCultivation.setText((Double.parseDouble(Expenditure.getText().toString()) / Double.parseDouble(Cultivatedarea.getText().toString())) + "");
                }
                catch(Exception e)
                {

                   CostofCultivation.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        CostofCultivation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {

                    Netincome.setText((Double.parseDouble(Totalincome.getText().toString()) - Double.parseDouble(Expenditure.getText().toString())) + "");
                }
                catch(Exception e)
                {

                    Netincome.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });



        return v;

    }



}
