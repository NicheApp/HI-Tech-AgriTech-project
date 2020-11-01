package com.mj.agritech;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class showdata extends DialogFragment {
    ListView listView;
    String s,type,Family_id;
    int position;
    Context ctx;
    FragmentManager fm;
    showdata(String s, String type, int position , Context ctx, FragmentManager fm,String Family_id)
    {

        this.s=s;
        this.type=type;
        this.position=position;
        this.ctx=ctx;
        this.fm=fm;
        this.Family_id=Family_id;

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
        List<String> ls2=new ArrayList<String>();
        if(type.equals("location")) {
         //   if(ls.size()>1)
          //  {ls.clear();}
for(int i=0;i<jsonArray.length();i++)
{
    if(ls2.size()>1)
    {ls2.clear();}
    if(ls.size()>1)
    {ls.clear();}
    JSONObject obj = jsonArray.getJSONObject(i);
    ls2.add("TSRDS Op Area: " +obj.getString("TSRDS_op_area")+"\n\nState: " +obj.getString("state")+"\n\nYear of BLS: " +obj.getString("year_of_BLS")+
            "\n\nGP:" +obj.getString("gp") +"\n\nBlock:" +obj.getString("block")+"\n\nDist: " +obj.getString("dist")+
            "\n\nVillage: " +obj.getString("village"));
    ls.add(obj.getString("TSRDS_op_area"));
    ls.add(obj.getString("year_of_BLS"));
    ls.add(obj.getString("gp"));
    ls.add(obj.getString("block"));
    ls.add(obj.getString("dist"));
    ls.add(obj.getString("village"));

}
        }

        else if(type.equals("info"))
        {  if(ls2.size()>1)
        {ls2.clear();}
            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj = jsonArray.getJSONObject(i);

                ls2.add("Date: "+obj.getString("date")+"\n\nHouse Type: "+obj.getString("house_type")+
                        "\n\nToilet: "+obj.getString("toilet")+"\n\nCaste: "+obj.getString("caste")+"\n\nYear of BLS: " +obj.getString("year_of_BLS"));
               ls.add(obj.getString("date"));
               ls.add(obj.getString("house_type"));
               ls.add(obj.getString("toilet"));
               ls.add(obj.getString("caste"));
               ls.add(obj.getString("year_of_BLS"));
 }



        }
        else if(type.equals("familymember"))
        {
            if(ls2.size()>1)
            {ls2.clear();}
            if(ls.size()>1)
            {ls.clear();}

            for(int i=0;i<jsonArray.length();i++)
            {  JSONObject obj = jsonArray.getJSONObject(i);

                ls2.add("Name:" +obj.getString("name")+"\n\nCaste:" +obj.getString("caste")+
                        "\n\nAge:" +obj.getString("age") + "\n\nSex:" +obj.getString("sex") +
                        "\n\nEd status:" +obj.getString("ed_status")+"\n\nSkill:" +obj.getString("skill")+
                                "\n\nMobile:" +obj.getString("mobile")+"\n\nEdu other:" +obj.getString("edu_other"));
                ls.add(obj.getString("name"));
                ls.add(obj.getString("caste"));
                ls.add(obj.getString("age"));
                ls.add(obj.getString("sex"));
                ls.add(obj.getString("ed_status"));
                ls.add(obj.getString("skill"));
                ls.add(obj.getString("mobile"));
                ls.add(obj.getString("edu_other"));
            }





        }

        else if(type.equals("incomedetails"))
        {
            if(ls2.size()>1)
            {ls2.clear();}
            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            {  JSONObject obj = jsonArray.getJSONObject(i);


            ls2.add("Occupation: " +obj.getString("occupation")+"\n\nDays: " +obj.getString("days")+
                    "\n\nMembers Involved: " +obj.getString("members_involved") +"\n\nAnnual Income: " +obj.getString("annual_income")
                       + "\n\nPrimary secondary:" +obj.getString("primary_secondary"));
                ls.add(obj.getString("occupation"));
                ls.add(obj.getString("days"));
                ls.add(obj.getString("members_involved"));
                ls.add(obj.getString("annual_income"));
                ls.add(obj.getString("primary_secondary"));


            }




        }

        else if(type.equals("land_holding"))
        {
            if(ls2.size()>1)
            {ls2.clear();}
            if(ls.size()>1)
            {ls.clear();}

            for(int i=0;i<jsonArray.length();i++)
            {   JSONObject obj = jsonArray.getJSONObject(i);

            ls2.add("Land Owned:" +obj.getString("land_owned")+"\n\nFamily id:" +obj.getString("family_id")
            +"\n\nIrrigated land:" +obj.getString("irrigated_land")+"\n\nLand_category:" +obj.getString("land_category")+
                    "\nIrrigated %:" +obj.getString("irrigated_percentage")+ "\n\nOwnership Type: " +obj.getString("ownership_type")
            +"\n\nIrrigation source:" +obj.getString("irrigation_source"));

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
            if(ls2.size()>1)
            {ls2.clear();}
            if(ls.size()>1)
            {ls.clear();}

            for(int i=0;i<jsonArray.length();i++)
            {   JSONObject obj = jsonArray.getJSONObject(i);

                ls2.add("Category:" +obj.getString("cat")+"\n\nCrop Name:" +obj.getString("name")
                        +"\n\nCultivated_area:" +obj.getString("cultivated_area")+
                        "\n\nYield:" +obj.getString("yield")+"\n\nTotal Production:" +obj.getString("ttl_prod")+
                        "\n\nMarket Rate:" +obj.getString("market_rate")+ "\n\nTotal income:" +obj.getString("total_income")
                +"\n\nCultivation cost:" +obj.getString("cultivation_cost")+"\n\nNet_income:" +obj.getString("net_income")
                +"\n\nBsl_crop:" +obj.getString("bsl_crop")+
                        "\n\nTotal expenditure:" +obj.getString("ttl_expenditure") );

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
            if(ls2.size()>1)
            {ls2.clear();}
            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            {   JSONObject obj = jsonArray.getJSONObject(i);

            ls2.add("Number:" +obj.getString("number")+"\n\nName:" +obj.getString("name")+
                    "\n\nCost:" +obj.getString("cost")+"\n\nAnnual_income:" +obj.getString("annual_income")+
                    "\n\nNet_income:" +obj.getString("net_income") );

                ls.add("number:" +obj.getString("number"));
                ls.add("name:" +obj.getString("name"));
                ls.add("cost:" +obj.getString("cost"));
                ls.add("annual_income:" +obj.getString("annual_income"));
                ls.add("net_income:" +obj.getString("net_income"));
            }




        }

        else if(type.equals("allied"))
        {
            if(ls2.size()>1)
            {ls2.clear();}
            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            {   JSONObject obj = jsonArray.getJSONObject(i);

            ls2.add("Type: " +obj.getString("type")+"\n\nArea: " +obj.getString("area")+"\n\nProduction: " +obj.getString("production")+
                    "\n\nAnnual income:v" +obj.getString("ann_income")+"\n\nAnnual Exp: " +obj.getString("ann_exp")+
                    "\n\nNet nnual: " +obj.getString("net_annual")+"\n\nIntervention year: " +obj.getString("intv_name")+
                    "\n\nIntervention Quantity: " +obj.getString("intv_qty")+"\n\nIntervention Unit: " +obj.getString("intv_unit")+ "Bsl allied: " +
                    obj.getString("bsl_allied"));

                ls.add("area:" +obj.getString("area"));
                ls.add("production:" +obj.getString("production"));
                ls.add("ann_income:" +obj.getString("ann_income"));
                ls.add("ann_exp:" +obj.getString("ann_exp"));
                ls.add("net_annual:" +obj.getString("net_annual"));
                ls.add("intv_name:" +obj.getString("intv_name"));
                ls.add("intv_qty:" +obj.getString("intv_qty"));
                ls.add("intv_unit:" +obj.getString("intv_unit"));
                ls.add("bsl_allied:" +obj.getString("bsl_allied"));
            }

        }

        else if(type.equals("daily_wage"))
        {
            if(ls2.size()>1)
            {ls2.clear();}
            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            {  JSONObject obj = jsonArray.getJSONObject(i);

            ls2.add("Members count: " +obj.getString("members_count")+"\n\nDays Involved: " +obj.getString("days_involved")+
                    "\n\nPlace: " +obj.getString("place")+"\n\nDistance: " +obj.getString("distance")+
                    "\n\nIntv year: " +obj.getString("intv_year")+ "\n\nAnnual income: " +obj.getString("annual_income")+
                    "\n\nWage: " +obj.getString("wage"));

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
            if(ls2.size()>1)
            {ls2.clear();}
            if(ls.size()>1)
            {ls.clear();}



            for(int i=0;i<jsonArray.length();i++)
            {  JSONObject obj = jsonArray.getJSONObject(i);

                ls2.add("Name:b" +obj.getString("name")+"\n\nSkill: " +obj.getString("skill")+
                        "\n\nAnnual Income:" +obj.getString("annual_income")+ "\n\nInstitute: " +obj.getString("institute")+
                        "\n\nDuration: " +obj.getString("duration"));

                ls.add("name:" +obj.getString("name"));
                ls.add("skill:" +obj.getString("skill"));
                ls.add("annual_income:" +obj.getString("annual_income"));
                ls.add("institute:" +obj.getString("institute"));
                ls.add("duration:" +obj.getString("duration"));

            }

        }
        else if(type.equals("enterprise_details"))
        {
            if(ls2.size()>1)
            {ls2.clear();}

            if(ls.size()>1)
            {ls.clear();}
            for(int i=0;i<jsonArray.length();i++)
            { JSONObject obj = jsonArray.getJSONObject(i);

            ls2.add("Enterprise Name: " +obj.getString("enterprise_name")+
                    "\n\nEnterpreneur Name: " +obj.getString("enterpreneur_name")+"\n\nAnnual exp: " +obj.getString("annual_exp")
            +"\n\nAnnual Income: " +obj.getString("annual_income")+"\n\nNet Income: " +obj.getString("net_income")+
                    "\n\nReg status: " +obj.getString("reg_status")+"\n\nPerson Employed: " +obj.getString("person_employed")+
                    "\n\nIntv year: " +obj.getString("intv_year")+"\n\nIntv qty: " +obj.getString("intv_qty")+
                    "\n\nIntv_unit: " +obj.getString("intv_unit") );

                ls.add("enterprise_name:" +obj.getString("enterprise_name"));
                ls.add("enterpreneur_name:" +obj.getString("enterpreneur_name"));
                ls.add("annual_exp:" +obj.getString("annual_exp"));
                ls.add("annual_income:" +obj.getString("annual_income"));
                ls.add("net_income:" +obj.getString("net_income"));
                ls.add("reg_status:" +obj.getString("reg_status"));

                ls.add("person_employed:" +obj.getString("person_employed"));
                ls.add("intv_year:" +obj.getString("intv_year"));
                ls.add("intv_name:" +obj.getString("intv_name"));
                ls.add("intv_qty:" +obj.getString("intv_qty"));
                ls.add("intv_unit:" +obj.getString("intv_unit"));

            }



        }


        showdataadapter adapter = new showdataadapter(ls2, ctx,position,fm,Family_id,ls,jsonArray);

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, ls);
        listView.setAdapter(adapter);
    }

}