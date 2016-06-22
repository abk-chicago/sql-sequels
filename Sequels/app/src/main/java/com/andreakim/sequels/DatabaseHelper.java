package com.andreakim.sequels;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andreakim on 6/22/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;   // all caps syntax is only for finals, very important; change as we upgrade
    public static final String DB_NAME = "ReallyBadSequels.db";  // name of your .db
    public static final String CREATE_TABLE = "CREATE TABLE sequels (id INT PRIMARY KEY, name TEXT);";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS sequels;";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE );  //create table
    }

    // database name (i.e. db) can be anything

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);  //drop table
        onCreate(db);  //after erasing it, want to re-seed the database, re-create the table
    }

    // NOT an @Override
    public void seedDatabase() {
        insertSequel(1,"Empire Strikes Back");
        insertSequel(2,"Toy Story 2");
        insertSequel(3,"Raiders of the Lost Arc");
        insertSequel(4,"Halloween 2");
        insertSequel(5,"Mulan 2");
        insertSequel(6,"Taken 2");
        insertSequel(7,"Jaws 2");
        insertSequel(8,"Deathwish 2");
        insertSequel(9,"Zoolander 2");
        insertSequel(10,"Die Harder with a Vengance");
        //sample data
    }

    public void insertSequel(int id, String name) {
        //insert into table_name values (1, "blah");
        SQLiteDatabase db = getReadableDatabase();
        //special type of HashMap for Database values, below
        ContentValues values = new ContentValues();
        values.put("id",id);
        values.put("name",name);
        // PRO-TIP: GREAT PLACE TO PUT IN A BREAK POINT for debugging
        db.insert("sequels", null, values); //insert into table, null, values

    }

    public Sequel getSequel(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = new String[]{"id","name"};  //columns to select
        String selection = "id = ?";         //similar to a where clause; defining a selection
        String[] selesctionArguments = new String[] { Integer.toString(id) };  // (or use string.value of)
        

        Sequel movie = new Sequel();
        return movie;
    }
    public void getSequels() {


    }

    public void removeSequel() {


    }








}
