package com.mj.agritech;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.DialogFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class showdata extends DialogFragment {
    ListView listView;
    String s,type;

    showdata(String s, String type)
    {

        this.s=s;
        this.type=type;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_showdata, container, false);

        listView = (ListView) v.findViewById(R.id.listView);
        try {
            loadIntoListView(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return v;

    }



    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        List<String> ls=new ArrayList<String>();
        if(type.equals("location")) {
         //   if(ls.size()>1)
          //  {ls.clear();}
for(int i=0;i<jsonArray.length();i++)
{
    JSONObject obj = jsonArray.getJSONObject(i);
    ls.add("TSRDS_op_area: " +obj.getString("TSRDS_op_area")+"\nyear_of_BLS: " +obj.getString("year_of_BLS")+
            "\ngp:" +obj.getString("gp") +"\nBlock:" +obj.getString("block")+"Dist: " +obj.getString("dist"));



}



        }
        else if(type.equals("info"))
        {
           // if(ls.size()>1)
            //{ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj = jsonArray.getJSONObject(i);
                ls.add(obj.getString("year_of_BLS"));
                ls.add("Date: "+obj.getString("date"));
                ls.add("House Type: "+obj.getString("house_type"));
                ls.add("Toilet: "+obj.getString("toilet"));
                ls.add("Caste: "+obj.getString("caste"));


            }



        }
        else if(type.equals("familymember"))
        {
            if(ls.size()>1)
            {ls.clear();}


            for(int i=0;i<jsonArray.length();i++)
            {  JSONObject obj = jsonArray.getJSONObject(i);

                ls.add("name:" +obj.getString("name"));
                ls.add("caste:" +obj.getString("caste"));
                ls.add("age:" +obj.getString("age"));
                ls.add("sex:" +obj.getString("sex"));
                ls.add("ed_status:" +obj.getString("ed_status"));
                ls.add("skill:" +obj.getString("skill"));
                ls.add("mobile:" +obj.getString("mobile"));
                ls.add("edu_other:" +obj.getString("edu_other"));
                ls.add("-----------------------");
            }





        }

        else if(type.equals("incomedetails"))
        {
            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            {  JSONObject obj = jsonArray.getJSONObject(i);

                ls.add("occupation:" +obj.getString("occupation"));
                ls.add("days:" +obj.getString("days"));
                ls.add("members_involved:" +obj.getString("members_involved"));
                ls.add("annual_income:" +obj.getString("annual_income"));
                ls.add("primary_secondary:" +obj.getString("primary_secondary"));


            }




        }

        else if(type.equals("land_holding"))
        {
            if(ls.size()>1)
            {ls.clear();}

            for(int i=0;i<jsonArray.length();i++)
            {   JSONObject obj = jsonArray.getJSONObject(i);
                ls.add("land_owned:" +obj.getString("land_owned"));
                ls.add("family_id:" +obj.getString("family_id"));
                ls.add("irrigated_land:" +obj.getString("irrigated_land"));
                ls.add("land_category:" +obj.getString("land_category"));
                ls.add("irrigated_percentage:" +obj.getString("irrigated_percentage"));
                ls.add("ownership_type:" +obj.getString("ownership_type"));
                ls.add("irrigation_source:" +obj.getString("irrigation_source"));

            }






        }

        else if(type.equals("crop_cultivation"))
        {
            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            {   JSONObject obj = jsonArray.getJSONObject(i);
                ls.add("cat:" +obj.getString("cat"));
                ls.add("cultivated_area:" +obj.getString("cultivated_area"));
                ls.add("yield:" +obj.getString("yield"));
                ls.add("ttl_prod:" +obj.getString("ttl_prod"));
                ls.add("market_rate:" +obj.getString("market_rate"));
                ls.add("total_income:" +obj.getString("total_income"));
                ls.add("cultivation_cost:" +obj.getString("cultivation_cost"));
                ls.add("net_income:" +obj.getString("net_income"));
                ls.add("bsl_crop:" +obj.getString("bsl_crop"));
                ls.add("ttl_expenditure:" +obj.getString("ttl_expenditure"));
            }




        }

        else if(type.equals("livestock"))
        {
            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            {   JSONObject obj = jsonArray.getJSONObject(i);
                ls.add("number:" +obj.getString("number"));
                ls.add("name:" +obj.getString("name"));
                ls.add("cost:" +obj.getString("cost"));
                ls.add("annual_income:" +obj.getString("annual_income"));
                ls.add("net_income:" +obj.getString("net_income"));
            }




        }

        else if(type.equals("allied"))
        {
            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            {   JSONObject obj = jsonArray.getJSONObject(i);
                ls.add("area:" +obj.getString("area"));
                ls.add("production:" +obj.getString("production"));
                ls.add("ann_income:" +obj.getString("ann_income"));
                ls.add("ann_exp:" +obj.getString("ann_exp"));
                ls.add("net_annual:" +obj.getString("net_annual"));
                ls.add("intv_name:" +obj.getString("intv_name"));
                ls.add("intv_qty:" +obj.getString("intv_qty"));
                ls.add("intv_unit:" +obj.getString("intv_unit"));
                ls.add(",bsl_allied:" +obj.getString("bsl_allied"));
            }





        }

        else if(type.equals("daily_wage"))
        {
            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            {  JSONObject obj = jsonArray.getJSONObject(i);
                ls.add("members_count:" +obj.getString("members_count"));
                ls.add("days_involved:" +obj.getString("days_involved"));
                ls.add("place:" +obj.getString("place"));
                ls.add("distance:" +obj.getString("distance"));
                ls.add("intv_year:" +obj.getString("intv_year"));
                ls.add("annual_income:" +obj.getString("annual_income"));
                ls.add("wage:" +obj.getString("wage"));
            }



        }
        else if(type.equals("skillmapping"))
        {
            if(ls.size()>1)
            {ls.clear();}

            for(int i=0;i<jsonArray.length();i++)
            {  JSONObject obj = jsonArray.getJSONObject(i);
                ls.add("name:" +obj.getString("name"));
                ls.add("skill:" +obj.getString("skill"));
                ls.add("annual_income:" +obj.getString("annual_income"));
                ls.add("institute:" +obj.getString("institute"));
                ls.add("duration:" +obj.getString("duration"));

            }

        }
        else if(type.equals("enterprise_details"))
        {
            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            { JSONObject obj = jsonArray.getJSONObject(i);
                ls.add("enterprise_name:" +obj.getString("enterprise_name"));
                ls.add("enterpreneur_name:" +obj.getString("enterpreneur_name"));
                ls.add("annual_exp:" +obj.getString("annual_exp"));
                ls.add("annual_income:" +obj.getString("annual_income"));
                ls.add("net_income:" +obj.getString("net_income"));
                ls.add("reg_status:" +obj.getString("reg_status"));

                ls.add("person_employed:" +obj.getString("person_employed"));
                ls.add("bsl_ent,intv_year:" +obj.getString("bsl_ent,intv_year"));
                ls.add("intv_name:" +obj.getString("intv_name"));
                ls.add("intv_qty:" +obj.getString("intv_qty"));
                ls.add("intv_unit:" +obj.getString("intv_unit"));

            }



        }


        showdataadapter adapter = new showdataadapter(ls, getContext());

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, ls);
        listView.setAdapter(adapter);
    }

}