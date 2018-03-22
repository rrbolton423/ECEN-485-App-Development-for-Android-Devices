package com.romellbolton.fragmentsapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method to select the two fragments
    public void selectFrag(View view) {

        // Define a Fragment object
        android.app.Fragment fr;

        // If the Fragment2 button is pressed...
        if (view == findViewById(R.id.button2)) {

            // Set the Fragment to be FragmentTwo
            fr = new FragmentTwo();

            // If the FragmentOne button is pressed...
        } else {

            // Set the Fragment to FragmentOne
            fr = new FragmentOne();
        }

        // Create a FragmentManager object
        FragmentManager fm = getFragmentManager();

        // Begin the Fragment Transaction
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        // Replace the Fragment
        fragmentTransaction.replace(R.id.fragment_place, fr);

        // Commit the Transaction
        fragmentTransaction.commit();
    }
}
