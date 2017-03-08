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

public class ActivityExercise extends AppCompatActivity {

    private Button btnAddExercise,btnEditExercise,btnDeleteExercise,btnShowAllExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
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


        btnAddExercise = (Button) findViewById(R.id.btnAddExercise);
        btnEditExercise = (Button) findViewById(R.id.btnEditExercise);
        btnDeleteExercise = (Button) findViewById(R.id.btnDeleteExercise);
        btnShowAllExercise = (Button) findViewById(R.id.btnShowAllExercise);


        btnShowAllExercise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(ActivityExercise.this,ShowExerciseActivity.class);
                startActivity(intent);
            }
        });

        btnAddExercise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(ActivityExercise.this,AddExerciseActivity.class);
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
