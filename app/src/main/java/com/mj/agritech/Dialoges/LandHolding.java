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

public class LandHolding extends DialogFragment {
    String FAMILY_ID;
    Button submitquery;
    EditText totalland,irrigatd,perc;
    public LandHolding(String FAMILY_ID)
    {
        this.FAMILY_ID=FAMILY_ID;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_landholding, container, false);
        submitquery= v.findViewById(R.id.submitlocation);
        totalland=v.findViewById(R.id.totalland);
        irrigatd=v.findViewById(R.id.irrigatedland);
        perc=v.findViewById(R.id.percentageofirrigatedland);


        final Spinner spinner1 = v.findViewById(R.id.cropcategory);
        final Spinner spinner2 =  v.findViewById(R.id.cropsubcategory);
        final Spinner spinner3=v.findViewById(R.id.irrigationsource);
        final Spinner spinner4=v.findViewById(R.id.bls);
        final List<String> list = new ArrayList<String>();
        list.add("Ownership Type");
        list.add("Leased");
        list.add("Owned");

        final List<String> list2 = new ArrayList<String>();
        list2.add("Farmer Type");
        list2.add("Big(more than 10 acre)");
        list2.add("medium(5 to 10 acre)");
        list2.add("Small(2.5 to 10 acre)");
        list2.add("Marginal(0 to 2.5  acre)");list2.add("Landless");

        final List<String> list3 = new ArrayList<String>();
        list3.add("Irrigation Source");
        list3.add("Check Dam");
        list3.add("Pond");
        list3.add("Well");
        list3.add("Borewell");list3.add("Canal");
        list3.add("Lift irrigation");
        list3.add("Any other");





        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
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
                String a=   list.get(spinner1.getSelectedItemPosition());
                String b= list2.get(spinner2.getSelectedItemPosition());
                String c= list3.get(spinner3.getSelectedItemPosition());

                String type = "land_holding";
                Familytable familytable = new Familytable(getContext(),v);
                familytable.execute(type, a, b,totalland.getText().toString(),irrigatd.getText().toString(), c,perc.getText().toString() ,FAMILY_ID);

            }
        });
        return v;

    }



}
