package com.mj.agritech.Dialoges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

public class FamilymemberDialog extends DialogFragment {
EditText memname,memage,skills,mobile;
RadioButton gender,radiofemale;
Button submitquery;
    String gen,FAMILY_ID;
    int member_id;


    List<String> list1;

    FragmentManager fm;
    public FamilymemberDialog(String FAMILY_ID, List<String> list1, FragmentManager fm)
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
        View v = inflater.inflate(R.layout.dialoge_familymember, container, false);
        submitquery= v.findViewById(R.id.submitmember);
        memname=v.findViewById(R.id.memname);
        memage=v.findViewById(R.id.memage);
        skills=v.findViewById(R.id.memskill);
        mobile=v.findViewById(R.id.memnumber);
        gender=v.findViewById(R.id.radioMale);
        radiofemale=v.findViewById(R.id.radioFemale);

        final Spinner spinner1 = v.findViewById(R.id.memqualification);

        final List<String> list = new ArrayList<String>();
        list.add("Caste/जाति");
        list.add("SC");
        list.add("ST");
        list.add("General");
        list.add("OBC");
        list.add("Others");


        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);



        if(list1.size() > 0)
        {
            try {
                JSONObject obj = showjsonarray.getJSONObject(mainposition);
                memname.setText(obj.getString("name"));
                int spinnerPosition = myAdapter.getPosition(obj.getString("caste"));
                    spinner1.setSelection(spinnerPosition);
                    memage.setText(obj.getString("age"));

                if(obj.getString("sex").equals("Male"))
                    gender.setChecked(true);
                else
                    radiofemale.setChecked(true);

                skills.setText(obj.getString("skill"));
                mobile.setText(obj.getString("mobile"));
                member_id=obj.getInt("member_id");

            } catch (JSONException e) {
                e.printStackTrace();
            }



        }



        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(gender.isChecked())
                  gen ="Male";
              else
              {
                  gen="Female";
              }

                String type = "familymember";

                if(list1.size() > 0)
                {
                    UpdateBackground updateBackground = new UpdateBackground(getContext(),v);
                    updateBackground.execute(type, memname.getText().toString(),
                            memage.getText().toString(),gen, list.get(spinner1.getSelectedItemPosition()),
                            skills.getText().toString(),memage.getText().toString()
                            ,FAMILY_ID,member_id+"");
                    fm.popBackStackImmediate();
                    JSONArray emptyjson=new JSONArray();
                    showjsonarray=emptyjson;
                    list1.clear();
                }
                else {

                    Familytable familytable = new Familytable(getContext(), v);
                    familytable.execute(type, memname.getText().toString(),
                            memage.getText().toString(), gen, list.get(spinner1.getSelectedItemPosition()),
                            skills.getText().toString(), memage.getText().toString()
                            , FAMILY_ID);
                    fm.popBackStackImmediate();
                }

            }
        });

        return v;

    }





}
