package com.mj.agritech;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Reportclass extends Fragment {

    RecyclerView recyclerView;
    public List<ReportModelclass> reportlist;
    ReportAdapter reportAdapter;

    public String FAMILY_ID,FARMER_NAME;
    public Reportclass(List<ReportModelclass> reportlist1)
    {
        reportlist=reportlist1;


    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.report, container, false);
        recyclerView=view.findViewById(R.id.recyclerViewreport);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        reportAdapter=new ReportAdapter(reportlist);
        recyclerView.setAdapter(reportAdapter);

        return  view;
    }





}

