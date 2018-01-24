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
    DateFormat mDateFormat = DateFormat.getDateTimeInstance();

    // Declare a TextView to display the date and time
    TextView mDateAndTimeLabel;

    // Get an instance of a Calendar, and the current time
    Calendar mCalendar = Calendar.getInstance();

    // Define a new DatePickerDialog Listener object
    DatePickerDialog.OnDateSetListener datePickerDialogListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            // Update the Calendar object "mCalendar" with the Year, Month, and Day selected on the Dialog
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, monthOfYear);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            // Update the TextView displaying the results
            updateLabel();
        }
    };

    // Define a new TimePickerDialog Listener object
    TimePickerDialog.OnTimeSetListener timePickerDialogListener = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            // Update the Calendar object "mCalendar" with the hour and minute selected on the Dialog
            mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            mCalendar.set(Calendar.MINUTE, minute);

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

        // Set a listener on the date button to load a DatePickerDialog onscreen
        dateBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // Instantiate a new DatePickerDialog, passing in the context,
                // the defined datePickerDialogListener object, and the calendar's information
                new DatePickerDialog(
                        // Activity
                        MainActivity.this,
                        // The DatePickerDialog Listener object we defined,
                        // to set the selected time onto the calendar object
                        datePickerDialogListener,
                        // Get the year data that was last set on the Calendar object to display in the Dialog
                        mCalendar.get(Calendar.YEAR),
                        // Get the month data that was last set on the Calendar object to display in the Dialog
                        mCalendar.get(Calendar.MONTH),
                        // Get the day data that was last set on the Calendar object to display in the Dialog
                        mCalendar.get(Calendar.DAY_OF_MONTH))
                        // Show the dialog
                        .show();
            }
        });

        // Inflate the time button
        Button timeBtn = (Button) findViewById(R.id.timeBtn);

        // Set a listener on the time button to load a TimePickerDialog onscreen
        timeBtn.setOnClickListener(new View.OnClickListener() {

            // Instantiate a new TimePickerDialog, passing in the context,
            // the defined timePickerDialogListener object, and the calendar's information
            public void onClick(View v) {

                new TimePickerDialog(
                        // Activity
                        MainActivity.this,
                        // The TimePickerDialog Listener object we defined,
                        // to set the selected time onto the calendar object
                        timePickerDialogListener,
                        // Get the hour data that was last set on the Calendar object to display in the Dialog
                        mCalendar.get(Calendar.HOUR_OF_DAY),
                        // Get the minute data that was last set on the Calendar object to display in the Dialog
                        mCalendar.get(Calendar.MINUTE),
                        // Set 24 Hour View
                        true)
                        // Show the dialog
                        .show();
            }
        });

        // Inflate the result label
        mDateAndTimeLabel = (TextView) findViewById(R.id.dateAndTime);

        // Update the result label, with the default Calendar time on start up
        updateLabel();
    }

    // This method updates the result label
    private void updateLabel() {

        // Set the result label's text to the time that was set on the dataAndTime Calendar object
        mDateAndTimeLabel.setText(

                // Use the DateFormat object to properly format the time selected
                mDateFormat.format(mCalendar.getTime())
        );
    }
}
