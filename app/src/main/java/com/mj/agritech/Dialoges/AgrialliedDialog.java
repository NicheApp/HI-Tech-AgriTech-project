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
import androidx.fragment.app.FragmentManager;

import com.mj.agritech.Familytable;
import com.mj.agritech.R;
import com.mj.agritech.UpdateBackground;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.mj.agritech.showdataadapter.mainposition;
import static com.mj.agritech.showdataadapter.showjsonarray;

public class AgrialliedDialog extends DialogFragment {
    String FAMILY_ID;
    Button submitquery;
    List<String> list1;
    int entry_id;
FragmentManager fm;
    public AgrialliedDialog(String FAMILY_ID, List<String> list1, FragmentManager fm)
    {
        this.FAMILY_ID=FAMILY_ID;
        this.list1=list1;
        this.fm=fm;

    }


EditText Nameintervention,Cityintervention,Unitintervention,Areaundercultivation,Production,Annualincome,Annualexp,Netannual;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_alliedactivities, container, false);
        Nameintervention = v.findViewById(R.id.nameintervention);
        Cityintervention = v.findViewById(R.id.qtyofintervention);
        Unitintervention = v.findViewById(R.id.unitintervention);
        Areaundercultivation = v.findViewById(R.id.areacultivation);
        Production = v.findViewById(R.id.productionqt);
        Annualincome = v.findViewById(R.id.alliedannuallincome);
        Annualexp = v.findViewById(R.id.alliedexpenditure);
        Netannual = v.findViewById(R.id.alliednetannual);
        submitquery = v.findViewById(R.id.submitlocation);

        final Spinner spinner1 = v.findViewById(R.id.alliedactivity);


        spinner1.setPrompt("Allied Activity");

        final List<String> list = new ArrayList<String>();
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

        if(list1.size()>0)
        {


            try {
                JSONObject obj = showjsonarray.getJSONObject(mainposition);
                Nameintervention.setText(obj.getString("intv_name"));
                Cityintervention.setText(obj.getString("intv_qty"));
                Unitintervention.setText(obj.getString("intv_unit"));
                Areaundercultivation.setText(obj.getString("area"));
                Production.setText(obj.getString("production"));
                Annualincome.setText(obj.getString("ann_income"));
                Annualexp.setText(obj.getString("ann_exp"));
                Netannual.setText(obj.getString("net_annual"));
                entry_id=obj.getInt("entry_id");
                int spinnerPosition = myAdapter.getPosition(obj.getString("type"));
                spinner1.setSelection(spinnerPosition);

            } catch (JSONException e) {
                e.printStackTrace();
            }



        }
        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=   spinner1.getSelectedItem().toString();



                String type = "allied";

                if(list1.size()>0)
                {
                    UpdateBackground updateBackground = new UpdateBackground(getContext(), v);
                    updateBackground.execute(type, a, Nameintervention.getText().toString(),
                            Cityintervention.getText().toString(), Unitintervention.getText().toString(),
                            Areaundercultivation.getText().toString(), Production.getText().toString(),
                            Annualincome.getText().toString(),
                            Annualexp.getText().toString(), Netannual.getText().toString(),
                            FAMILY_ID,entry_id+"");
                    fm.popBackStackImmediate();
                    JSONArray emptyjson=new JSONArray();
                    showjsonarray=emptyjson;
                    list1.clear();

                }
                else {


                    Familytable familytable = new Familytable(getContext(), v);
                    familytable.execute(type, a, Nameintervention.getText().toString(),
                            Cityintervention.getText().toString(), Unitintervention.getText().toString(),
                            Areaundercultivation.getText().toString(), Production.getText().toString(),
                            Annualincome.getText().toString(),
                            Annualexp.getText().toString(), Netannual.getText().toString(),
                            FAMILY_ID);
                    fm.popBackStackImmediate();
                }

            }
        });

        // Do all the stuff to initialize your custom view

        return v;

    }


}
