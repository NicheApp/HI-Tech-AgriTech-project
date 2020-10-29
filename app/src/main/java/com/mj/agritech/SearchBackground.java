package com.mj.agritech;


import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.fragment.app.FragmentManager;

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


public class SearchBackground extends AsyncTask<String,String,String> {
    Context context;
    AlertDialog alertDialog;
    boolean except =false;
    public String type,family_id;
    public  FragmentManager fm;
    public static List<Farmer> allfarmers=new ArrayList<>();
    int i=0;

    SearchBackground(Context ctx,FragmentManager fm)
    {
        context=ctx;
        this.fm=fm;


    }
    @Override
    protected String doInBackground(String... voids) {

        String login_url= "https://theagriculture.tech/and_files/baseline.php";
        if(true){
            try {


                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";

                while((line=bufferedReader.readLine())!=null)
                {
                    Log.i("--------",line);
                    result+=line;


                }

                bufferedReader.close();
                inputStream.close();

                return  result;
            }catch (Exception e)
            {

                return e.toString();
            }

        }
        return null;
    }
    @Override
    protected void onPreExecute() {

        fm.beginTransaction().replace(R.id.fragment_container,new searchfragment(allfarmers)).commit();

    }

    @Override
    protected void onPostExecute(String result) {

       try {
            JSONArray jsonArray = new JSONArray(result);

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj = jsonArray.getJSONObject(i);
                allfarmers.add(new Farmer(obj.getString("name"), obj.getString("family_id")+"", obj.getString("tsrds_op_area"),
                        obj.getString("res_id")));
            }


            fm.beginTransaction().replace(R.id.fragment_container,new searchfragment(allfarmers)).commit();

        } catch (JSONException e) {

            Log.i("e===",e.toString());
        }

    }

    @Override
    protected void onProgressUpdate(String... values)
    {  super.onProgressUpdate(values);


    }


}

