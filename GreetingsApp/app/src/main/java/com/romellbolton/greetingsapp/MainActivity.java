package com.romellbolton.greetingsapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    // String array containing different greetings
    String[] textArray = {
            "HI",
            "BONJOUR",
            "HOLA",
            "HALLO",
            "GUTEN TAG",
            "CIAO",
            "NAMASTE",
            "NI HAU",
            "SALAAM",
            "ZDRAS-TVUY-TE"
    };

    // counter variable
    int counter;

    // Define button
    Button btn;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // Instantiate button
        btn = new Button(this);

        // Set OnCLickListener interface on button
        btn.setOnClickListener(this);

        // Call the updateTime() method
        updateGreeting();

        // Add button to the layout
        setContentView(btn);
    }

    public void onClick(View view) {

        // Call the updateGreeting() method when the button is clicked
        updateGreeting();
    }

    private void updateGreeting() {

        // Logic for iterating through an array via button click
        btn.setText(textArray[counter]);
        if (counter < textArray.length - 1) {
            counter++;
        } else {
            counter = 0;
        }
    }
}
