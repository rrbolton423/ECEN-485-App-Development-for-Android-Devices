package com.romellbolton.sqlitedatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by romellbolton on 3/21/18.
 */

// Create DatabaseHelper class and extend SQLiteOpenHelper
public class DatabaseHelper extends SQLiteOpenHelper {

    // Create Database Constants for the database file, table name, and columns
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRST_NAME";
    public static final String COL_3 = "LAST_NAME";
    public static final String COL_4 = "AGE";

    // Create DatabaseHelper constructor, passing the context, database name, and database version number
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    // onCreate() is called when the database is created for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Use the SQLiteDatabase object to execute a SQL statement that creates the database table
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT,LAST_NAME TEXT,AGE INTEGER)");
    }

    // onUpgrade() is called when the database needs to be upgraded.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop the table if if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Recreate the database table from scratch
        onCreate(db);
    }

    // insertData() inserts given data into the database
    public boolean insertData(String firstName, String lastName, String age) {

        // Get a SQLiteDatabase object
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a ContentValues object
        ContentValues contentValues = new ContentValues();

        // Put the first name value into the first name column
        contentValues.put(COL_2, firstName);

        // Put the last name value into the last name column
        contentValues.put(COL_3, lastName);

        // Put the age value into the age column
        contentValues.put(COL_4, age);

        // Use the database's insert() method to insert the contentValues into their
        // respective columns in the database table
        // Return the number of rows inserted
        long result = db.insert(TABLE_NAME, null, contentValues);

        // If there were 0 rows inserted into te database...
        if (result == -1) {

            // Return false
            return false;

            // If there were rows inserted into the database...
        } else {

            // Return true
            return true;
        }
    }

    // getAllData() returns all the data in the database
    public Cursor getAllData() {

        // Get a SQLiteDatabase object
        SQLiteDatabase db = this.getWritableDatabase();

        // Execute a query that returns everything from the Database table, which returns
        // a cursor object with the data
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);

        // Return the cursor
        return cursor;
    }

    // updateData() updates a certain row's data in the database
    public boolean updateData(String id, String firstName, String lastName, String age) {

        // Get a SQLiteDatabase object
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a ContentValues object
        ContentValues contentValues = new ContentValues();

        // Put the updated id value into the id column
        contentValues.put(COL_1, id);

        // Put the updated first name value into the first name column
        contentValues.put(COL_2, firstName);

        // Put the updated last name value into the last name column
        contentValues.put(COL_3, lastName);

        // Put the updated age value into the age column
        contentValues.put(COL_4, age);

        // Update the row from the table with the given ID argument
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});

        // Return true
        return true;
    }

    // deleteData() deletes the data from a certain row in the database
    public Integer deleteData(String id) {

        // Get a SQLiteDatabase object
        SQLiteDatabase db = this.getWritableDatabase();

        // Delete the row from the table with the given ID argument
        // Return the number of rows deleted
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }
}
