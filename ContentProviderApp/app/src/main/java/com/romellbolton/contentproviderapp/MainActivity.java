package com.romellbolton.contentproviderapp;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // onClickAddName() adds a new student record
    public void onClickAddName(View view) {

        // Create a ContentValues object
        ContentValues values = new ContentValues();

        // Put data into the values object, including the name of the Provider and Table to add data to,
        // and the raw data itself

        // Put the name from the Name EditText field into the "NAME" column of the Student Content Provider
        values.put(StudentsProvider.NAME,
                ((EditText)findViewById(R.id.txtName)).getText().toString());

        // Put the grade from the Grade EditText field into the "GRADE" column of the Student Content Provider
        values.put(StudentsProvider.GRADE,
                ((EditText)findViewById(R.id.txtGrade)).getText().toString());

        // Insert the values into the specified content provider, by passing the ContentURI of the
        // provider, as well as the data, values. The URI of the Content Provider is returned
        Uri uri = getContentResolver().insert(
                StudentsProvider.CONTENT_URI, values);

        // Display the URI of the Content Provider in a Toast Message
        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }

    // onClickRetrieveStudents retrieves student records
    public void onClickRetrieveStudents(View view) {

        // Create a String URL to the Content Provider of the app, "StudentsProvider".
        String URL = "content://com.romellbolton.contentproviderapp.StudentsProvider/students";

        // Parse the Provider URL into a URI
        Uri students = Uri.parse(URL);

        // Get the Content Resolver and call it's query method, passing the Content Provider''s URI
        // to return all of the data from the Provider's database. A cursor object is returned
        // with the queried data
        Cursor cursor = getContentResolver().query(students, null, null, null, "name");

        // Move to the first row of the cursor, in order to loop through all the data
        if (cursor.moveToFirst()) {
            do{
                // Display the ID, NAME, and GRADE of each Student in the Content Provider
                // in a Toast message.
                Toast.makeText(this,
                        cursor.getString(cursor.getColumnIndex(StudentsProvider._ID)) +
                                ", " +  cursor.getString(cursor.getColumnIndex( StudentsProvider.NAME)) +
                                ", " + cursor.getString(cursor.getColumnIndex( StudentsProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();

                // Move to the next row of the cursor
            } while (cursor.moveToNext());
        }
    }
}
