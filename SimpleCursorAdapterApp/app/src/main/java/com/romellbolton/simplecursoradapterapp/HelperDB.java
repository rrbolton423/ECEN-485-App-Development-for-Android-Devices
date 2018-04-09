package com.romellbolton.simplecursoradapterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by romellbolton on 4/6/18.
 */

// Have Database Helper class extend SQLiteOpenHelper
public class HelperDB extends SQLiteOpenHelper {

    // Create Constructor
    public HelperDB(Context context) {

        // Call to super, passing the context, database name, and database version
        super(context, "STUDENTS", null, 4);
    }

    // Override onCreate() method
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Execute the SQL Statement that creates the Database table
        db.execSQL("create table student " + "( _id INTEGER PRIMARY KEY AUTOINCREMENT, name_col text, email_col text )");
    }

    // Override onUpgrade() method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop the table
        db.execSQL("DROP TABLE IF EXISTS student");

        // Re-create the table
        onCreate(db);
    }

    // insertStudent() inserts a student's name and email information into a database
    public boolean insertStudent(String name, String email) {

        // Get the SQLiteDatabase object from the helper object
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a ContentValues object
        ContentValues contentValues = new ContentValues();

        // Put the name data into the values object
        contentValues.put("name_col", name);

        // Put the email data into the values object
        contentValues.put("email_col", email);

        // Insert the values into the database
        db.insert("student", null, contentValues);

        // Return true if the insertion was successful
        return true;
    }

    // getData() returns all of the data from the database in a cursor object
    public Cursor getData() {

        // Get the SQLiteDatabase object from the helper object
        SQLiteDatabase db = this.getReadableDatabase();

        // Query the entire database and return the cursor object
        Cursor cursor = db.rawQuery("select * from student", null);

        // Return the cursor object
        return cursor;
    }
}
