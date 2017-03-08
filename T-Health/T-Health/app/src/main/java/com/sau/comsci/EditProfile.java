package com.sau.comsci;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aungpao.t_health.R;

import java.util.ArrayList;

public class EditProfile extends AppCompatActivity {
    private EditText edtName, edtOld, edtWeight, edtHight, edtSex;
    private RadioButton rdoMale, rdoFemale;
    private Button btnSave;
    private ArrayList<Profile> listData = new ArrayList<Profile>();
    private String sex;
    private ProfileDBHelper dbHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityProfile.class);
                startActivity(intent);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtName = (EditText) findViewById(R.id.edtName);
        edtOld = (EditText) findViewById(R.id.edtOld);
        edtWeight = (EditText) findViewById(R.id.edtWeight);
        edtHight = (EditText) findViewById(R.id.edtHight);
        btnSave = (Button) findViewById(R.id.btnSave);
        rdoMale = (RadioButton) findViewById(R.id.rdoMale);
        rdoFemale = (RadioButton) findViewById(R.id.rdoFemale);


        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub



                if (edtName.getText().toString().trim().equals("")) {
                    Toast.makeText(EditProfile.this, "กรุณาป้อนชื่อก่อน!", Toast.LENGTH_SHORT).show();

                } else if (edtOld.getText().toString().trim().equals("")) {
                    Toast.makeText(EditProfile.this, "กรุณาป้อนอายุก่อนกด!", Toast.LENGTH_SHORT).show();
                } else if (edtOld.getText().toString().trim().length() >= 3) {
                    Toast.makeText(EditProfile.this, "ท่านใส่อายุมากเกินไป!", Toast.LENGTH_SHORT).show();
                } else if (edtOld.getText().toString().trim().equals("0")) {
                    Toast.makeText(EditProfile.this, "อายุต้องไม่เป็น 0!", Toast.LENGTH_SHORT).show();
                } else if (edtOld.getText().toString().trim().equals("00")) {
                    Toast.makeText(EditProfile.this, "อายุต้องไม่เป็น 0!", Toast.LENGTH_SHORT).show();



                } else if (edtWeight.getText().toString().trim().equals("")) {
                    Toast.makeText(EditProfile.this, "กรุณาป้อนน้ำหนักก่อน!", Toast.LENGTH_SHORT).show();
                } else if (edtWeight.getText().toString().trim().length() >= 4) {
                    Toast.makeText(EditProfile.this, "ท่านใส่น้ำหนักเยอะเกินไป!", Toast.LENGTH_SHORT).show();
                } else if (edtWeight.getText().toString().trim().equals("0")) {
                    Toast.makeText(EditProfile.this, "น้ำหนักต้องไม่เป็น 0!", Toast.LENGTH_SHORT).show();
                } else if (edtWeight.getText().toString().trim().equals("00")) {
                    Toast.makeText(EditProfile.this, "น้ำหนักต้องไม่เป็น 0!", Toast.LENGTH_SHORT).show();
                } else if (edtWeight.getText().toString().trim().equals("000")) {
                    Toast.makeText(EditProfile.this, "น้ำหนักต้องไม่เป็น 0!", Toast.LENGTH_SHORT).show();



                } else if (edtHight.getText().toString().trim().equals("")) {
                    Toast.makeText(EditProfile.this, "กรุณาป้อนส่วนสูงก่อน!", Toast.LENGTH_SHORT).show();
                } else if (edtHight.getText().toString().trim().length() >= 4) {
                    Toast.makeText(EditProfile.this, "ท่านใส่ส่วนสูงมากเกินไป!", Toast.LENGTH_SHORT).show();
                } else if (edtHight.getText().toString().trim().equals("0")) {
                    Toast.makeText(EditProfile.this, "ส่วนสูงต้องไม่เป็น 0!", Toast.LENGTH_SHORT).show();
                } else if (edtWeight.getText().toString().trim().equals("00")) {
                    Toast.makeText(EditProfile.this, "น้ำหนักต้องไม่เป็น 0!", Toast.LENGTH_SHORT).show();
                } else if (edtWeight.getText().toString().trim().equals("000")) {
                    Toast.makeText(EditProfile.this, "น้ำหนักต้องไม่เป็น 0!", Toast.LENGTH_SHORT).show();



                } else {
                    if (rdoMale.isChecked()) {
                        sex = "ชาย";
                    } else {
                        sex = "หญิง";
                    }


                    database.delete("tbMyProfile", "id = " + 1, null);

                    addProfile();
                }
            }
        });
        //สร้างตัวจัดการฐานข้อมูล
        dbHelper = new ProfileDBHelper(this);

        //นำตัวจัดการฐานข้อมูลมาใช้งาน
        database = dbHelper.getWritableDatabase();

        //แสดงรายการสมาชิก
        showList();
    }


    private void addProfile() {
        // TODO Auto-generated method stub
        if (edtName.length() > 0 && edtOld.length() > 0 && edtWeight.length() > 0 && edtHight.length() > 0 && sex.length() > 0) {
            //เตรียมข้อมูลสำหรับใส่ลงไปในตาราง
            ContentValues values = new ContentValues();
            values.put("name", edtName.getText().toString());
            values.put("age", edtOld.getText().toString());
            values.put("weight", edtWeight.getText().toString());
            values.put("height", edtHight.getText().toString());
            values.put("sex", sex);

            //ทำการเพิ่มข้อมูลลงไปในตาราง member

            database.insert("tbMyProfile", null, values);
            Toast.makeText(this, "Add Data Complete", Toast.LENGTH_SHORT).show();

            //ล้างข้อมูล From
            edtName.setText("");
            edtOld.setText("");
            edtWeight.setText("");
            edtHight.setText("");
            rdoMale.isChecked();

            showList();
        } else {
            Toast.makeText(this, "Please Input Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void showList() {
        //ดึงข้อมูลสมาชิกจาก SQLite Database
        getProfile();
    }


    private void getProfile() {
        //ทำการ Query ข้อมูลจากตาราง member ใส่ใน Cursor
        Cursor mCursor = database.query(true, "tbMyProfile", new String[]{
                        "id", "name", "age", "weight", "height", "sex"}, null,
                null, null, null, null, null);
        //หรือใช้ Cursor mCursor = database.rawQuery("SELECT * FROM member", null);

        if (mCursor != null) {
            mCursor.moveToFirst();

            listData.clear();
            //ถ้ามีข้อมูลจะทำการเก็บข้อมูลใส่ List เพื่อนำไปแสดง
            if (mCursor.getCount() > 0) {
                do {
                    int id = mCursor.getInt(mCursor.getColumnIndex("id"));
                    String name = mCursor.getString(mCursor.getColumnIndex("name"));
                    int age = mCursor.getInt(mCursor.getColumnIndex("age"));
                    int weight = mCursor.getInt(mCursor.getColumnIndex("weight"));
                    int height = mCursor.getInt(mCursor.getColumnIndex("height"));
                    String sex = mCursor.getString(mCursor.getColumnIndex("sex"));

                    listData.add(new Profile(id, name, age, weight, height, sex));
                } while (mCursor.moveToNext());
            }
        }


    }
    public void onBackPressed() {
        Intent intent = new Intent(EditProfile.this, ActivityProfile.class);
        startActivity(intent);
        finish();
    }


}
