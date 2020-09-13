package com.mj.agritech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import static com.mj.agritech.Backgroundworker.mypreference;

public class ContainerActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    Boolean CheckEditText ;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    public  static ProgressBar progressBar2;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        bottomNavigation = findViewById(R.id.bottomBar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        nv = (NavigationView)findViewById(R.id.nv);

        progressBar2=findViewById(R.id.progressBar2);
        dl = (DrawerLayout)findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this, dl,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        dl.addDrawerListener(t);
        t.syncState();
        fm = getSupportFragmentManager();

if(savedInstanceState==null)
{
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RegistrationActivity()).commit();

}

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.index:

                        Toast.makeText(ContainerActivity.this, "My Account",Toast.LENGTH_SHORT).show();break;
                    case R.id.help:
                        Toast.makeText(ContainerActivity.this, "Settings",Toast.LENGTH_SHORT).show();break;
                    case R.id.logout:
                       // SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(mypreference , Context.MODE_PRIVATE);
                        //sharedPreferences.edit().clear().commit();
                       // SharedPreferences sharedPreferences = PreferenceManager
                         //       .getDefaultSharedPreferences(getApplicationContext());
                        //SharedPreferences.Editor
                        Intent intent =new Intent(ContainerActivity.this,MainActivity.class);
                        startActivity(intent);
                    default:
                        return true;
                }


                return true;

            }
        });
bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.reg:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RegistrationActivity()).commit();

                return true;
            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new searchfragment()).commit();
                //().beginTransaction().replace(R.id.fragment_container,new searchfragment()).commit();
                //openFragment(SmsFragment.newInstance("", ""));

              //  SearchBackground searchBackground=new SearchBackground(getApplication(),fm);
               // searchBackground.execute();
                return true;
            case R.id.report:

                Reportbackground reportbackground=new Reportbackground(getApplication(),fm);
                reportbackground.execute();
              // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Reportclass()).commit();
               // openFragment(NotificationFragment.newInstance("", ""));

                return true;
        }


        return false;
    }
});


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}
