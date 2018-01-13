package com.romellbolton.buttonapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends Activity implements View.OnClickListener {

    // Define Button
    Button btn;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // Instantiate Button
        btn = new Button(this);

        // Set Listener on Button
        btn.setOnClickListener(this);

        // Call updateTime() method on App startup
        updateTime();

        // Set the View of the screen to be the Button
        setContentView(btn);
    }

    public void onClick(View view) {

        // Call updateTime() when the Button is clicked
        updateTime();
    }

    private void updateTime() {

        // Set the text of the current time using the Date object
        btn.setText(new Date().toString());
    }
}
