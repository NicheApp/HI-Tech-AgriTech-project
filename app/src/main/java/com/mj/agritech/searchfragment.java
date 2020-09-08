package com.mj.agritech;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class searchfragment extends Fragment {
    public RecyclerView recyclerView;
    public List<Farmer> farmerList;
    public  searchadapter searchadapter;
    String farmerjson;
    androidx.appcompat.widget.SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchfragment,container,false);
        recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        farmerList=new ArrayList<>();
       /* farmerList.add(new Farmer("Mahesh mahato"," 5356356455","Jharkhand, Jamshedpur"));
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
        farmerList.add(new Farmer("Ashok Pathak","8521178674","Jharkhand,"));*/
        searchView=view.findViewById(R.id.searchbar);
        getJSON("http://192.168.43.151/baseline.php");
        Log.i("insidethis-------",farmerjson);

        try {
            JSONArray jsonArray = new JSONArray(farmerjson);
            for(int i=0;i<jsonArray.length();i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                Farmer fm = new Farmer(obj.getString("name"), obj.getString("family_id"), obj.getString("tsrds_op_area"));
                farmerList.add(fm);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

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
  void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {

                      Log.i("insidethis-------",s);
                farmerjson=s;

                //loadIntoListView(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return e.toString();
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }
}
