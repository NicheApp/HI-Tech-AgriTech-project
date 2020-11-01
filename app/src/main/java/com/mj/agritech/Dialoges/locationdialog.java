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


public class locationdialog extends DialogFragment {
Button submitquery;
EditText block,gp,village;
String FAMILY_ID;
FragmentManager fm;
    List<String> list1;

    public locationdialog(String FAMILY_ID, List<String> list1, FragmentManager fm)
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
        list.add("Jamshedpur");
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

        if(list1.size() > 0) {
            try {
                JSONObject obj = showjsonarray.getJSONObject(mainposition);
                if (list1.get(0)!=null) {
                    int spinnerPosition = myAdapter.getPosition(list1.get(0));
                    spinner1.setSelection(spinnerPosition);
                }

                if (list1.get(4)!=null) {
                    int spinnerPosition2 = myAdapter3.getPosition(list1.get(4));
                    spinner3.setSelection(spinnerPosition2);
                }

                gp.setText(list1.get(2));
                block.setText(list1.get(3));
                int spinnerPosition3 = myAdapter2.getPosition(obj.getString("state"));
                spinner2.setSelection(spinnerPosition3);
                village.setText(obj.getString("village"));

            } catch (JSONException e) {
                e.printStackTrace();
            }




        }

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
                if(list1.size()>0)
                {
                   UpdateBackground updateBackground = new UpdateBackground(getContext(),v);
                    updateBackground.execute(type, a, b, c, bl,g,vl,FAMILY_ID);
                    fm.popBackStackImmediate();
                    JSONArray emptyjson=new JSONArray();
                    showjsonarray=emptyjson;
                    list1.clear();
                }
                else{
                Familytable familytable = new Familytable(getContext(),v);
                familytable.execute(type, a, b, c, bl,g,vl,FAMILY_ID);
                    fm.popBackStackImmediate();
                }

            }
        });



        return v;



    }





}
