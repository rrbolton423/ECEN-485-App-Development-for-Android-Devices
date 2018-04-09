package com.romellbolton.radiobuttonapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Define RadioGroup object
    private RadioGroup radioSexGroup;

    // Define Radio Button object
    private RadioButton radioSexButton;

    // Define Display Button
    private Button btnDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call method that adds a listener on the button
        addListenerOnButton();
    }

    // addListenerOnButton() checks to see which radio button in the radio group was selected
    public void addListenerOnButton() {

        // Instantiate RadioGroup object
        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);

        // Instantiate Radio Button object
        btnDisplay = (Button) findViewById(R.id.btnDisplay);

        // Set on click listener on the button
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get selected RadioButton from RadioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // Find the RadioButton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                // Make a Toast message showing which RadioButton was selected
                // in the RadioGroup
                Toast.makeText(MainActivity.this,
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
