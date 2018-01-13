package com.romellbolton.checkboxapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends Activity
        implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "MainActivity";

    // Declare Checkbox
    CheckBox cb;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        // Inflate Checkbox from XML file
        cb = (CheckBox) findViewById(R.id.check);

        // Set listener on Checkbox
        cb.setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // If the Checkbox is checked ...
        if (isChecked) {

            // Set the appropriate text for the Checkbox
            cb.setText("This checkbox is: checked");

            // Log checked message
            Log.i(TAG, "onCheckedChanged: This checkbox is: checked");

        } else { // If the Checkbox isn't checked ...

            // Set the appropriate text for the Checkbox
            cb.setText("This checkbox is: unchecked");

            // Log unchecked message
            Log.i(TAG, "onCheckedChanged: This checkbox is: unchecked");

        }
    }
}
