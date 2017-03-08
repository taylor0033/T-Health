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

public class DeleteFoodActivity extends AppCompatActivity {

    private EditText edtSearchFood;
    private TextView txtNameFood, txtCalorieFood;
    private Button btnSearchFood, btnDeleteFood;
    private FoodDBHelper foodDBHelper;


    Food food;

    public int fid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityFood.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        edtSearchFood = (EditText) findViewById(R.id.edtSearchFood);
        txtNameFood = (TextView) findViewById(R.id.txtNameFood);
        txtCalorieFood = (TextView) findViewById(R.id.txtCalorieFood);
        btnSearchFood = (Button) findViewById(R.id.btnSearchFood);
        btnDeleteFood = (Button) findViewById(R.id.btnDeleteFood);

        foodDBHelper = new FoodDBHelper(DeleteFoodActivity.this);


        food = new Food();

        btnSearchFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( edtSearchFood.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(), "ป้อนชื่อที่จะค้นหา...", Toast.LENGTH_SHORT).show();
                }else{
                    food = foodDBHelper.searchFoodUpDel( edtSearchFood.getText().toString().trim());
                    if(food == null){
                        Toast.makeText(getApplicationContext(), "ไม่พบข้อมูลที่ค้นหา...", Toast.LENGTH_SHORT).show();
                        txtNameFood.setText("XXXXX");
                        txtCalorieFood.setText("XXXXX");
                        fid=0;
                    }else{
                        fid = food.getFid();
                        txtNameFood.setText(food.getFname());
                        txtCalorieFood.setText(food.getFcalorie());
                    }
                }
            }
        });


        btnDeleteFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fid == 0){
                    Toast.makeText(getApplicationContext(), "กรุณาค้นหาข้อมูล...", Toast.LENGTH_SHORT).show();
                }else {
                    food.setFid(fid);
                    if (foodDBHelper.deleteFood(food ) == true ){
                        Toast.makeText(getApplicationContext(), "ลบข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
                        txtNameFood.setText("XXXXX");
                        txtCalorieFood.setText("XXXXX");
                        fid=0;
                    }else{
                        Toast.makeText(getApplicationContext(), "! การทำงานไม่สมบูรณ์", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
