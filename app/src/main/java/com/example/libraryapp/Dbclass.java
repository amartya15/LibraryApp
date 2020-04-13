package com.example.libraryapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

class dbclass extends SQLiteOpenHelper {

    public dbclass(Context context) {
        super(context,"sample" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqll = "create table bookstructure(itemid INTEGER PRIMARY KEY,name TEXT,category TEXT,weight REAL,price REAL,location TEXT)";
        String sql = "create table user(id INTEGER PRIMARY KEY,usernamead TEXT,passwordad TEXT)";
        sqLiteDatabase.execSQL(sql);
        String sql2 = "insert into user(usernamead,passwordad) values ('shop','12345')";
        sqLiteDatabase.execSQL(sql2);
        String sql13="create table userlog(userid INTEGER PRIMARY KEY,username TEXT,password TEXT,location TEXT)";
        sqLiteDatabase.execSQL(sql13);
        String sql14="create table bookrequest(username TEXT,itemid INTEGER,name TEXT)";
        sqLiteDatabase.execSQL(sql14);


        sqLiteDatabase.execSQL(sqll);
        String sql5 = "create table showbooks(bookid INTEGER PRIMARY KEY,name TEXT,author TEXT, number REAL,category TEXT) ";
        sqLiteDatabase.execSQL(sql5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String sql = "drop table bookstructure";

        db.execSQL(sql);
        this.onCreate(db);
    }


    public void requestBook(String username, String itemid ,String name )
    {

        String sql14="insert into bookrequest(username,itemid,name) values ('"+username+"','"+itemid+"','"+name+"')";
        SQLiteDatabase db= this.getWritableDatabase();
        Log.e("SQL",sql14);
        db.execSQL(sql14 );
    }

   public ArrayList<bookrequest> getit(){
       ArrayList<bookrequest> data = new ArrayList<>();



       String sql14 = " select * from bookrequest ";
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor= db.rawQuery(sql14,null);
       if(cursor.moveToFirst())
       {
           do{
               String username = cursor.getString(0);
               int itemid= cursor.getInt(1);
               String name = cursor.getString(2);






              bookrequest c = new bookrequest(username,itemid,name);
               data.add(c);
           }while (cursor.moveToNext());
       }
       return  data;

   }

    public void addbooks(String name,String category,int weight,int price,String location){

        String sql ="insert into bookstructure(name,category,weight,price,location) values ('"+name+"','"+category+"','"+weight+"','"+price+"','"+location+"')";

        SQLiteDatabase db= this.getWritableDatabase();
        Log.e("SQL",sql);
        db.execSQL(sql);

    }
    public void showbooks1(String name,String author, int number,String category){

        String sql12 ="insert into showbooks(name,author,number,category) values ('"+name+"','"+author+"', '"+number+"' ,'"+category+"')";

        SQLiteDatabase db= this.getWritableDatabase();
        Log.e("SQL",sql12);
        db.execSQL(sql12);

    }

    public void updateBook(String name,String category,int itemid, int weight,int price,String location)
    {
        String sql = "update bookstructure set name='"+name+"',category='"+category+"',weight='"+weight+"',price='"+price+"',location='"+location+"' where itemid='"+itemid+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
    public void deleteBook(int itemid)
    {

        String sql = "delete from bookstructure where itemid='"+itemid+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }




    public ArrayList<bookstructure> getallbooks() {
        ArrayList<bookstructure> data = new ArrayList<>();



        String sql = " select * from bookstructure ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(1);
                String category = cursor.getString(2);
                int weight = cursor.getInt(3);
                int price = cursor.getInt(4);
                String location=cursor.getString(5);
                int itemid = cursor.getInt(0);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,category,weight,price,location,itemid);
                data.add(c);
            }while (cursor.moveToNext());
        }
        return  data;
    }
    public ArrayList<bookstructure> getallcosmetics() {
        ArrayList<bookstructure> data = new ArrayList<>();
        String sql = " select * from bookstructure where category = 'cosmetics' ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String category = cursor.getString(2);
                int weight = cursor.getInt(3);
                int price = cursor.getInt(4);
                String location=cursor.getString(5);
                int itemid = cursor.getInt(0);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,category,weight,price,location,itemid);
                data.add(c);
            } while (cursor.moveToNext());
        }
        return data;
    }

    public ArrayList<bookstructure> getallpulses() {
            ArrayList<bookstructure> data = new ArrayList<>();
            String sql = " select * from bookstructure where category = 'pulses' ";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(1);
                    String category = cursor.getString(2);
                    int weight = cursor.getInt(3);
                    int price = cursor.getInt(4);
                    String location=cursor.getString(5);
                    int itemid = cursor.getInt(0);
                    boolean isselected = cursor.getWantsAllOnMoveCalls();
                    bookstructure c = new bookstructure(isselected,name,category,weight,price,location,itemid);
                    data.add(c);
                } while (cursor.moveToNext());
            }
            return data;
        }

    public ArrayList<bookstructure> getalloil() {
        ArrayList<bookstructure> data = new ArrayList<>();
        String sql = " select * from bookstructure where category = 'oil' ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(1);
                String category = cursor.getString(2);
                int weight = cursor.getInt(3);
                int price = cursor.getInt(4);
                String location=cursor.getString(5);
                int itemid = cursor.getInt(0);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,category,weight,price,location,itemid);
                data.add(c);
            }while (cursor.moveToNext());
        }
        return  data;
    }

    public ArrayList<bookstructure> getalldailyneeds() {
        ArrayList<bookstructure> data = new ArrayList<>();
        String sql = " select * from bookstructure where category ='daily needs'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(1);
                String category = cursor.getString(2);
                int weight = cursor.getInt(3);
                int price = cursor.getInt(4);
                String location=cursor.getString(5);
                int itemid = cursor.getInt(0);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,category,weight,price,location,itemid);
                data.add(c);
            }while (cursor.moveToNext());
        }
        return  data;
    }

    public ArrayList<bookstructure> getallrice() {
        ArrayList<bookstructure> data = new ArrayList<>();
        String sql = " select * from bookstructure where category = 'rice'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(1);
                String category = cursor.getString(2);
                int weight = cursor.getInt(3);
                int price = cursor.getInt(4);
                String location=cursor.getString(5);
                int itemid = cursor.getInt(0);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,category,weight,price,location,itemid);
                data.add(c);
            }while (cursor.moveToNext());
        }
        return  data;
    }


    public user checklogin(String usernamead,String passwordad)
    {
        user u= null;
        String sql = "select * from user where usernamead ='"+usernamead+"' and passwordad ='"+passwordad+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c= db.rawQuery(sql,null);
        if(c.moveToFirst())
        {
            int id = c.getInt(0);
            String uusernamead = c.getString(1);
            String ppasswordad  = c.getString(2);
            u = new user(id,uusernamead,ppasswordad);
        }
        return u;
    }
    public void addlogin(String username,String password,String location)
    {

        String sql13 ="insert into userlog(username,password,location) values ('"+username+"','"+password+"','"+location+"')";
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL(sql13);

    }
    public userlog userlogin(String username,String password,String location) {
        userlog uu = null;
        String sql = "select * from userlog where username='"+username.trim()+"'and password='"+password.trim()+"'and location='"+location.trim()+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        //System.out.println(password);
        System.out.println("location");
        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            int userid = c.getInt(0);
            String uuusername = c.getString(1);
            String pppassword = c.getString(2);
            String llocation =c.getString(3);
            uu = new userlog(userid, uuusername, pppassword,llocation);
        }
        return uu;
    }
    public ArrayList<bookstructure> getlocation() {
        ArrayList<bookstructure> data = new ArrayList<>();
        String sql = "select name and location from bookstructure";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String category = cursor.getString(2);
                int weight = cursor.getInt(3);
                int price = cursor.getInt(4);
                String location=cursor.getString(5);
                int itemid = cursor.getInt(0);
                boolean isselected = cursor.getWantsAllOnMoveCalls();
                bookstructure c = new bookstructure(isselected,name,category,weight,price,location,itemid);
                data.add(c);
            } while (cursor.moveToNext());
        }
        return data;
    }



}
