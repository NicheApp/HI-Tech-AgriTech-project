package com.mj.agritech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mj.agritech.Dialoges.Alliedintervention;
import com.mj.agritech.Dialoges.Cropintervention;
import com.mj.agritech.Dialoges.DailyWageDialoge;
import com.mj.agritech.Dialoges.Enterpriseintervention;
import com.mj.agritech.Dialoges.SkillMappingdialog;
import com.mj.agritech.Dialoges.livestockintervention;
import com.mj.agritech.Dialoges.locationdialog;

public class Interventionclass extends AppCompatActivity {
    TextView Name, Id, baselineincome, currentyer;
    Button cropintervention, alliedothers, livestock, dailywage, skillmapping, enterprise;
    String FAMILY_ID;
    FragmentManager fm;
    FragmentTransaction ft;
    Fragment prev;
    DialogFragment dialogFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intervention);
      /*  cropintervention = findViewById(R.id.cropinterventiondetails);
        alliedothers = findViewById(R.id.alliedintervention);
        livestock = findViewById(R.id.livestockintervention);
        dailywage = findViewById(R.id.dailywage);
        skillmapping = findViewById(R.id.skillmappingintervention);
        enterprise = findViewById(R.id.Ententerpriseintervention);*/
        Name = findViewById(R.id.Name);
        Id = findViewById(R.id.id);
        baselineincome = findViewById(R.id.baselineincome);
        currentyer = findViewById(R.id.currentyear);
        Intent intent = getIntent();
        FAMILY_ID = intent.getStringExtra("id");
        Name.setText("NAME: " + intent.getStringExtra("name"));
        Id.setText("ID: " + FAMILY_ID);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

    }

    public void onClick(View v) {
        prev = fm.findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        switch (v.getId()) {

            case R.id.cropinterventiondetails:
                dialogFragment = new Cropintervention(FAMILY_ID);
                dialogFragment.show(ft, "dialog");

                break;
            case R.id.alliedintervention: /** Start a new Activity MyCards.java */


                dialogFragment = new Alliedintervention(FAMILY_ID);
                dialogFragment.show(ft, "dialog");
                break;
            case R.id.livestockintervention: /** Start a new Activity MyCards.java */

                dialogFragment = new livestockintervention(FAMILY_ID);
                dialogFragment.show(ft, "dialog");
                break;
            case R.id.dailywage: /** Start a new Activity MyCards.java */

                dialogFragment = new DailyWageDialoge(FAMILY_ID);
                dialogFragment.show(ft, "dialog");
                break;
            case R.id.skillmappingintervention: /** Start a new Activity MyCards.java */

                dialogFragment = new SkillMappingdialog(FAMILY_ID);
                dialogFragment.show(ft, "dialog");
                break;
            case R.id.Ententerpriseintervention: /** Start a new Activity MyCards.java */

                dialogFragment = new Enterpriseintervention(FAMILY_ID);
                dialogFragment.show(ft, "dialog");
                break;
        }
    }
}