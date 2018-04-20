package com.romellbolton.firebaseapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    // Declare Database and Database Reference
    FirebaseDatabase database;
    DatabaseReference myRef;

    // Declare Views
    Button updateDataBtn;
    TextView dataTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the views
        updateDataBtn = (Button) findViewById(R.id.updateDataBtn);
        dataTV = (TextView) findViewById(R.id.dataTV);

        // Get a new instance of a Firebase database
        database = FirebaseDatabase.getInstance();

        // Get a new Firebase database reference
        myRef = database.getReference("data");

        // Write initial data to the Firebase database reference
        myRef.setValue("Initial Data...");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                // Get the changed data value
                String value = dataSnapshot.getValue(String.class);

                // Display the data
                dataTV.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {

                // Failed to read value
                Toast.makeText(MainActivity.this, "Failed to read value.", Toast.LENGTH_SHORT).show();

            }
        });

        // Set a listener on the updateDataBtn
        updateDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Set a new value on the database reference
                myRef.setValue("New Data!");
            }
        });
    }
}
