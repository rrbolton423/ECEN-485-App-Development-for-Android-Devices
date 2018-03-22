package com.romellbolton.alertdialogapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Define button
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate button from XML
        button = (Button) findViewById(R.id.buttonDialog);

        // Set Listener on button
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Create an Alert Dialog
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                // Set the title on the dialog
                alertDialog.setTitle("Alert");

                // Set the message on the dialog
                alertDialog.setMessage("Alert message to be shown");

                // Set the button on the dialog
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",

                        // Set a listener on the dialog button
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {

                                // Dismiss the dialog when pressed
                                dialog.dismiss();
                            }
                        });

                // Show Dialog
                alertDialog.show();
            }
        });
    }
}
