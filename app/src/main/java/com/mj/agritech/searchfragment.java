package com.mj.agritech;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class searchfragment extends Fragment {
    public RecyclerView recyclerView;
    public List<Farmer> farmerList;
    public  searchadapter searchadapter;
    androidx.appcompat.widget.SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchfragment,container,false);
        recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        farmerList=new ArrayList<>();
        farmerList.add(new Farmer("Mahesh mahato"," 5356356455","Jharkhand, Jamshedpur"));
        farmerList.add(new Farmer("Manohar Mahato","8917507996","Jharkhand, Jamshedpur"));
        farmerList.add(new Farmer("Dubai Tudu"," 7764806833","Jharkhand, Jamshedpur"));
        farmerList.add(new Farmer("Ashok Pathak","8521178674","Jharkhand, Jamshedpur"));
        farmerList.add(new Farmer("Mahesh mahato"," 5356356455","Jharkhand, Jamshedpur"));
        farmerList.add(new Farmer("Manohar Mahato","8917507996","Jharkhand, Jamshedpur"));
        farmerList.add(new Farmer("Dubai Tudu"," 7764806833","Jharkhand, Jamshedpur"));
        farmerList.add(new Farmer("Ashok Pathak","8521178674","Jharkhand, Jamshedpur"));
        farmerList.add(new Farmer("Mahesh mahato"," 5356356455","Jharkhand,"));
        farmerList.add(new Farmer("Manohar Mahato","8917507996","Jharkhand, "));
        farmerList.add(new Farmer("Dubai Tudu"," 7764806833","Jharkhand,"));
        farmerList.add(new Farmer("Ashok Pathak","8521178674","Jharkhand,"));
        searchView=view.findViewById(R.id.searchbar);

        searchadapter=new searchadapter(getActivity(),farmerList);

        recyclerView.setAdapter(searchadapter);








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
