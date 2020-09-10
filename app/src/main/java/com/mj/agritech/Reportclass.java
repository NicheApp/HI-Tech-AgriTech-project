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
    public List<ReportModelclass> reportModelclassList;
    ReportAdapter reportAdapter;

    public String FAMILY_ID,FARMER_NAME;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.report, container, false);
        recyclerView=view.findViewById(R.id.recyclerViewreport);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        reportModelclassList=new ArrayList<>();
        reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));
        reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));
        reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));
        reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));
        reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));
        reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));
        reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));
        reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));
        reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));
        reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));
        reportModelclassList.add(new ReportModelclass(1,"Manohar Mahato","General","Mundani","Paddy, Paddy, Fishery, Duck, Duck, ","95400 ",
                "136000 "," 42.56% "));
        reportAdapter=new ReportAdapter(reportModelclassList);
        recyclerView.setAdapter(reportAdapter);

        return  view;
    }





}

