package com.mj.agritech.Dialoges;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.mj.agritech.Familytable;
import com.mj.agritech.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CropCultivationDialog extends DialogFragment {
    String FAMILY_ID;
    Button submitquery;
    List<String> list2;
    public CropCultivationDialog(String FAMILY_ID)
    {
        this.FAMILY_ID=FAMILY_ID;

    }


    EditText Totalproduction,Cultivatedarea,Yield,Marketrate,Totalincome,Expenditure,CostofCultivation,Netincome;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_cropcultivationdetails, container, false);
        Cultivatedarea=v.findViewById(R.id.cultivated_area);
        Totalproduction=v.findViewById(R.id.total_production);
       submitquery=v.findViewById(R.id.submitlocation);
        Yield=v.findViewById(R.id.yield);
        Marketrate=v.findViewById(R.id.market_Rate);
        Totalincome=v.findViewById(R.id.totalincome);
        Expenditure=v.findViewById(R.id.expenditure);
        CostofCultivation=v.findViewById(R.id.costcultivation);
        Netincome=v.findViewById(R.id.netincome);

        final Spinner spinner1 = v.findViewById(R.id.cropcategory);
        final Spinner spinner2 =  v.findViewById(R.id.cropsubcategory);
          final List<String> list = new ArrayList<String>();
          list.add("Crop Category");
          list.add("Kharif");
          list.add("Rabi");
          list.add("Zaid");
        getJSON("https://theagriculture.tech/and_files/crop_cultivation.php");
       list2 = new ArrayList<String>();
       list2.add("Choose Crop");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                list2);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(myAdapter2);

       Totalproduction.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {

                    Yield.setText((Double.parseDouble(Totalproduction.getText().toString()) / Double.parseDouble(Cultivatedarea.getText().toString())) + "");
                }
                catch(Exception e)
                {

                    Yield.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        Marketrate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {

                    Totalincome.setText((Double.parseDouble(Marketrate.getText().toString()) * Double.parseDouble(Totalproduction.getText().toString())) + "");
                }
                catch(Exception e)
                {

                    Totalincome.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        Expenditure.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {

                   CostofCultivation.setText((Double.parseDouble(Expenditure.getText().toString()) / Double.parseDouble(Cultivatedarea.getText().toString())) + "");
                }
                catch(Exception e)
                {

                   CostofCultivation.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        CostofCultivation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {

                    Netincome.setText((Double.parseDouble(Totalincome.getText().toString()) - Double.parseDouble(Expenditure.getText().toString())) + "");
                }
                catch(Exception e)
                {

                    Netincome.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String a=  list.get( spinner1.getSelectedItemPosition());
               String b= list2.get( spinner2.getSelectedItemPosition());

                String type = "crop_cultivation";
               Familytable familytable= new Familytable(getContext(),v);
                familytable .execute(type, a, b,Cultivatedarea.getText().toString(),
                        Totalproduction.getText().toString(),Yield.getText().toString() ,
                        Marketrate.getText().toString(),Totalincome.getText().toString(),
                        Expenditure.getText().toString(),CostofCultivation.getText().toString(),
                        Netincome.getText().toString(),
                         FAMILY_ID);

            }
        });

        return v;

    }

    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    public void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            list2.add(obj.getString("crop_name"));
        }

    }



}
