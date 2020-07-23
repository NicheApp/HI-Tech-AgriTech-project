package com.mj.agritech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
EditText username,password;
String name,pass;
Button login;
public  static ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        username=findViewById(R.id.ed1);
        password=findViewById(R.id.ed2);
        login=findViewById(R.id.signin);
        progressBar=findViewById(R.id.progressBar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.VISIBLE);
                        progressBar.setProgress(0);
                    }
                }, 600);
                name=username.getText().toString();
                pass=password.getText().toString();
                String type="login";
                Backgroundworker backgroundworker=new Backgroundworker(getApplicationContext());
                backgroundworker.execute(type,name,pass);
            }
        });

    }
}
