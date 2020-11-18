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
import com.mj.agritech.interventiondata;
import com.mj.agritech.updateintervention;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.mj.agritech.showdataadapter.mainposition;
import static com.mj.agritech.showdataadapter.showjsonarray;

public class livestockintervention extends DialogFragment {
    EditText Numbers,Annualincomelivestock,Rearing,Netannual;
    EditText Nameintervention,Quantity,unitintervention,ammountintervention;
    String FAMILY_ID,year;
    Button submitquery;
    List<String> list1;
    int entry_id;
    FragmentManager fm;

    public livestockintervention(String FAMILY_ID, List<String> list1, FragmentManager fm)
    {
        this.FAMILY_ID=FAMILY_ID;
        this.list1=list1;
        this.fm=fm;

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
        if(list1.size()>0)
        {

            try {
                JSONObject obj = showjsonarray.getJSONObject(mainposition);
                Numbers.setText(obj.getString("number"));
                Annualincomelivestock.setText(obj.getString("annual_income"));
                Rearing.setText(obj.getString("cost"));
                Netannual.setText(obj.getString("net_income"));

                int spinnerPosition = myAdapter.getPosition(obj.getString("name"));
                spinner1.setSelection(spinnerPosition);
                entry_id=obj.getInt("entry_id");

            } catch (JSONException e) {
                e.printStackTrace();
            }



        }

        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=spinner1.getSelectedItem().toString();


                String type = "livestock";
                if(list1.size()>0)
                {
                    updateintervention  updateBackground = new updateintervention(getContext(), v);
                    updateBackground.execute(type, a, Numbers.getText().toString(),
                            Annualincomelivestock.getText().toString(), Rearing.getText().toString(),
                            Netannual.getText().toString(), FAMILY_ID,entry_id+"");
                    fm.popBackStackImmediate();
                    JSONArray emptyjson=new JSONArray();
                    showjsonarray=emptyjson;
                    list1.clear();
                }
                else {

                    interventiondata interventiondata = new interventiondata(getContext());
                    interventiondata.execute(type, a,Numbers.getText().toString(),
                            Annualincomelivestock.getText().toString(),Rearing.getText().toString() ,
                            Netannual.getText().toString(),year,Nameintervention.getText().toString(),Quantity.getText().toString(),
                            unitintervention.getText().toString(),ammountintervention.getText().toString(),FAMILY_ID);

                    fm.popBackStackImmediate();
                }

            }
        });


        // Do all the stuff to initialize your custom view

        return v;

    }


}
