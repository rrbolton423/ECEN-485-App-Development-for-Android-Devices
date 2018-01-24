package com.romellbolton.menuapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Define TextViews
    TextView greenTv;
    TextView blueTv;
    TextView redTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inflate TextViews
        greenTv = findViewById(R.id.greenTv);
        blueTv = findViewById(R.id.blueTv);
        redTv = findViewById(R.id.redTv);

        // Set default color of BLACK to the TextView's contents
        greenTv.setTextColor(Color.BLACK);
        blueTv.setTextColor(Color.BLACK);
        redTv.setTextColor(Color.BLACK);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        // If the green menu item is selected ...
        if (id == R.id.green_item) {

            // Set the green text to green and set the others to default black
            greenTv.setTextColor(Color.GREEN);
            blueTv.setTextColor(Color.BLACK);
            redTv.setTextColor(Color.BLACK);

            // If the blue menu item is selected ...
        } else if (id == R.id.blue_item) {

            // Set the blue text to blue and set the others to default black
            greenTv.setTextColor(Color.BLACK);
            blueTv.setTextColor(Color.BLUE);
            redTv.setTextColor(Color.BLACK);

            // If the red menu item is selected ...
        } else if (id == R.id.red_item) {

            // Set the red text to red and set the others to default black
            greenTv.setTextColor(Color.BLACK);
            blueTv.setTextColor(Color.BLACK);
            redTv.setTextColor(Color.RED);
        }

        return super.onOptionsItemSelected(item);
    }
}
