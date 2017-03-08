package com.sau.comsci;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;



public class ExerciseDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 13;
    private static final String DB_NAME = "dbExercise";

    public ExerciseDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table tbMyExercise ( eid integer primary key autoincrement,"
                +"ename text not null,"
                +"ecalorie integer not null"
                +")";
        db.execSQL(strSql);

        strSql = "insert into tbMyExercise ( ename, ecalorie ) values ('วิ่ง', '500')";
        db.execSQL(strSql);

        strSql = "insert into tbMyExercise ( ename, ecalorie ) values ('วิดพื้น', '500')";
        db.execSQL(strSql);

        strSql = "insert into tbMyExercise ( ename, ecalorie ) values ('ว่ายน้ำ', '500')";
        db.execSQL(strSql);

        strSql = "insert into tbMyExercise ( ename, ecalorie ) values ('ยกเหวด', '500')";
        db.execSQL(strSql);

        strSql = "insert into tbMyExercise ( ename, ecalorie ) values ('เล่นฟุตบอล', '500')";
        db.execSQL(strSql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String strSql = "drop table if exists tbMyExercise";
        db.execSQL(strSql);
        onCreate(db);
    }


    public boolean insertExercise(Exercise exercise){
        try{
            String strSql = "insert into tbMyExercise ( ename, ecalorie ) values"
                    +"('"+ exercise.getEname() +"' , '"+ exercise.getEcalorie() +"')";
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(strSql);
            db.close();
            return true;
        }catch (Exception ex){
            return false;
        }
    }



    public List<Exercise> showAllExercise(){
        String strSql = "select * from tbMyExercise";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(strSql,null);
        List<Exercise> exerciseList = new ArrayList<Exercise>();
        if(cursor.moveToFirst()) {
            do {
                Exercise exercise = new Exercise();
                exercise.setEname(cursor.getString(cursor.getColumnIndex("ename")));
                exercise.setEcalorie(cursor.getString(cursor.getColumnIndex("ecalorie")));

                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }else{
            exerciseList = null;
        }
        return exerciseList;
    }

}
