package com.romellbolton.jsonreadergson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    // Define TextView to display TextView data
    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate TextView from XML file
        mTextViewResult = findViewById(R.id.text_view_result);

        // Inflate Button from XML file
        Button buttonParse = findViewById(R.id.button_parse);

        // Set a listener on the button widget
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Call the jsonParse() method... which parses the JSON from the web service
                jsonParse();
            }
        });
    }

    // jsonParse() ...
    private void jsonParse() {

        String myJson = inputStreamToString(getResources().openRawResource(R.raw.employee));

        //Create a new Gson object
        Gson gson = new Gson();

        // convert the json to  Java object (Employee)
        Employee employee = gson.fromJson(myJson, Employee.class);

        mTextViewResult.setText("****Employee Details****" + "\n" +
                "Employee Name    : " + employee.getEmployeeName() + "\n" +
                "Employee ID      : " + employee.getEmployeeId() + "\n" +
                "Employee Department: " + employee.getDepartment());
        //Printing the Employee Details


    }

    public String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            String json = new String(bytes);
            return json;
        } catch (IOException e) {
            return null;
        }
    }


}


