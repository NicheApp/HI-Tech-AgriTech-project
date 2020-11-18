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
import androidx.fragment.app.FragmentManager;

import com.mj.agritech.Familytable;
import com.mj.agritech.R;
import com.mj.agritech.UpdateBackground;
import com.mj.agritech.interventiondata;
import com.mj.agritech.updateintervention;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.mj.agritech.showdataadapter.mainposition;
import static com.mj.agritech.showdataadapter.showjsonarray;

public class Cropintervention extends DialogFragment {

    List<String> list2;
    String FAMILY_ID,year;
    Button submitquery;
    int entry_id;
    List<String> list1;
    FragmentManager fm;

    public Cropintervention(String FAMILY_ID, List<String> list1, FragmentManager fm)
    {
        this.FAMILY_ID=FAMILY_ID;
        this.list1=list1;
        this.fm=fm;

    }

    EditText Totalproduction,Cultivatedarea,Yield,Marketrate,Totalincome,Expenditure,CostofCultivation,Netincome;
    EditText Nameintervention,Quantity,unitintervention,ammountintervention;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoge_cropinterventiondetails, container, false);
        Cultivatedarea=v.findViewById(R.id.cultivated_area);
        Totalproduction=v.findViewById(R.id.total_production);
        submitquery=v.findViewById(R.id.submitlocation);
        Yield=v.findViewById(R.id.yield);
        Marketrate=v.findViewById(R.id.market_Rate);
        Totalincome=v.findViewById(R.id.totalincome);
        Expenditure=v.findViewById(R.id.expenditure);
        CostofCultivation=v.findViewById(R.id.costcultivation);
        Netincome=v.findViewById(R.id.netincome);

        Nameintervention=v.findViewById(R.id.nameintervention);
        Quantity=v.findViewById(R.id.qtyintervention);
        unitintervention=v.findViewById(R.id.unitmeasurement);
        ammountintervention=v.findViewById(R.id.ammountintervention);

        final Spinner spinner1 = v.findViewById(R.id.cropcategory);
        final Spinner spinner2 =  v.findViewById(R.id.cropsubcategory);
        spinner1.setPrompt("Crop Category");
        spinner2.setPrompt("Choose Crop");
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
        if(list1.size()>0)
        {

            try {
                JSONObject obj = showjsonarray.getJSONObject(mainposition);
                Cultivatedarea.setText(obj.getString("cultivated_area"));
                Totalproduction.setText(obj.getString("ttl_prod"));
                Yield.setText(obj.getString("yield"));
                Marketrate.setText(obj.getString("market_rate"));
                Totalincome.setText(obj.getString("total_income"));
                Expenditure.setText(obj.getString("ttl_expenditure"));
                CostofCultivation.setText(obj.getString("cultivation_cost"));
                Netincome.setText(obj.getString("net_income"));

                int spinnerPosition = myAdapter.getPosition(obj.getString("cat"));
                spinner1.setSelection(spinnerPosition);
                entry_id=obj.getInt("entry_id");
                list2.add(obj.getString("name"));
                int spinnerPosition2 = myAdapter2.getPosition(obj.getString("name"));
                spinner2.setSelection(spinnerPosition2);

            } catch (JSONException e) {
                e.printStackTrace();
            }



        }
        submitquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String a=  String.valueOf( spinner1.getSelectedItemPosition());
                //String b= String.valueOf( spinner2.getSelectedItemPosition());
                String a=  list.get( spinner1.getSelectedItemPosition());
                String b= list2.get( spinner2.getSelectedItemPosition());
                String type = "crop_cultivation";
                if(list1.size()>0)
                {
                    updateintervention updateBackground = new updateintervention (getContext(), v);
                    updateBackground.execute(type, a, b, Cultivatedarea.getText().toString(),
                            Totalproduction.getText().toString(), Yield.getText().toString(),
                            Marketrate.getText().toString(), Totalincome.getText().toString(),
                            Expenditure.getText().toString(), CostofCultivation.getText().toString(),
                            Netincome.getText().toString(),
                            FAMILY_ID,entry_id+"");
                    JSONArray emptyjson=new JSONArray();
                    showjsonarray=emptyjson;
                    fm.popBackStackImmediate();
                    list1.clear();
                }
                else {


                    interventiondata interventiondata = new interventiondata(getContext());
                    interventiondata.execute(type, a, b,Cultivatedarea.getText().toString(),
                            Totalproduction.getText().toString(),Yield.getText().toString() ,
                            Marketrate.getText().toString(),Totalincome.getText().toString(),
                            Expenditure.getText().toString(),CostofCultivation.getText().toString(),
                            Netincome.getText().toString(),
                            year
                            ,Nameintervention.getText().toString(),Quantity.getText().toString(),
                            unitintervention.getText().toString(),ammountintervention.getText().toString(),FAMILY_ID);
                    fm.popBackStackImmediate();
                }


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
