package com.sau.comsci;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aungpao.t_health.R;

public class AddExerciseActivity extends AppCompatActivity {


    private EditText edtEname, edtEcalorie;
    private Button btnInsertExercise;

    private ExerciseDBHelper exerciseDBHelper;

    Exercise exercise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityExercise.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtEname = (EditText) findViewById(R.id.edtEname);
        edtEcalorie = (EditText) findViewById(R.id.edtEcalorie);
        btnInsertExercise = (Button) findViewById(R.id.btnInsertExercise);

        exerciseDBHelper = new ExerciseDBHelper(AddExerciseActivity.this);
        exercise = new Exercise();


        btnInsertExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtEname.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "กรุณาป้อนชื่ออาหาร", Toast.LENGTH_SHORT).show();


                }else if(edtEcalorie.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(),"กรุณาป้อนพลังงานที่ใช้ไป", Toast.LENGTH_SHORT).show();
                }else if(edtEcalorie.getText().toString().trim().equals("0")){
                    Toast.makeText(getApplicationContext(),"ค่าพลังงานต้องไม่เป็น 0", Toast.LENGTH_SHORT).show();
                }else if(edtEcalorie.getText().toString().trim().equals("00")){
                    Toast.makeText(getApplicationContext(),"ค่าพลังงานต้องไม่เป็น 0", Toast.LENGTH_SHORT).show();
                }else if(edtEcalorie.getText().toString().trim().equals("000")){
                    Toast.makeText(getApplicationContext(),"ค่าพลังงานต้องไม่เป็น 0", Toast.LENGTH_SHORT).show();
                }else if(edtEcalorie.getText().toString().trim().equals("0000")){
                    Toast.makeText(getApplicationContext(),"ค่าพลังงานต้องไม่เป็น 0", Toast.LENGTH_SHORT).show();

                }else if(edtEcalorie.getText().toString().trim().length() >= 5){
                    Toast.makeText(getApplicationContext(),"ท่านใส่พลังงานเยอะเกินไป", Toast.LENGTH_SHORT).show();
                }else{



                    exercise.setEname(edtEname.getText().toString().trim());
                    exercise.setEcalorie(edtEcalorie.getText().toString().trim());
                    if(exerciseDBHelper.insertExercise(exercise) == true){
                        Toast.makeText(getApplicationContext(),"บันทึกข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
                        edtEname.setText("");
                        edtEcalorie.setText("");
                    }else{
                        Toast.makeText(getApplicationContext(),"การทำงานไม่สมบูรณ์", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
    public void onBackPressed() {
        finish();
    }

}