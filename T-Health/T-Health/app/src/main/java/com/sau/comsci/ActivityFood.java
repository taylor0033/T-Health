package com.sau.comsci;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.aungpao.t_health.R;

public class ActivityFood extends AppCompatActivity {

    private Button btnAddFood,btnEditFood,btnDeleteFood,btnShowAllFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_Menu.class);
                startActivity(intent);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnAddFood = (Button) findViewById(R.id.btnAddFood);
        btnEditFood = (Button) findViewById(R.id.btnEditFood);
        btnDeleteFood = (Button) findViewById(R.id.btnDeleteFood);
        btnShowAllFood = (Button) findViewById(R.id.btnShowAllFood);


        btnShowAllFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(ActivityFood.this,ShowFoodActivity.class);
                startActivity(intent);
            }
        });

        btnAddFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(ActivityFood.this,AddFoodActivity.class);
                startActivity(intent);
            }
        });
        btnEditFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(ActivityFood.this,EditFoodActivity.class);
                startActivity(intent);
            }
        });

        btnDeleteFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(ActivityFood.this,DeleteFoodActivity.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),Activity_Menu.class);
        startActivity(intent);
        finish();
    }
}
