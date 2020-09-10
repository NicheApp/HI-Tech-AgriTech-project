package com.mj.agritech;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;




public class SearchBackground extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    boolean except =false;
    public String type,family_id;
    public  FragmentManager fm;
    public List<Farmer> allfarmers=new ArrayList<>();

    SearchBackground(Context ctx,FragmentManager fm)
    {
        context=ctx;
        this.fm=fm;


    }
    @Override
    protected String doInBackground(String... voids) {

        String login_url= "http://192.168.43.151/baseline.php";
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


    }

    @Override
    protected void onPostExecute(String result) {

        try {
            JSONArray jsonArray = new JSONArray(result);

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj = jsonArray.getJSONObject(i);
                allfarmers.add(new Farmer(obj.getString("name"), obj.getString("family_id")+"", obj.getString("tsrds_op_area")));
            }

            fm.beginTransaction().replace(R.id.fragment_container,new searchfragment(allfarmers)).commit();

        } catch (JSONException e) {

            Log.i("e===",e.toString());
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}

