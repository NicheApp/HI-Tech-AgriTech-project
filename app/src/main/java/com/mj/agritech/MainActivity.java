package com.mj.agritech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import static com.mj.agritech.Backgroundworker.mypreference;
import static com.mj.agritech.Backgroundworker.usernamekey;
import static com.mj.agritech.Backgroundworker.userpasskey;

public class MainActivity extends AppCompatActivity {
SharedPreferences sharedpreferences;
EditText username,password;
String name,pass;
Button login;
public  static ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        String loginid = sharedPreferences.getString(usernamekey, "default value");
        String loginpass = sharedPreferences.getString(userpasskey, "default value");
      // sharedpreferences = getSharedPreferences(mypreference,
         //       Context.MODE_PRIVATE);
        if (!(loginid.equals("default value")) && !(loginpass.contains("default value"))) {
            this.startActivity(new Intent(MainActivity.this, ContainerActivity.class));

        }else {
            setContentView(R.layout.loginpage);
        username = findViewById(R.id.ed1);
        password = findViewById(R.id.ed2);
        login = findViewById(R.id.signin);
        progressBar = findViewById(R.id.progressBar);

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
                name = username.getText().toString();
                pass = password.getText().toString();
                String type = "login";
                Backgroundworker backgroundworker = new Backgroundworker(getApplicationContext());
                backgroundworker.execute(type, name, pass);
            }
        });
    }
    }
}
