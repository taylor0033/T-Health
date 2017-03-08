package com.sau.comsci;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.aungpao.t_health.R;

import java.text.DecimalFormat;

public class Activity_Menu extends AppCompatActivity {

    private Button btnP, btnF, btnE, btnS;
    private ImageButton imgApp, imgMap, imgBrow, imgContact;
    private TextView txtName, txtWeight, txtHigth, txtBmr, txtBmi, txtBmiStatus, txtBmrForYou;
    private Double Bmr, Bmi;


    //ตัวจัดการฐานข้อมูล
    private ProfileDBHelper dbHelper;
    private SQLiteDatabase database;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        imgApp = (ImageButton) findViewById(R.id.imgApp);
        imgMap = (ImageButton) findViewById(R.id.imgMap);
        imgBrow = (ImageButton) findViewById(R.id.imgBrow);
        imgContact = (ImageButton) findViewById(R.id.imgContact);


        btnP = (Button) findViewById(R.id.btnProfile);
        btnF = (Button) findViewById(R.id.btnFood);
        btnE = (Button) findViewById(R.id.btnEx);
        btnS = (Button) findViewById(R.id.btnShow);

        txtBmi = (TextView) findViewById(R.id.txtShowBmi);
        txtBmr = (TextView) findViewById(R.id.txtShowBmr);
        txtHigth = (TextView) findViewById(R.id.txtShowHeight);
        txtWeight = (TextView) findViewById(R.id.txtShowWeight);
        txtName = (TextView) findViewById(R.id.txtShowName);
        txtBmiStatus = (TextView) findViewById(R.id.txtShowBmiResul);
        txtBmrForYou = (TextView) findViewById(R.id.txtShowBmrWant);

        imgApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this, Activity_MenuApp.class);
                startActivity(intent);
                finish();
            }
        });

        imgMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this, Activity_MenuMaps.class);
                startActivity(intent);
                finish();
            }
        });

        imgBrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this, Activity_MenuNews.class);
                startActivity(intent);
                finish();
            }
        });

        imgContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this, Activity_MenuContact.class);
                startActivity(intent);
                finish();
            }
        });


        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this, ActivityProfile.class);
                startActivity(intent);
                finish();
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this, ActivityFood.class);
                startActivity(intent);
                finish();
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this, ActivityExercise.class);
                startActivity(intent);
                finish();
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this, ActivityShow.class);
                startActivity(intent);
                finish();
            }
        });


        dbHelper = new ProfileDBHelper(this);

        //นำตัวจัดการฐานข้อมูลมาใช้งาน
        database = dbHelper.getWritableDatabase();


        Cursor mCursor = database.query(true, "tbMyProfile", new String[]{
                        "id", "name", "age", "weight", "height", "sex"}, null,
                null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();

            if (mCursor.getCount() > 0) {
                do {
                    int id = mCursor.getInt(mCursor.getColumnIndex("id"));
                    String name = mCursor.getString(mCursor.getColumnIndex("name"));
                    String age = mCursor.getString(mCursor.getColumnIndex("age"));
                    String weight = mCursor.getString(mCursor.getColumnIndex("weight"));
                    String height = mCursor.getString(mCursor.getColumnIndex("height"));
                    String sex = mCursor.getString(mCursor.getColumnIndex("sex"));

                    Double w = Double.parseDouble(weight.toString().trim());
                    Double h = Double.parseDouble(height.toString().trim());
                    Double a = Double.parseDouble(age.toString().trim());
                    DecimalFormat df = new DecimalFormat("#,###.00");


                    if (sex.toString().trim().equals("ชาย")) {
                        Bmr = 10 * w + 6.25 * h - 5 * a + 5;
                    } else {
                        Bmr = 10 * w + 6.25 * h - 5 * a - 161;
                    }

                    Bmi = w / (h * h) * 10000;

                    if (Bmi < 17.5) {
                        txtBmiStatus.setText("ผอม");

                    } else if (Bmi < 25) {
                        txtBmiStatus.setText("ปกติ");
                    } else {
                        txtBmiStatus.setText("อ้วน");
                    }

                    txtName.setText(name);
                    txtHigth.setText(height);
                    txtWeight.setText(weight);
                    txtBmi.setText(df.format(Bmi));
                    txtBmr.setText(df.format(Bmr));

                } while (mCursor.moveToNext());
            }
        }


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Exit");
        dialog.setIcon(R.drawable.p1);
        dialog.setCancelable(true);
        dialog.setMessage("Do you want to exit?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialog.show();
    }


}
