package com.sau.comsci;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.aungpao.t_health.R;

public class Activity_MenuMaps extends AppCompatActivity {
    private ImageButton imgApp,imgHome,imgBrow,imgContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__menu_maps);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgContact = (ImageButton)findViewById(R.id.imgContact);
        imgHome = (ImageButton)findViewById(R.id.imgHome);
        imgBrow = (ImageButton)findViewById(R.id.imgBrow);
        imgApp = (ImageButton)findViewById(R.id.imgApp);


        imgContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_MenuMaps.this,Activity_MenuContact.class);
                startActivity(intent);
                finish();
            }
        });

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_MenuMaps.this,Activity_Menu.class);
                startActivity(intent);
                finish();
            }
        });

        imgBrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_MenuMaps.this,Activity_MenuNews.class);
                startActivity(intent);
                finish();
            }
        });

        imgApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_MenuMaps.this,Activity_MenuApp.class);
                startActivity(intent);
                finish();
            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Activity_MenuMaps.this,Activity_Menu.class);
        startActivity(intent);
        finish();

    }

}
