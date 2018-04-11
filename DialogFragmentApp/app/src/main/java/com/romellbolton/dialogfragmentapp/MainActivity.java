package com.romellbolton.dialogfragmentapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    // Declare the Button Views
    Button dialogFragmentBtn;
    Button alertDialogFragmentBtn;

    // Get an instance of the FragmentManager
    FragmentManager fm = getSupportFragmentManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the view from activity_main.xml
        setContentView(R.layout.activity_main);

        // Locate the buttons in activity_main.xml
        dialogFragmentBtn = (Button) findViewById(R.id.dfragbutton);
        alertDialogFragmentBtn = (Button) findViewById(R.id.alertdfragbutton);

        // Capture button clicks
        dialogFragmentBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Instantiate DialogFragment
                DFragment dFragment = new DFragment();

                // Show DialogFragment
                dFragment.show(fm, "Dialog Fragment");
            }
        });

        // Capture button clicks
        alertDialogFragmentBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Instantiate Alert DialogFragment
                AlertDFragment alertdFragment = new AlertDFragment();

                // Show Alert DialogFragment
                alertdFragment.show(fm, "Alert Dialog Fragment");
            }
        });
    }
}
