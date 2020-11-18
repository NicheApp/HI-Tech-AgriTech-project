package com.mj.agritech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.mj.agritech.Baseline.baseline_intervention;
import static com.mj.agritech.SearchBackground.allfarmers;

public class Intervention extends AppCompatActivity {
    RecyclerView recyclerView;
    public List<String> interventionlist;
    interventionadapter interventionadapter;
    public String FAMILY_ID,FARMER_NAME;
    TextView Name, Id, baselineincome, currentyer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interventionfillshow);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        baseline_intervention=1;
        final Spinner spinner1 = findViewById(R.id.yearofintervention);

        final List<String> list = new ArrayList<String>();
        list.add("YEAR");
        list.add("2020-2021");
        list.add("2019-2020");
        list.add("2018-2019");
        list.add("2017-2018");
        list.add("2016-2017");



        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                list);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);

        spinner1.setSelection(1);
        recyclerView=findViewById(R.id.interventionrecyclerview);
        Name = findViewById(R.id.Name);
        Id = findViewById(R.id.id);
        baselineincome = findViewById(R.id.baselineincome);
        currentyer = findViewById(R.id.currentyear);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        interventionlist=new ArrayList<>();
        interventionlist.add("CROP CULTIVATION DETAILS"); interventionlist.add("AGRI ALLIED-LIVESTOCK");
        interventionlist.add("AGRI ALLIED-OTHERS");interventionlist.add("DAILY WAGE/LABOUR DETAILS");
        interventionlist.add("SKILL MAPPING"); interventionlist.add("ENTERPRISE BUISNESS DETAILS");
        Intent intent=getIntent();
        FAMILY_ID=intent.getStringExtra("id");
        FARMER_NAME=intent.getStringExtra("name");
        Name.setText("NAME: "+FARMER_NAME);
        Id.setText("ID: "+FAMILY_ID);
        FragmentManager fm = getSupportFragmentManager();
        interventionadapter=new interventionadapter(this,interventionlist,fm,FAMILY_ID,spinner1.getSelectedItem().toString());
        recyclerView.setAdapter(interventionadapter);
    }
}
