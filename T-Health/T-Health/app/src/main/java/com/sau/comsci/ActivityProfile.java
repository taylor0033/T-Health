package com.sau.comsci;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aungpao.t_health.R;

import org.w3c.dom.Text;


public class ActivityProfile extends AppCompatActivity {
    private EditText txtName, txtSurname, txtAge;
    private Button btnEdit;
    private LayoutInflater mInflater;
    private Context context;
    private EditProfile control;
    public HolderListAdapter holderListAdapter;
    private ListView listProfile;


    //ตัวจัดการฐานข้อมูล
    private ProfileDBHelper dbHelper;
    private SQLiteDatabase database;


    //list ในการเก็บข้อมูลของ MemberData
    private ArrayList<Profile> listData = new ArrayList<Profile>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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

        listProfile = (ListView) findViewById(R.id.listProfile);
        btnEdit = (Button) findViewById(R.id.btnEdit);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityProfile.this, EditProfile.class);
                startActivity(intent);


            }
        });

        dbHelper = new ProfileDBHelper(this);

        //นำตัวจัดการฐานข้อมูลมาใช้งาน
        database = dbHelper.getWritableDatabase();

        //แสดงรายการสมาชิก
        showList();
    }

    //Method ดึงข้อมูลจาก SQLite
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

    private void showList() {
        //ดึงข้อมูลสมาชิกจาก SQLite Database
        getProfile();

        //แสดงสมาชิกใน ListView
        listProfile.setAdapter(new ProfileListViewAdapter(this, listData));
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),Activity_Menu.class);
        startActivity(intent);
        finish();
    }


   /* Method ลบข้อมูลใน SQLite
   public void deleteMember(int id){
     database.delete("tbMyProfile", "id = " + id, null);
      Toast.makeText(this, "Delete Data Id " + id + " Complete", Toast.LENGTH_SHORT).show();

       showList();
    }
*/

}
