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

public class IncomeDetailsDialog extends DialogFragment {
    EditText baselinedays,familymem,annualincome;
    String FAMILY_ID;
    Button submitquery;
public IncomeDetailsDialog(String FAMILY_ID)
{
    this.FAMILY_ID=FAMILY_ID;

}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_incomedetails, container, false);
        submitquery= v.findViewById(R.id.submitlocation);
        baselinedays=v.findViewById(R.id.daysengaged);
        familymem=v.findViewById(R.id.meminvolved);
        annualincome=v.findViewById(R.id.income);

        final Spinner spinner1 = v.findViewById(R.id.occupation);
        final Spinner spinner2 =  v.findViewById(R.id.category);

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




        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a= String.valueOf(spinner1.getSelectedItemPosition());
                String b= String.valueOf(spinner2.getSelectedItemPosition());

                String type = "incomedetails";
                Familytable familytable = new Familytable(getContext());
                familytable.execute(type, a, b, baselinedays.getText().toString(), familymem.getText().toString(),annualincome.getText().toString(),FAMILY_ID);

            }
        });
        return v;

    }







}
