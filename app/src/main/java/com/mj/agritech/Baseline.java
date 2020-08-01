package com.mj.agritech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Baseline extends AppCompatActivity {
RecyclerView recyclerView;
public List<String> baselinelist;
baselineadapter baselineadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_baseline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        recyclerView=findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        baselinelist=new ArrayList<>();
        baselinelist.add("LOCATION"); baselinelist.add("GENERAL INFO"); baselinelist.add("ADD FAMILY MEMBERS");
        baselinelist.add("INCOME DETAILS"); baselinelist.add("LAND HOLDING");
        baselinelist.add("CROP CULTIVATION DETAILS"); baselinelist.add("AGRI ALLIED-LIVESTOCK");
        baselinelist.add("AGRI ALLIED-OTHERS"); baselinelist.add("DAILY WAGE/LABOUR DETAILS");
        baselinelist.add("SKILL MAPPING"); baselinelist.add("ENTERPRISE BUISNESS DETAILS");
        FragmentManager fm = getSupportFragmentManager();
        baselineadapter=new baselineadapter(this,baselinelist,fm);

        recyclerView.setAdapter(baselineadapter);




    }
}
