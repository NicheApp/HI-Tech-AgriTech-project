package com.mj.agritech;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import static com.mj.agritech.Backgroundworker.mypreference;

public class RegistrationActivity extends Fragment {

    Button register, log_in;
    EditText name, age, phone, trds;
    String username, userage, userphone, usertrds;
    Boolean CheckEditText;
    public static ProgressBar progressBar2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_registration, container, false);
        name = (EditText) view.findViewById(R.id.name);
        age = (EditText) view.findViewById(R.id.age);
        phone = (EditText) view.findViewById(R.id.phone);
        trds = (EditText) view.findViewById(R.id.trds);
        register = view.findViewById(R.id.register);
        //progressBar2 = view.findViewById(R.id.progressBar2);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar2.setVisibility(View.VISIBLE);
                        progressBar2.setProgress(0);
                    }
                }, 600);*/

                CheckEditTextIsEmptyOrNot();

                if (CheckEditText) {
                    String type = "register";
                    Registrationbackground registrationbackground = new Registrationbackground(getContext());
                    registrationbackground.execute(type, username, userage, userphone, usertrds);
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
                    View layoutView = getLayoutInflater().inflate(R.layout.dialog_postive_layout, null);
                    Button dialogButton = layoutView.findViewById(R.id.btnDialog);
                    dialogBuilder.setView(layoutView);
                    final AlertDialog alertDialog = dialogBuilder.create();
                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    alertDialog.show();
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            alertDialog.dismiss();
                        }
                    });

                } else {


                    Toast.makeText(getContext(), "Please fill all form fields.", Toast.LENGTH_LONG).show();
                }
            }
        });
        return  view;
    }



    public void CheckEditTextIsEmptyOrNot(){

        username = name.getText().toString();
        userage= age.getText().toString();
        userphone = phone.getText().toString();
        usertrds = trds.getText().toString();


        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(userage) || TextUtils.isEmpty(userphone) || TextUtils.isEmpty(usertrds))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }


    }




}