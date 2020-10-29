package com.mj.agritech;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

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

public class Registrationbackground extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    boolean except =false;
    public String user_name,user_age,user_phone,user_trds;
    Registrationbackground(Context ctx)
    {
        context=ctx;

    }
    @Override
    protected String doInBackground(String... voids) {
        SharedPreferences pref = context.getSharedPreferences("MyPref", 0); // 0 - for priv
        String type= voids[0];
        String login_url= "https://theagriculture.tech/and_files/respondent.php";
        if(type.equals("register")){
            try {
                 user_name=voids[1];
                 user_age=voids[2];
                 user_phone=voids[3];
                 user_trds=voids[4];
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("user_age","UTF-8")+"="+URLEncoder.encode(user_age,"UTF-8") +"&"
                        +URLEncoder.encode("user_phone","UTF-8")+"="+URLEncoder.encode(user_phone,"UTF-8") +"&"
                        +URLEncoder.encode("user_trds","UTF-8")+"="+URLEncoder.encode(user_trds,"UTF-8") +"&"
                        +URLEncoder.encode("user_crp","UTF-8")+"="+URLEncoder.encode(pref.getString("key_user", "crpuser"),"UTF-8")
                        ;
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

        Toast.makeText(context,result,Toast.LENGTH_SHORT).show();

        String s1="false";
        if(s1.compareTo(result)==0){
            new StyleableToast
                    .Builder(context)
                    .text("Registration Failed !")
                    .textColor(Color.WHITE)
                    .backgroundColor(Color.RED)
                    .show();

        }
        else{

            Intent baselineactivity =new Intent(context,Baseline.class);
            baselineactivity.putExtra("id",result);
            baselineactivity.putExtra("name",user_name);
            progressBar2.setVisibility(View.INVISIBLE);
            context.startActivity(baselineactivity);
    }


    // alertDialog.setMessage(result);
        //alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
