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

public class Activity_MenuApp extends AppCompatActivity {
    private ImageButton imgHome,imgMap,imgBrow,imgContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__menu_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgHome = (ImageButton)findViewById(R.id.imgHome);
        imgMap = (ImageButton)findViewById(R.id.imgMap);
        imgBrow = (ImageButton)findViewById(R.id.imgBrow);
        imgContact = (ImageButton)findViewById(R.id.imgContact);


        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_MenuApp.this,Activity_Menu.class);
                startActivity(intent);
                finish();
            }
        });

        imgMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_MenuApp.this,Activity_MenuMaps.class);
                startActivity(intent);
                finish();
            }
        });

        imgBrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_MenuApp.this,Activity_MenuNews.class);
                startActivity(intent);
                finish();
            }
        });

        imgContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_MenuApp.this,Activity_MenuContact.class);
                startActivity(intent);
                finish();
            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Activity_MenuApp.this,Activity_Menu.class);
        startActivity(intent);
        finish();

    }

}
