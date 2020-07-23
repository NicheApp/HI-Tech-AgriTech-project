package com.mj.agritech;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    Button register, log_in;
    EditText name, age, phone, trds ;
    String username, userage, userphone, usertrds;
    Boolean CheckEditText ;
    public  static ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = (EditText)findViewById(R.id.name);
        age = (EditText)findViewById(R.id.age);
        phone = (EditText)findViewById(R.id.phone);
        trds = (EditText)findViewById(R.id.trds);
      progressBar2=findViewById(R.id.progressBar2);
       register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar2.setVisibility(View.VISIBLE);
                        progressBar2.setProgress(0);
                    }
                }, 600);

                CheckEditTextIsEmptyOrNot();

                if(CheckEditText){
                    String type="register";
                    Registrationbackground registrationbackground=new Registrationbackground(getApplicationContext());
                    registrationbackground.execute(type,username,userage, userphone, usertrds);
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(RegistrationActivity.this);
                    View layoutView = getLayoutInflater().inflate(R.layout.dialog_postive_layout, null);
                    Button dialogButton = layoutView.findViewById(R.id.btnDialog);
                    dialogBuilder.setView(layoutView);
                    final AlertDialog   alertDialog = dialogBuilder.create();
                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    alertDialog.show();
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            alertDialog.dismiss();
                        }
                    });

                }
                else {



                    Toast.makeText(RegistrationActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();
                }
            }
        });
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