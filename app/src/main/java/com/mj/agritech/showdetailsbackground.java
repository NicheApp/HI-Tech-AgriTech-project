package com.mj.agritech;


import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class showdetailsbackground extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    int position;
    boolean except =false;
    public String type,family_id;
    public  FragmentManager fm;
    showdetailsbackground(Context ctx,FragmentManager fm,int position)
    {
        context=ctx;
        this.fm = fm;
        this.position=position;

    }
    @Override
    protected String doInBackground(String... voids) {

        String login_url= "https://theagriculture.tech/and_files/retrievedata.php";
        //String login_url= "http://192.168.43.151/retrievedata.php";
        if(true){
            try {


                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                type=voids[0];
                family_id=voids[1];
                String post_data= URLEncoder.encode("type","UTF-8")+"="+URLEncoder.encode(type,"UTF-8")+"&"
                        +URLEncoder.encode("family_id","UTF-8")+"="+URLEncoder.encode(family_id,"UTF-8") ;

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();


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
                except=true;
                return e.toString();
            }

        }
        return null;
    }
    @Override
    protected void onPreExecute() {
        // alertDialog=new AlertDialog.Builder(context).create();
        //alertDialog.setTitle("Login Status");

    }

    @Override
    protected void onPostExecute(String result) {


        Log.i("result: -------",result);
        FragmentTransaction ft = fm.beginTransaction();
        Fragment prev = fm.findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment dialogFragment = new showdata(result,type,position,context,fm,family_id);
        dialogFragment.show(ft, "dialog");


        // alertDialog.setMessage(result);
        //alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}

