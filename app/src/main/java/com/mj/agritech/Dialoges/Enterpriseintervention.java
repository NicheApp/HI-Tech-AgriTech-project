package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import com.mj.agritech.interventiondata;
import com.mj.agritech.updateintervention;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.mj.agritech.showdataadapter.mainposition;
import static com.mj.agritech.showdataadapter.showjsonarray;

public class Enterpriseintervention extends DialogFragment {
    String FAMILY_ID,year;
    Button submitquery;
    List<String> list1;
    int entry_id;
    FragmentManager fm;

    public Enterpriseintervention(String FAMILY_ID, List<String> list1, FragmentManager fm)
    {
        this.FAMILY_ID=FAMILY_ID;
        this.list1=list1;
        this.fm=fm;

    }
    EditText Microenterprice,enterpenuername,nameofperson,expenditure,annualincome,netincome;
    EditText Nameintervention,Quantity,unitintervention,ammountintervention;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_enterpriseintervention, container, false);


        final Spinner spinner1 = v.findViewById(R.id.registrationenterprise);
        final Spinner spinner2 =  v.findViewById(R.id.partofgroup);
        Microenterprice=v.findViewById(R.id.enterprice);
        enterpenuername=v.findViewById(R.id.entrpenuername);
        nameofperson=v.findViewById(R.id.personenvolved);
        expenditure=v.findViewById(R.id.annexpenditure);
        annualincome=v.findViewById(R.id.annincomeenterprise);
        netincome=v.findViewById(R.id.netincomeenterprise);
        submitquery=v.findViewById(R.id.submitlocation);

        Nameintervention=v.findViewById(R.id.nameintervention);
        Quantity=v.findViewById(R.id.qtyintervention);
        unitintervention=v.findViewById(R.id.unitmeasurement);
        ammountintervention=v.findViewById(R.id.ammountintervention);

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
        if(list1.size()>0)
        {

            try {
                JSONObject obj = showjsonarray.getJSONObject(mainposition);
                Microenterprice.setText(obj.getString("enterprise_name"));
                enterpenuername.setText(obj.getString("enterpreneur_name"));
                expenditure.setText(obj.getString("annual_exp"));
                netincome.setText(obj.getString("net_income"));
                annualincome.setText(obj.getString("annual_income"));
                nameofperson.setText(obj.getString("person_employed"));
                int spinnerPosition = myAdapter.getPosition(obj.getString("reg_status"));
                spinner1.setSelection(spinnerPosition);
                entry_id=obj.getInt("entry_id");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=   spinner1.getSelectedItem().toString();
                String b=  spinner2.getSelectedItem().toString();

                String type = "enterprise_details";
                if(list1.size()>0)
                {
                    updateintervention updateBackground = new updateintervention (getContext(), v);
                    updateBackground.execute(type, Microenterprice.getText().toString(),
                            enterpenuername.getText().toString(),
                            nameofperson.getText().toString(),
                            expenditure.getText().toString(), annualincome.getText().toString(),
                            netincome.getText().toString(), a, b,
                            FAMILY_ID,entry_id+"");
                    fm.popBackStackImmediate();
                    JSONArray emptyjson=new JSONArray();
                    showjsonarray=emptyjson;
                    Log.i("json array--------->",showjsonarray.length()+"");
                    list1.clear();
                }
                else {

                    interventiondata interventiondata = new interventiondata(getContext());
                    interventiondata.execute(type,Microenterprice.getText().toString(),
                            enterpenuername.getText().toString(),
                            nameofperson.getText().toString() ,
                            expenditure.getText().toString(),annualincome.getText().toString(),
                            netincome.getText().toString(),a,b,
                            year,Nameintervention.getText().toString(),Quantity.getText().toString(),
                            unitintervention.getText().toString(),ammountintervention.getText().toString(),FAMILY_ID);
                    fm.popBackStackImmediate();
                }


            }
        });


        // Do all the stuff to initialize your custom view

        return v;

    }





}
