package com.mj.agritech;

import android.app.AlertDialog;
import android.content.Context;
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
    View view;
    public String user_name,user_age,user_phone,user_trds;
    public Familytable(Context ctx,View v)
    {
        context=ctx;
        view=v;

    }
    @Override
    protected String doInBackground(String... voids) {
         type= voids[0];
        login_url= "https://theagriculture.tech/and_files/family.php";
        if(true){
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
                                    + URLEncoder.encode("caste", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                                    + URLEncoder.encode("skill", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8") + "&"
                                    + URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8")
                                    + "&"
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[7], "UTF-8") ;





                }

                                        else if(type.equals("incomedetails"))
                {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                                    + URLEncoder.encode("occupation", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
                                    + URLEncoder.encode("primary_secondary", "UTF-8") + "=" + URLEncoder.encode(voids[2], "UTF-8") + "&"
                                    + URLEncoder.encode("days", "UTF-8") + "=" + URLEncoder.encode(voids[3], "UTF-8") + "&"
                                    + URLEncoder.encode("members_involved", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                                    + URLEncoder.encode("annual_income", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8") + "&"
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8") ;



                }

                else if(type.equals("land_holding"))
                {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                                    + URLEncoder.encode("ownership_type", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
                                    + URLEncoder.encode("land_category", "UTF-8") + "=" + URLEncoder.encode(voids[2], "UTF-8") + "&"
                                    + URLEncoder.encode("land_owned", "UTF-8") + "=" + URLEncoder.encode(voids[3], "UTF-8") + "&"
                                    + URLEncoder.encode("irrigated_land", "UTF-8") + "=" + URLEncoder.encode(voids[4], "UTF-8") + "&"
                                    + URLEncoder.encode("irrigation_source", "UTF-8") + "=" + URLEncoder.encode(voids[5], "UTF-8") + "&"
                                    + URLEncoder.encode("irrigated_percentage", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8")
                                    + "&"
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[7], "UTF-8") ;





                }

                else if(type.equals("crop_cultivation"))
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
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[11], "UTF-8") ;






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
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8") ;





                }

                else if(type.equals("allied"))
                {
                    post_data =
                            URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(voids[0], "UTF-8") + "&"
                                    + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(voids[1], "UTF-8") + "&"
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

                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[10], "UTF-8") ;





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
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[7], "UTF-8") ;




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
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[6], "UTF-8") ;






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
                                    + URLEncoder.encode("family_id", "UTF-8") + "=" + URLEncoder.encode(voids[9], "UTF-8") ;

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
            new StyleableToast
                    .Builder(context)
                    .text("Something Went Wrong!")
                    .textColor(Color.WHITE)
                    .backgroundColor(Color.RED)
                    .show();

        }
        else{


            new StyleableToast
                    .Builder(context)
                    .text("Data Added!")
                    .textColor(Color.WHITE)
                    .backgroundColor(Color.BLUE).iconStart(getIcon())
                    .show();


        }


        // alertDialog.setMessage(result);
        //alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    public int getIcon() {
        if (android.os.Build.VERSION.SDK_INT >= 27) {
            return R.drawable.ic_baseline_done_24;
        } else {
            return R.drawable.ic_baseline_done_24;
        }
    }
}
