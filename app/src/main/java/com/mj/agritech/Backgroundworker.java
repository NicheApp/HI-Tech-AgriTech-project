package com.mj.agritech;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.muddzdev.styleabletoast.StyleableToast;

import org.json.JSONArray;
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

import static com.mj.agritech.MainActivity.progressBar;

public class Backgroundworker extends AsyncTask<String,Void,String> {
    Context context;

    public static String user_crp,op_area;


    private  String user_name,user_pass;
    Backgroundworker(Context ctx)
    {
        context=ctx;

    }
    @Override
    protected String doInBackground(String... voids) {
        String type= voids[0];
        String login_url= "https://theagriculture.tech/and_files/login.php";
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

    }

    @Override
    protected void onPostExecute(String result) {
        progressBar.setVisibility(View.INVISIBLE);
        String s1="false";
        if(s1.compareTo(result)!=0){
            try{
                JSONArray jsonArray = new JSONArray(result);
                JSONObject obj = jsonArray.getJSONObject(0);
                user_crp = obj.getString("name");
                op_area= obj.getString("op_area");
                Log.i("crpuser",user_crp);
            }
            catch (Exception e){
                Log.i("json----------------",e.toString());
            }
            SharedPreferences pref = context.getSharedPreferences("MyPref", 0); // 0 - for private mode
             SharedPreferences.Editor editor = pref.edit();
                    editor.putString("key_user", user_name);
                    editor.putString("key_pass", user_pass);
                    editor.putString("key_name", user_crp);
                    editor.putString("key_oparea", op_area);
                      editor.commit();

            context.startActivity(new Intent(context, ContainerActivity.class));
        }
        else
        { new StyleableToast
                .Builder(context)
                .text("Incorrect username or password")
                .textColor(Color.WHITE)
                .backgroundColor(Color.RED)
                .show();}
      // alertDialog.setMessage(result);
       //alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
