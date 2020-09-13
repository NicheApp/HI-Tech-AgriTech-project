package com.mj.agritech;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.mj.agritech.SearchBackground.allfarmers;


public class searchfragment extends Fragment {
    public RecyclerView recyclerView;
    String result = "";
    public searchadapter searchadapter;
    String farmerjson;
    public List<Farmer> farmers;
    androidx.appcompat.widget.SearchView searchView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchfragment,container,false);

        recyclerView=view.findViewById(R.id.recyclerview);
       
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        searchView=view.findViewById(R.id.searchbar);
        SearchBackground searchBackground=new SearchBackground(getContext());
        searchBackground.execute();
        allfarmers.add(new Farmer("mm", "123", "00"));
        searchadapter=new searchadapter(getActivity(),allfarmers);
        recyclerView.setAdapter(searchadapter);
        searchadapter.notifyDataSetChanged();
         searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               searchadapter.getFilter().filter(newText);
                return false;
            }

        });


        return  view;

    }





}
