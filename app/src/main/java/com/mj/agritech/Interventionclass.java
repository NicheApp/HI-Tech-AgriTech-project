package com.mj.agritech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
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

import java.util.ArrayList;
import java.util.List;

public class Interventionclass extends AppCompatActivity {
    TextView Name, Id, baselineincome, currentyer;
    Button cropintervention, alliedothers, livestock, dailywage, skillmapping, enterprise;
    String FAMILY_ID;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intervention);
        cropintervention = findViewById(R.id.cropinterventiondetails);
        alliedothers = findViewById(R.id.alliedintervention);
        livestock = findViewById(R.id.livestockintervention);
        dailywage = findViewById(R.id.dailywage);
        skillmapping = findViewById(R.id.skillmappingintervention);
        enterprise = findViewById(R.id.Ententerpriseintervention);
        Name = findViewById(R.id.Name);
        Id = findViewById(R.id.id);
        baselineincome = findViewById(R.id.baselineincome);
        currentyer = findViewById(R.id.currentyear);
        Intent intent = getIntent();
        FAMILY_ID = intent.getStringExtra("id");
        Name.setText("NAME: " + intent.getStringExtra("name"));
        Id.setText("ID: " + FAMILY_ID);
        final Spinner spinner1 = findViewById(R.id.yearofintervention);

        final List<String> list = new ArrayList<String>();
        list.add("YEAR");
        list.add("2019-2020");
        list.add("2018-2019");
        list.add("2017-2018");
        list.add("2016-2017");



        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                list);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);



        cropintervention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment prev = fm.findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

              DialogFragment  dialogFragment = new Cropintervention(FAMILY_ID);
                dialogFragment.show(ft, "dialog");


            }
        });

        alliedothers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment prev = fm.findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                DialogFragment  dialogFragment = new Alliedintervention(FAMILY_ID);
                dialogFragment.show(ft, "dialog");

            }
        });
        livestock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment prev = fm.findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                DialogFragment  dialogFragment = new livestockintervention(FAMILY_ID);
                dialogFragment.show(ft, "dialog");

            }
        });

        dailywage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment prev = fm.findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                DialogFragment  dialogFragment = new DailyWageDialoge(FAMILY_ID);
                dialogFragment.show(ft, "dialog");
            }
        });

        skillmapping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment prev = fm.findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                DialogFragment  dialogFragment = new SkillMappingdialog(FAMILY_ID);
                dialogFragment.show(ft, "dialog");
            }
        });

        enterprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment prev = fm.findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                DialogFragment  dialogFragment = new Enterpriseintervention(FAMILY_ID);
                dialogFragment.show(ft, "dialog");
            }
        });




    }


}