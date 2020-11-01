package com.mj.agritech.Dialoges;

import android.os.Bundle;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.mj.agritech.showdataadapter.mainposition;
import static com.mj.agritech.showdataadapter.showjsonarray;

public class IncomeDetailsDialog extends DialogFragment {
    EditText baselinedays,familymem,annualincome;
    String FAMILY_ID;
    Button submitquery;
    List<String> list1;
    int entry_id;
    FragmentManager fm;
    public IncomeDetailsDialog(String FAMILY_ID, List<String> list1, FragmentManager fm)
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
        View v = inflater.inflate(R.layout.dialoge_incomedetails, container, false);
        submitquery = v.findViewById(R.id.submitlocation);
        baselinedays = v.findViewById(R.id.daysengaged);
        familymem = v.findViewById(R.id.meminvolved);
        annualincome = v.findViewById(R.id.income);

        final Spinner spinner1 = v.findViewById(R.id.occupation);
        final Spinner spinner2 = v.findViewById(R.id.category);

        final List<String> list = new ArrayList<String>();
        list.add("Occupation");
        list.add("Small Buisness");
        list.add("Micro Enterprise");
        list.add("Agriculture and Allied");
        list.add("Wage Labour ");
        list.add("skill/Art");
        list.add("Any Other");
        final List<String> list2 = new ArrayList<String>();
        list2.add("Category ");
        list2.add("Primary");
        list2.add("Secondary");


        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list2);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(myAdapter2);

        if(list1.size() > 0){


            try {
                JSONObject obj = showjsonarray.getJSONObject(mainposition);
                baselinedays.setText(obj.getString("days"));
                int spinnerPosition = myAdapter.getPosition(obj.getString("occupation"));
                spinner1.setSelection(spinnerPosition);
                familymem.setText(obj.getString("members_involved"));
                annualincome.setText(obj.getString("annual_income"));
                int spinnerPosition1 = myAdapter2.getPosition(obj.getString("primary_secondary"));
                spinner2.setSelection(spinnerPosition1);
                entry_id=obj.getInt("entry_id");

            } catch (JSONException e) {
                e.printStackTrace();
            }



        }



        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a= list.get(spinner1.getSelectedItemPosition());
                String b= list2.get(spinner2.getSelectedItemPosition());

                String type = "incomedetails";


                if(list1.size() > 0)
                {
                    UpdateBackground updateBackground = new UpdateBackground(getContext(), v);
                    updateBackground.execute(type, a, b, baselinedays.getText().toString(), familymem.getText().toString(), annualincome.getText().toString(), FAMILY_ID
                    ,entry_id+"");
                    fm.popBackStackImmediate();
                    JSONArray emptyjson=new JSONArray();
                    showjsonarray=emptyjson;
                    list1.clear();
                }
                else {


                    Familytable familytable = new Familytable(getContext(), v);
                    familytable.execute(type, a, b, baselinedays.getText().toString(), familymem.getText().toString(), annualincome.getText().toString(), FAMILY_ID);
                    fm.popBackStackImmediate();
                }
            }
        });
        return v;

    }







}
