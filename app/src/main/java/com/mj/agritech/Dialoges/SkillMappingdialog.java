package com.mj.agritech.Dialoges;

import android.os.Bundle;
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

public class SkillMappingdialog extends DialogFragment {
    EditText nameoftheperson,professional,training,institute,annualincome;
    String FAMILY_ID,year;
    Button submitquery;
    List<String> list1;
    int entry_id;
    FragmentManager fm;
    public SkillMappingdialog(String FAMILY_ID, String year, List<String> list1, FragmentManager fm)
    {
        this.FAMILY_ID=FAMILY_ID;
        this.year=year;
        this.list1=list1;
        this.fm=fm;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_skillmapping, container, false);
        nameoftheperson=v.findViewById(R.id.nameperson);
       professional=v.findViewById(R.id.typeofvocational);
        training=v.findViewById(R.id.durationoftraining);
        institute=v.findViewById(R.id.institution);
        annualincome=v.findViewById(R.id.annincomeskillmapping);
        nameoftheperson=v.findViewById(R.id.nameperson);
        submitquery=v.findViewById(R.id.submitlocation);

        if(list1.size()>0)
        {
          try {
                JSONObject obj = showjsonarray.getJSONObject(mainposition);
                nameoftheperson.setText(obj.getString("name"));
                professional.setText(obj.getString("skill"));
                training.setText(obj.getString("duration"));
                institute.setText(obj.getString("institute"));
                annualincome.setText(obj.getString("annual_income"));
              entry_id=obj.getInt("entry_id");


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String type = "skillmapping";
                if(list1.size()>0)
                {
                    UpdateBackground updateBackground = new UpdateBackground(getContext(),v);
                    updateBackground.execute(type,nameoftheperson.getText().toString(),
                            professional.getText().toString(),training.getText().toString() ,
                            institute.getText().toString(),annualincome.getText().toString(),
                            FAMILY_ID,entry_id+"");
                    fm.popBackStackImmediate();
                    JSONArray emptyjson=new JSONArray();
                    showjsonarray=emptyjson;
                    list1.clear();
                }else {
                    Familytable familytable = new Familytable(getContext(), v);
                    familytable.execute(type, nameoftheperson.getText().toString(),
                            professional.getText().toString(), training.getText().toString(),
                            institute.getText().toString(), annualincome.getText().toString(),
                            FAMILY_ID);
                    fm.popBackStackImmediate();
                }

            }
        });



        return v;

}

}
