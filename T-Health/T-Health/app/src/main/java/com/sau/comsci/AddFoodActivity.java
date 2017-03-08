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

public class AddFoodActivity extends AppCompatActivity {

    private TextView txtShowFcalorie;
    private EditText edtFname,edt1, edt2, edt3;;
    private Button btnInsertFood,btnCalFcalorie;
    private FoodDBHelper foodDBHelper;
    Food food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
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
        edtFname = (EditText) findViewById(R.id.edtFname);
        btnInsertFood = (Button) findViewById(R.id.btnInsertFood);
        btnCalFcalorie = (Button) findViewById(R.id.btnCalFcalorie);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        edt3 = (EditText) findViewById(R.id.edt3);
        txtShowFcalorie = (TextView) findViewById(R.id.txtShowFcalorie);
        foodDBHelper = new FoodDBHelper(AddFoodActivity.this);
        food = new Food();


btnCalFcalorie.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (edt1.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "กรุณาป้อนค่าโปรตีน", Toast.LENGTH_SHORT).show();
        } else if (edt1.getText().toString().trim().length() >= 5) {
            Toast.makeText(getApplicationContext(), "ท่านป้อนค่าโปรตีนเยอะเกินไป", Toast.LENGTH_SHORT).show();
        } else if (edt2.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "กรุณาป้อนค่าคาร์โบไฮเดรต", Toast.LENGTH_SHORT).show();
        } else if (edt2.getText().toString().trim().length() >= 5) {
            Toast.makeText(getApplicationContext(), "ท่านป้อนค่าคาร์โบไฮเดรตเยอะเกินไป", Toast.LENGTH_SHORT).show();
        } else if (edt3.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "กรุณาป้อนค่าไขมัน", Toast.LENGTH_SHORT).show();
        } else if (edt3.getText().toString().trim().length() >= 5) {
            Toast.makeText(getApplicationContext(), "ท่านป้อนค่าไขมันเยอะเกินไป", Toast.LENGTH_SHORT).show();
        } else {
            int s1 = Integer.parseInt(edt1.getText().toString().trim());
            int s2 = Integer.parseInt(edt2.getText().toString().trim());
            int s3 = Integer.parseInt(edt3.getText().toString().trim());
            int show = (s1 * 4) + (s2 * 4) + (s3 * 9);
            txtShowFcalorie.setText(Integer.toString(show) +"  " );
        }
    }
});


        btnInsertFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtFname.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "กรุณาป้อนชื่ออาหาร", Toast.LENGTH_SHORT).show();
                }else if(txtShowFcalorie.getText().toString().trim().equals("XXXX")){
                    Toast.makeText(getApplicationContext(),"กรุณาป้อนพลังงานที่ได้รับ", Toast.LENGTH_SHORT).show();
                }else if(txtShowFcalorie.getText().toString().trim().equals("0")){
                    Toast.makeText(getApplicationContext(),"กรุณาป้อนค่าพลังงานที่ถูกต้อง", Toast.LENGTH_SHORT).show();
                }else{
                food.setFname(edtFname.getText().toString().trim());
                food.setFcalorie(txtShowFcalorie.getText().toString().trim());
                if(foodDBHelper.insertFood(food) == true){
                    Toast.makeText(getApplicationContext(),"บันทึกข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
                    edtFname.setText("");
                    txtShowFcalorie.setText("");
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