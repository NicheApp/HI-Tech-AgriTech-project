package com.mj.agritech;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

import static com.mj.agritech.RegistrationActivity.progressBar2;

public class Familytable extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    boolean except =false;
    HttpURLConnection httpURLConnection;
    BufferedWriter bufferedWriter;
    OutputStream outputStream;
    InputStream inputStream;
    BufferedReader bufferedReader;
    String post_data;
    String result = "",type;
    String line = "";
    String login_url;
    URL url;
    public String user_name,user_age,user_phone,user_trds;
    public Familytable(Context ctx)
    {
        context=ctx;

    }
    @Override
    protected String doInBackground(String... voids) {
         type= voids[0];
        login_url= "http://192.168.43.151/family.php";
        if(type.equals("location") ||type.equals("info")||type.equals("familymember")){
            try {

                url=new URL(login_url);
                httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                outputStream=httpURLConnection.getOutputStream();
                bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                if(type.equals("location")) {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                             + URLEncoder.encode("TSRDS_op_area", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
                            + URLEncoder.encode("state", "UTF-8") + "=" + URLEncoder.encode(voids[2], "UTF-8") + "&"
                            + URLEncoder.encode("dist", "UTF-8") + "=" + URLEncoder.encode(voids[3], "UTF-8") + "&"
                            + URLEncoder.encode("block", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                            + URLEncoder.encode("gp", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8") + "&"
                            + URLEncoder.encode("village", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8")
                            + "&"
                            + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[7], "UTF-8");

                    }
                else if(type.equals("info"))
                {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                             + URLEncoder.encode("caste", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
                            + URLEncoder.encode("house_type", "UTF-8") + "=" + URLEncoder.encode(voids[2], "UTF-8") + "&"
                            + URLEncoder.encode("toilet", "UTF-8") + "=" + URLEncoder.encode(voids[3], "UTF-8") + "&"
                            + URLEncoder.encode("year_of_BLS", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                            + URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8") + "&"
                            + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8") ;


                }
                else if(type.equals("familymember"))
                {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                                    + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
                                    + URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(voids[2], "UTF-8") + "&"
                                    + URLEncoder.encode("sex", "UTF-8") + "=" + URLEncoder.encode(voids[3], "UTF-8") + "&"
                                    + URLEncoder.encode("ed_status", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                                    + URLEncoder.encode("skill", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8") + "&"
                                    + URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8")
                                    + "&"
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[7], "UTF-8") ;





                }


                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();


                    inputStream = httpURLConnection.getInputStream();
                     bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                     result = "";
                     line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;


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

        Toast.makeText(context,result,Toast.LENGTH_SHORT).show();

        String s1="false";
        if(s1.compareTo(result)==0){
            Toast.makeText(context,"Registration failed",Toast.LENGTH_SHORT).show();

        }
        else{


            Toast.makeText(context,"Registration success",Toast.LENGTH_SHORT).show();

            // alertDialog.setMessage(result);
            //alertDialog.show();
        }


        // alertDialog.setMessage(result);
        //alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
