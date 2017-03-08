package com.sau.comsci;


 import android.content.Context;
 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.database.sqlite.SQLiteOpenHelper;

 import java.util.ArrayList;
 import java.util.List;

 public class FoodDBHelper extends SQLiteOpenHelper {
 private static final int DB_VERSION = 13;
 private static final String DB_NAME = "dbFood";


 public FoodDBHelper(Context context) {
 super(context, DB_NAME, null, DB_VERSION);
 }


 @Override
 public void onCreate(SQLiteDatabase db) {
 String strSql = "create table tbMyFood ( fid integer primary key autoincrement,"
 +"fname text not null,"
 +"fcalorie integer not null"
 +")";
 db.execSQL(strSql);

 strSql = "insert into tbMyFood ( fname, fcalorie ) values ('ข้าวมันไก่', '500')";
 db.execSQL(strSql);

 strSql = "insert into tbMyFood ( fname, fcalorie ) values ('ข้าวมันไก่ทอด', '300')";
 db.execSQL(strSql);

 strSql = "insert into tbMyFood ( fname, fcalorie ) values ('ราดหน้า', '400')";
 db.execSQL(strSql);

 strSql = "insert into tbMyFood ( fname, fcalorie ) values ('ข้าวผัดกระเพรา', '200')";
 db.execSQL(strSql);

 strSql = "insert into tbMyFood ( fname, fcalorie ) values ('ข้าวหน้าเป็ด', '100')";
 db.execSQL(strSql);
 }


 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 String strSql = "drop table if exists tbMyFood";
 db.execSQL(strSql);
 onCreate(db);
 }


 public boolean insertFood(Food food){
 try{
 String strSql = "insert into tbMyFood ( fname, fcalorie ) values"
 +"('"+ food.getFname() +"' , '"+ food.getFcalorie() +"')";
 SQLiteDatabase db = this.getWritableDatabase();
 db.execSQL(strSql);
 db.close();
 return true;
 }catch (Exception ex){
 return false;
 }
 }


  public Food searchFoodUpDel(String dataSearch) {
   String strSql = "select * from tbMyFood where fname='" + dataSearch + "'";
   SQLiteDatabase db = this.getWritableDatabase();
   Cursor cursor = db.rawQuery(strSql, null);
   Food food = new Food();
   if (cursor.moveToFirst()) {
    food.setFid(cursor.getInt(cursor.getColumnIndex("fid")));
    food.setFname(cursor.getString(cursor.getColumnIndex("fname")));
    food.setFcalorie(cursor.getString(cursor.getColumnIndex("fcalorie")));
   } else {
    food = null;
   }
   db.close();
   return food;
  }



  public boolean updateFood(Food food) {
   try {
    String strSql = "update tbMyFood set fname='" + food.getFname()
            + "',fcalorie='" + food.getFcalorie()
            + ",where fid=" + food.getFid();

    SQLiteDatabase db = this.getWritableDatabase();
    db.execSQL(strSql);
    db.close();
    return true;
   } catch (Exception ex) {
    return false;
   }
  }





  public boolean deleteFood(Food food) {
   try {
    String strSql = "delete from tbMyFood where fid=" + food.getFid();
    SQLiteDatabase db = this.getWritableDatabase();
    db.execSQL(strSql);
    db.close();
    return true;
   } catch (Exception ex) {
    return false;
   }
  }



  public List<Food> showAllFood(){
 String strSql = "select * from tbMyFood";
 SQLiteDatabase db = this.getWritableDatabase();
 Cursor cursor = db.rawQuery(strSql,null);
 List<Food> foodList = new ArrayList<Food>();
 if(cursor.moveToFirst()) {
 do {
 Food food = new Food();
 food.setFname(cursor.getString(cursor.getColumnIndex("fname")));
 food.setFcalorie(cursor.getString(cursor.getColumnIndex("fcalorie")));

 foodList.add(food);
 } while (cursor.moveToNext());
 }else{
 foodList = null;
 }
 return foodList;
 }

 }