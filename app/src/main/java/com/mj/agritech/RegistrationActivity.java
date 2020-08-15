package com.mj.agritech;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegistrationActivity extends Fragment {

    Button register, log_in;
    EditText name, age, phone, trds;
    String username, userage, userphone, usertrds;
    Boolean CheckEditText;
    CheckBox checkBox;
    ImageView phoneimage;
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
        checkBox=view.findViewById(R.id.checkbox);
        phoneimage=view.findViewById(R.id.imageView3);
        progressBar2 = view.findViewById(R.id.progressBar2);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()==true) {
                    phone.setVisibility(View.VISIBLE);
                    phoneimage.setVisibility(View.VISIBLE);

                }
            else
                {

                    phone.setVisibility(View.INVISIBLE);
                    phoneimage.setVisibility(View.INVISIBLE);


                }

            }
        });


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

                if (CheckEditText) {
                    String type = "register";
                    Registrationbackground registrationbackground = new Registrationbackground(getContext());
                    registrationbackground.execute(type, username, userage, userphone, usertrds);


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
        if(checkBox.isChecked()==true){
        userphone = phone.getText().toString();
        }else
        {
            userphone="";
        }
        usertrds = trds.getText().toString();


        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(userage)  || TextUtils.isEmpty(usertrds))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }


    }


    }

