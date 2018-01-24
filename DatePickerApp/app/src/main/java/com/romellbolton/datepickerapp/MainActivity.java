package com.romellbolton.datepickerapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends Activity {

    // Declare a DateFormat object
    DateFormat fmtDateAndTime = DateFormat.getDateTimeInstance();

    // Declare a TextView to display the date and time
    TextView dateAndTimeLabel;

    // Get an instance of a Calendar
    Calendar dateAndTime = Calendar.getInstance();

    // Define a new DatePickerDialog, and set an OnDateSetListener() interface on it
    DatePickerDialog.OnDateSetListener datePickerDialog = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            // Update the Calendar object "dateAndTime" with the Year, Month, and Day selected on the Dialog
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            // Update the TextView displaying the results
            updateLabel();
        }
    };

    // Define a new TimePickerDialog, and set an OnDateSetListener() interface on it
    TimePickerDialog.OnTimeSetListener timePickerDialog = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            // Update the Calendar object "dateAndTime" with the hour and minute selected on the Dialog
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);

            // Update the TextView displaying the results
            updateLabel();
        }
    };

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // Inflate the layout
        setContentView(R.layout.activity_main);

        // Inflate the date button
        Button dateBtn = (Button) findViewById(R.id.dateBtn);

        // Set a listener on the date button to load a DatePickerDialog on screen
        dateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Instantiate a new DatePickerDialog, passing in the context,
                // the defined datePickerDialog object, and the calendar's information
                new DatePickerDialog(
                        // Activity
                        MainActivity.this,
                        // The DatePickerDialog object we defined
                        datePickerDialog,
                        // Get the year from the Calendar
                        dateAndTime.get(Calendar.YEAR),
                        // Get the month from the Calendar
                        dateAndTime.get(Calendar.MONTH),
                        // Get the day from the Calendar
                        dateAndTime.get(Calendar.DAY_OF_MONTH))
                        // Show the dialog
                        .show();
            }
        });

        // Inflate the time button
        Button timeBtn = (Button) findViewById(R.id.timeBtn);

        // Set a listener on the time button to load a TimePickerDialog on screen
        timeBtn.setOnClickListener(new View.OnClickListener() {

            // Instantiate a new TimePickerDialog, passing in the context,
            // the defined timePickerDialog object, and the calendar's information
            public void onClick(View v) {
                new TimePickerDialog(
                        // Activity
                        MainActivity.this,
                        // The TimePickerDialog object we defined
                        timePickerDialog,
                        // Get the hour from the Calendar
                        dateAndTime.get(Calendar.HOUR_OF_DAY),
                        // Get the minute from the Calendar
                        dateAndTime.get(Calendar.MINUTE),
                        // Set 24 Hour View
                        true)
                        // Show the dialog
                        .show();
            }
        });

        // Inflate the result label
        dateAndTimeLabel = (TextView) findViewById(R.id.dateAndTime);

        // Update the result label
        updateLabel();
    }

    // This method updates the result label
    private void updateLabel() {

        // Set the result label's text to the time that was set on the dataAndTime Calendar object
        dateAndTimeLabel.setText(fmtDateAndTime
                // Use the DateFormat object to properly format the time selected
                .format(dateAndTime.getTime()));
    }
}
