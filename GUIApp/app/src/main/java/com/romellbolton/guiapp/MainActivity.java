package com.romellbolton.guiapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Create TAG for logging
    private static final String TAG = "MainActivity";

    // Define Views
    TextView greetingTV;
    Button helloBtn;
    Button byeBtn;

    TextView heroTV;
    CheckBox batmanCB;
    CheckBox supermanCB;

    TextView foodTV;
    RadioGroup radioGroup;
    RadioButton pizza;
    RadioButton burger;
    RadioButton chicken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate Views from XML file
        greetingTV = (TextView) findViewById(R.id.greetingTV);
        helloBtn = (Button) findViewById(R.id.helloBtn);
        byeBtn = (Button) findViewById(R.id.byeBtn);

        heroTV = (TextView) findViewById(R.id.heroTV);
        batmanCB = (CheckBox) findViewById(R.id.batmanCB);
        supermanCB = (CheckBox) findViewById(R.id.supermanCB);

        foodTV = (TextView) findViewById(R.id.foodTV);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        pizza = (RadioButton) findViewById(R.id.pizzaRadiotButton);
        burger = (RadioButton) findViewById(R.id.burgerRadioButton);
        chicken = (RadioButton) findViewById(R.id.chickenRadioButton);

        // Set Listener on the Hello Button
        helloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetingTV.setText("GREETINGS USER!");
            }
        });

        // Set Listener on the Bye Button
        byeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetingTV.setText("BYE BYE USER!");
            }
        });

        // Set Listener on the Superman checkbox
        supermanCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // If this checkbox is checked...
                if (isChecked) {

                    // Un-check the Batman checkbox
                    batmanCB.setChecked(false);

                    // Set the appropriate text
                    heroTV.setText("Superman > Batman");
                }
            }
        });

        // Set Listener on the Batman checkbox
        batmanCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // If this checkbox is checked...
                if (isChecked) {

                    // Un-check the Superman checkbox
                    supermanCB.setChecked(false);

                    // Set the appropriate text
                    heroTV.setText("Batman > Superman");
                }
            }
        });

        // Set Listener on RadioGroup
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // Check the ID of the RadioButton selected
                switch (checkedId) {

                    // In the case that the selected RadioButton was the pizzaRadioButton ...
                    case R.id.pizzaRadioButton:

                        // Set the appropriate text for this operation
                        foodTV.setText("PIZZA SELECTED!");

                        // Break from the switch statement
                        break;

                    // In the case that the selected RadioButton was the pizzaRadioButton ...
                    case R.id.burgerRadioButton:

                        // Set the appropriate text for this operation
                        foodTV.setText("BURGER SELECTED!");

                        // Break from the switch statement
                        break;

                    // In the case that the selected RadioButton was the pizzaRadioButton ...
                    case R.id.chickenRadioButton:

                        // Set the appropriate text for this operation
                        foodTV.setText("CHICKEN SELECTED!");

                        // Break from the switch statement
                        break;
                }
            }
        });

    }
}
