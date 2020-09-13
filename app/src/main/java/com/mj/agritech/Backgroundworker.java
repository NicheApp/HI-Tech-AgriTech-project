package com.mj.agritech;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import static com.mj.agritech.MainActivity.progressBar;

public class Backgroundworker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    SharedPreferences sharedpreferences;
    public  static final String mypreference = "mypref";
    public  static final String usernamekey = "userKey";
    public  static final String userpasskey = "passKey";
    private  String user_name,user_pass;
    Backgroundworker(Context ctx)
    {
        context=ctx;

    }
    @Override
    protected String doInBackground(String... voids) {
        String type= voids[0];
        String login_url= "http://192.168.43.151/login.php";
        if(type.equals("login")){
            try {
                 user_name=voids[1];
                 user_pass=voids[2];
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(user_pass,"UTF-8");
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
        progressBar.setVisibility(View.INVISIBLE);
        String s1="true";
        if(s1.compareTo(result)==0){

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    SharedPreferences sharedPreferences = PreferenceManager
                            .getDefaultSharedPreferences(context);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(usernamekey, user_name);
                    editor.putString(userpasskey, user_pass);
                    editor.apply();

                }
            }, 600);
            context.startActivity(new Intent(context, ContainerActivity.class));
        }
        else
            Toast.makeText(context,"Incorrect username or password",Toast.LENGTH_SHORT).show();
      // alertDialog.setMessage(result);
       //alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
