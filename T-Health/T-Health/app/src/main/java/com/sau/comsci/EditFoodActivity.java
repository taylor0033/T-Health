package com.sau.comsci;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import com.example.aungpao.t_health.R;


public class EditFoodActivity extends AppCompatActivity {

    private EditText edtSearchFood,edtNameFood, edtCalorieFood;
    private Button btnSearchFood, btnUpdateFood;
    private FoodDBHelper foodDBHelper;
    Food food;
    public int fid = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);
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
        edtNameFood = (EditText) findViewById(R.id.edtNameFood);
        edtCalorieFood = (EditText) findViewById(R.id.edtCalorieFood);
        btnSearchFood = (Button) findViewById(R.id.btnSearchFood);
        btnUpdateFood = (Button) findViewById(R.id.btnUpdateFood);


        foodDBHelper = new FoodDBHelper(EditFoodActivity.this);

        food = new Food();


        btnSearchFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtSearchFood.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "ป้อนชื่อที่จะค้นหา...", Toast.LENGTH_SHORT).show();
                } else {
                    food = foodDBHelper.searchFoodUpDel(edtSearchFood.getText().toString().trim());
                    if (food == null) {
                        Toast.makeText(getApplicationContext(), "ไม่พบข้อมูลที่ค้นหา...", Toast.LENGTH_SHORT).show();
                        edtNameFood.setText("");
                        edtCalorieFood.setText("");
                        fid = 0;
                    } else {
                        fid = food.getFid();
                        edtNameFood.setText(food.getFname());
                        edtCalorieFood.setText(food.getFcalorie());
                    }
                }
            }
        });


        btnUpdateFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fid == 0) {
                    Toast.makeText(getApplicationContext(), "กรุณาค้นหาข้อมูล...", Toast.LENGTH_SHORT).show();
                } else {
                    food.setFid(fid);
                    food.setFname(edtNameFood.getText().toString().trim());
                    food.setFcalorie(edtCalorieFood.getText().toString().trim());

                    if (foodDBHelper.updateFood(food) == true) {
                        Toast.makeText(getApplicationContext(), "แก้ไขข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
                        edtNameFood.setText("");
                        edtCalorieFood.setText("");
                        fid = 0;
                    } else {
                        Toast.makeText(getApplicationContext(), "! การทำงานไม่สมบูรณ์", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
}
