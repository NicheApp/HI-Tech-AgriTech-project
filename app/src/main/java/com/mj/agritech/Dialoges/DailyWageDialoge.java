package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.mj.agritech.Familytable;
import com.mj.agritech.R;
import com.mj.agritech.UpdateBackground;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import static com.mj.agritech.showdataadapter.mainposition;
import static com.mj.agritech.showdataadapter.showjsonarray;

public class DailyWageDialoge extends DialogFragment {

    String FAMILY_ID,year;
    Button submitquery;
    List<String> list1;
    int entry_id;
    FragmentManager fm;
    public DailyWageDialoge(String FAMILY_ID, String year, List<String> list1, FragmentManager fm)
    {
        this.FAMILY_ID=FAMILY_ID;
        this.year=year;
        this.list1=list1;
        this.fm=fm;

    }

    EditText familymembers,days,cultivatedarea,placeofwork,distance,wage,annualincome;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_dailywage, container, false);

        familymembers=v.findViewById(R.id.familymem);
        days=v.findViewById(R.id.daysenvolved);
        cultivatedarea=v.findViewById(R.id.cultivated_area);
        placeofwork=v.findViewById(R.id.placework);
        distance=v.findViewById(R.id.distance);
        wage=v.findViewById(R.id.wage);
        annualincome=v.findViewById(R.id.annincome);
        submitquery=v.findViewById(R.id.submitlocation);
        if(list1.size()>0)
        {


            try {
                JSONObject obj = showjsonarray.getJSONObject(mainposition);
                familymembers.setText(obj.getString("members_count"));
                days.setText(obj.getString("days_involved"));
                placeofwork.setText(obj.getString("place"));
                distance.setText(obj.getString("distance"));
                wage.setText(obj.getString("wage"));
                cultivatedarea.setText(obj.getString("area"));
                annualincome.setText(obj.getString("annual_income"));
                entry_id=obj.getInt("entry_id");

            } catch (JSONException e) {
                e.printStackTrace();
            }



        }

        wage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {

                   annualincome.setText((Double.parseDouble(familymembers.getText().toString())*Double.parseDouble(days.getText().toString())*Double.parseDouble(wage.getText().toString())) + "");
                }
                catch(Exception e)
                {

                   annualincome.setText("");
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "daily_wage";
                if(list1.size()>0)
                {
                    UpdateBackground updateBackground = new UpdateBackground(getContext(), v);
                    updateBackground.execute(type, familymembers.getText().toString(),
                            days.getText().toString(),
                            placeofwork.getText().toString(), distance.getText().toString(),
                            wage.getText().toString(), annualincome.getText().toString(), FAMILY_ID,entry_id+"");
                    fm.popBackStackImmediate();
                    JSONArray emptyjson=new JSONArray();
                    showjsonarray=emptyjson;
                    list1.clear();
                }
                else {



                    Familytable familytable = new Familytable(getContext(), v);
                    familytable.execute(type, familymembers.getText().toString(),
                            days.getText().toString(),
                            placeofwork.getText().toString(), distance.getText().toString(),
                            wage.getText().toString(), annualincome.getText().toString(), FAMILY_ID);
                    fm.popBackStackImmediate();

                }

            }
        });


        // Do all the stuff to initialize your custom view

        return v;

    }



}
