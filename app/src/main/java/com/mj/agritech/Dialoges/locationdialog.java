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




public class locationdialog extends DialogFragment {
Button submitquery;
EditText block,gp,village;
String FAMILY_ID;
public locationdialog(String FAMILY_ID)
{
    this.FAMILY_ID=FAMILY_ID;
}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_location, container, false);

        // Do all the stuff to initialize your custom view
        submitquery= v.findViewById(R.id.submitlocation);
        block=v.findViewById(R.id.block);
        gp=v.findViewById(R.id.gp);
        village=v.findViewById(R.id.village);
        final Spinner spinner1 = v.findViewById(R.id.trdsspinner);
        final Spinner spinner2 =  v.findViewById(R.id.state);
        final Spinner spinner3=v.findViewById(R.id.district);
        final List<String> list = new ArrayList<String>();
        list.add("TSRDS Operational Area");
        list.add("jamshedpur");
        list.add("West bokaro");
        list.add("jamabado");
        list.add("joda");
        list.add("Noamundi");
        list.add("Kalinga Nagar");
        list.add("Gomardih");
        list.add("Sukinda");
        list.add("Bamnipal");
        list.add("Gopalpur");
        final List<String> list2 = new ArrayList<String>();
        list2.add("State");
        list2.add("Jharkhand");
        list2.add("Odisha");

        final List<String> list3 = new ArrayList<String>();
        list3.add("District");
        list3.add("Dhanbad");
        list3.add("Dhenkanal");
        list3.add("Ramgarh");
        list3.add("Bokaro");
        list3.add("East Singhbhum");
        list3.add("West Singhbhum");
        list3.add("Saraikela-kharnsawan ");
        list3.add("Jaipur");
        list3.add("Keonjhar");
        list3.add("Ganjam");
        list3.add("Sundargarh");

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
           String a=   spinner1.getSelectedItem().toString();
             String b= list2.get(spinner2.getSelectedItemPosition());
             String c= list3.get(spinner3.getSelectedItemPosition());
              String bl=block.getText().toString();
            String g=  gp.getText().toString();
            String vl=  village.getText().toString();
                String type = "location";
                Familytable familytable = new Familytable(getContext(),v);
                familytable.execute(type, a, b, c, bl,g,vl,FAMILY_ID);

            }
        });



        return v;



    }





}
