package com.romellbolton.sqlitedatabaseapp;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Define DatabaseHelper
    DatabaseHelper database;

    // Define EditText widgets
    EditText editFirstName, editLastName, editAge, editId;

    // Define Button widgets
    Button btnAddData, btnViewAllData, btnDeleteData, btnUpdateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a new DatabaseHelper object
        database = new DatabaseHelper(this);

        // Inflate views from the XML
        editFirstName = (EditText) findViewById(R.id.editFirstName);
        editLastName = (EditText) findViewById(R.id.editLastName);
        editAge = (EditText) findViewById(R.id.editAge);
        editId = (EditText) findViewById(R.id.editId);
        btnAddData = (Button) findViewById(R.id.btnAddData);
        btnViewAllData = (Button) findViewById(R.id.btnViewAllData);
        btnUpdateData = (Button) findViewById(R.id.btnUpdateData);
        btnDeleteData = (Button) findViewById(R.id.btnDeleteData);

        // Call various methods
        addData();
        viewAll();
        updateData();
        deleteData();
    }

    // deleteData() deletes data from a particular row in the database
    public void deleteData() {

        // Set a listener on the delete button
        btnDeleteData.setOnClickListener(
                new View.OnClickListener() {

                    // Override the onClick() method
                    @Override
                    public void onClick(View v) {

                        // Get the ID of the item to be deleted from the "editId" EditText,
                        // and pass the Id to the database's deleteData() method as a String
                        Integer deletedRows = database.deleteData(editId.getText().toString());

                        // If there was a row deleted...
                        if (deletedRows > 0) {

                            // Show deletion Toast message
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();

                            // If there were 0 rows deleted...
                        } else {

                            // Show anti-deletion Toast message
                            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    // updateData() updates data on a particular row in the database
    public void updateData() {

        // Set a listener on the update button
        btnUpdateData.setOnClickListener(
                new View.OnClickListener() {

                    // Override the onClick() method
                    @Override
                    public void onClick(View v) {

                        // Get the ID, first name, last name, and age of the item to be updated from
                        // the EditText(s), and pass them into the database's updateData() method as Strings
                        boolean isUpdate = database.updateData(editId.getText().toString(),
                                editFirstName.getText().toString(),
                                editLastName.getText().toString(), editAge.getText().toString());

                        // If there was a row updated...
                        if (isUpdate) {

                            // Show update Toast message
                            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();

                            // If 0 rows were updated...
                        } else {

                            // Show anti-update Toast message
                            Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    // addData() inserts data to a particular row in the database
    public void addData() {

        // Set a listener on the addData button
        btnAddData.setOnClickListener(
                new View.OnClickListener() {

                    // Override the onClick() method
                    @Override
                    public void onClick(View v) {

                        // Get the first name, last name, and age of the item to be inserted from
                        // the EditText(s), and pass them into the database's updateData() method as Strings
                        boolean isInserted = database.insertData(editFirstName.getText().toString(),
                                editLastName.getText().toString(),
                                editAge.getText().toString());

                        // If there was a row insertion...
                        if (isInserted) {

                            // Show insertion Toast message
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();

                            // If there was 0 row insertions...
                        } else {

                            // Show anti-insertion Toast message
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    // viewAll() retrieves all the data from all rows in the database and displays it
    public void viewAll() {

        // Set a listener on the view data button
        btnViewAllData.setOnClickListener(
                new View.OnClickListener() {

                    // Override the onClick() method
                    @Override
                    public void onClick(View v) {

                        // Get the cursor with all of the database data
                        Cursor cursor = database.getAllData();

                        // If the cursor data returned nothing...
                        if (cursor.getCount() == 0) {

                            // Show error message
                            showMessage("Error", "Nothing found");

                            // Return from the method
                            return;
                        }

                        // Create a StringBuilder object
                        StringBuilder stringBuilder = new StringBuilder();

                        // Loop through the cursor
                        while (cursor.moveToNext()) {

                            // Append the data from the cursor to build up the final String
                            // until the cursor reaches it's end
                            stringBuilder.append("Id :" + cursor.getString(0) + "\n");
                            stringBuilder.append("First Name :" + cursor.getString(1) + "\n");
                            stringBuilder.append("Last Name :" + cursor.getString(2) + "\n");
                            stringBuilder.append("Age :" + cursor.getString(3) + "\n\n");
                        }

                        // Show all data
                        showMessage("Data", stringBuilder.toString());
                    }
                }
        );
    }

    // showMessage() displays the title and message Strings passed to this method
    // in a AlertDialog
    public void showMessage(String title, String Message) {

        // Build an AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set cancelable
        builder.setCancelable(true);

        // Set the title of the Dialog to the title String passed in
        builder.setTitle(title);

        // Set the message of the Dialog to the message String passed in
        builder.setMessage(Message);

        // Show the dialog
        builder.show();
    }
}
