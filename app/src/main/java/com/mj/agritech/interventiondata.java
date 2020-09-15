package com.mj.agritech;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
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

public class interventiondata extends AsyncTask<String,Void,String> {
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
    public interventiondata(Context ctx)
    {
        context=ctx;

    }
    @Override
    protected String doInBackground(String... voids) {
        type= voids[0];
        login_url= "http://192.168.43.151/interventiondetails.php";
        if(true){
            try {

                url=new URL(login_url);
                httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                outputStream=httpURLConnection.getOutputStream();
                bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));


                if(type.equals("crop_cultivation"))
                {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                                    + URLEncoder.encode("cat", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
                                    + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(voids[2], "UTF-8") + "&"
                                    + URLEncoder.encode("cultivated_area", "UTF-8") + "=" + URLEncoder.encode(voids[3], "UTF-8") + "&"
                                    + URLEncoder.encode("ttl_prod", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                                    + URLEncoder.encode("yield", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8") + "&"
                                    + URLEncoder.encode("market_rate", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8") + "&"
                                    + URLEncoder.encode("total_income", "UTF-8") + "=" + URLEncoder.encode(voids[7], "UTF-8")+ "&"
                                    + URLEncoder.encode("ttl_expenditure", "UTF-8") + "=" + URLEncoder.encode(voids[8], "UTF-8") + "&"
                                    + URLEncoder.encode("cultivation_cost", "UTF-8") + "=" + URLEncoder.encode(voids[9], "UTF-8") + "&"
                                    + URLEncoder.encode("net_income", "UTF-8") + "=" + URLEncoder.encode(voids[10], "UTF-8") + "&"
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[11], "UTF-8") + "&"
                                    + URLEncoder.encode("intv_name", "UTF-8") + "=" + URLEncoder.encode(voids[12], "UTF-8")+ "&"
                                    + URLEncoder.encode("intv_qty", "UTF-8") + "=" + URLEncoder.encode(voids[13], "UTF-8")+ "&"
                                    + URLEncoder.encode("intv_unit", "UTF-8") + "=" + URLEncoder.encode(voids[14], "UTF-8")+ "&"
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[15], "UTF-8");
}

                else if(type.equals("livestock"))
                {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                                    + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
                                    + URLEncoder.encode("number", "UTF-8") + "=" + URLEncoder.encode(voids[2], "UTF-8") + "&"
                                    + URLEncoder.encode("annual_income", "UTF-8") + "=" + URLEncoder.encode(voids[3], "UTF-8") + "&"
                                    + URLEncoder.encode("cost", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                                    + URLEncoder.encode("net_income", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8") + "&"
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8")+ "&"
                                    + URLEncoder.encode("intv_name", "UTF-8") + "=" + URLEncoder.encode(voids[7], "UTF-8")+ "&"
                                    + URLEncoder.encode("intv_qty", "UTF-8") + "=" + URLEncoder.encode(voids[8], "UTF-8")+ "&"
                                    + URLEncoder.encode("intv_unit", "UTF-8") + "=" + URLEncoder.encode(voids[9], "UTF-8")+ "&"
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[10], "UTF-8") ;
}

                else if(type.equals("allied"))
                {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                                    + URLEncoder.encode("bsl_allied", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
                                    + URLEncoder.encode("intv_name", "UTF-8") + "=" + URLEncoder.encode(voids[2], "UTF-8") + "&"
                                    + URLEncoder.encode("intv_qty", "UTF-8") + "=" + URLEncoder.encode(voids[3], "UTF-8") + "&"
                                    + URLEncoder.encode("intv_unit", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                                    + URLEncoder.encode("area", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8") + "&"
                                    + URLEncoder.encode("production", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8")
                                    + "&"
                                    + URLEncoder.encode("ann_income", "UTF-8") + "=" + URLEncoder.encode(voids[7], "UTF-8")
                                    + "&"
                                    + URLEncoder.encode("ann_exp", "UTF-8") + "=" + URLEncoder.encode(voids[8], "UTF-8")
                                    + "&"
                                    + URLEncoder.encode("net_annual", "UTF-8") + "=" + URLEncoder.encode(voids[9], "UTF-8")
                                    + "&"

                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[10], "UTF-8")
                                    + "&"
                                    + URLEncoder.encode("intv_name", "UTF-8") + "=" + URLEncoder.encode(voids[11], "UTF-8")+ "&"
                                    + URLEncoder.encode("intv_qty", "UTF-8") + "=" + URLEncoder.encode(voids[12], "UTF-8")+ "&"
                                    + URLEncoder.encode("intv_unit", "UTF-8") + "=" + URLEncoder.encode(voids[13], "UTF-8")+ "&"
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[14], "UTF-8");
}

                else if(type.equals("daily_wage"))
                {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                                    + URLEncoder.encode("members_count", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
                                    + URLEncoder.encode("days_involved", "UTF-8") + "=" + URLEncoder.encode(voids[2], "UTF-8") + "&"
                                    + URLEncoder.encode("place", "UTF-8") + "=" + URLEncoder.encode(voids[3], "UTF-8") + "&"

                                    + URLEncoder.encode("distance", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                                    + URLEncoder.encode("wage", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8")
                                    + "&"
                                    + URLEncoder.encode("annual_income", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8")
                                    + "&"
                                    + "&"
                                    + URLEncoder.encode("intv_year", "UTF-8") + "=" + URLEncoder.encode(voids[7], "UTF-8")
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[8], "UTF-8") ;
}
                else if(type.equals("skillmapping"))
                {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                                    + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
                                    + URLEncoder.encode("skill", "UTF-8") + "=" + URLEncoder.encode(voids[2], "UTF-8") + "&"
                                    + URLEncoder.encode("duration", "UTF-8") + "=" + URLEncoder.encode(voids[3], "UTF-8") + "&"
                                    + URLEncoder.encode("institute", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                                    + URLEncoder.encode("annual_income", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8") + "&"
                                    + "&"
                                    + URLEncoder.encode("intv_year", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8")
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[7], "UTF-8") ;
}
                else if(type.equals("enterprise_details"))
                {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                                    + URLEncoder.encode("enterprise_name", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
                                    + URLEncoder.encode("enterpreneur_name", "UTF-8") + "=" + URLEncoder.encode(voids[2], "UTF-8") + "&"
                                    + URLEncoder.encode("person_employed", "UTF-8") + "=" + URLEncoder.encode(voids[3], "UTF-8") + "&"
                                    + URLEncoder.encode("annual_exp", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                                    + URLEncoder.encode("annual_income", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8") + "&"
                                    + URLEncoder.encode("net_income", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8")
                                    + "&"
                                    + URLEncoder.encode("reg_status", "UTF-8") + "=" + URLEncoder.encode(voids[7], "UTF-8") + "&"
                                    + URLEncoder.encode("bsl_ent", "UTF-8") + "=" + URLEncoder.encode(voids[8], "UTF-8")
                                    + "&"
                                    + URLEncoder.encode("intv_year", "UTF-8") + "=" + URLEncoder.encode(voids[9], "UTF-8") + "&"
                                    + URLEncoder.encode("intv_name", "UTF-8") + "=" + URLEncoder.encode(voids[10], "UTF-8")+ "&"
                                    + URLEncoder.encode("intv_qty", "UTF-8") + "=" + URLEncoder.encode(voids[11], "UTF-8")+ "&"
                                    + URLEncoder.encode("intv_unit", "UTF-8") + "=" + URLEncoder.encode(voids[12], "UTF-8")+ "&"
                                    + URLEncoder.encode("intv_value", "UTF-8") + "=" + URLEncoder.encode(voids[13], "UTF-8")+ "&"
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[14], "UTF-8");

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

        Log.i("----------------",result);
        Toast.makeText(context,result,Toast.LENGTH_SHORT).show();

        String s1="true";
        if(s1.compareTo(result)==0){

            Toast.makeText(context,"Registration success",Toast.LENGTH_SHORT).show();
            //Toast.makeText(context,"Registration failed",Toast.LENGTH_SHORT).show();

        }
        else{
    Log.i("----------",result);

           // Toast.makeText(context,"Registration success",Toast.LENGTH_SHORT).show();

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
