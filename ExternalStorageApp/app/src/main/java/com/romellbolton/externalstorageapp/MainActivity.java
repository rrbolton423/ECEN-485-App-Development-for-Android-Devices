package com.romellbolton.externalstorageapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    // Define Views
    EditText inputText;
    TextView response;
    Button saveButton,readButton;

    // Define File name and path
    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";

    // Define File object
    File myExternalFile;

    // Define String representation of the data
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate views from XML
        inputText = (EditText) findViewById(R.id.myInputText);
        response = (TextView) findViewById(R.id.response);
        saveButton = (Button) findViewById(R.id.saveExternalStorage);


        // save button creates a file in and writes to it
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    // Create an output stream to the file already existing in External Storage
                    FileOutputStream fos = new FileOutputStream(myExternalFile);

                    // Write to the file using the EditText's contents
                    fos.write(inputText.getText().toString().getBytes());

                    // Close the outputStream
                    fos.close();

                    // Exception handle
                } catch (IOException e) {

                    // Print stacktrace
                    e.printStackTrace();
                }

                // Reset the EditText's contents to nothing
                inputText.setText("");

                // Display file saved message in the TextView field
                response.setText("SampleFile.txt saved to External Storage...");
            }
        });

        // Inflate view from XML
        readButton = (Button) findViewById(R.id.getExternalStorage);

        // read button gets the file from External Storage and reads and displays it's contents
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    // Create a File Input Stream, passing the File in External Storage
                    FileInputStream fis = new FileInputStream(myExternalFile);

                    // Create a Data Input Stream, passing it the FileInputStream
                    DataInputStream in = new DataInputStream(fis);

                    // Create a Buffered Reader, passing an InputStream reader that contains
                    // the DataInputStream containing the file in ExternalStorage
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));

                    // Create a String to represent the number of lines left to read in the file
                    String strLine;

                    // While there are still files left in the file,
                    // save the contents of the buffered reader into the String "strLine"
                    // on line at a time
                    while ((strLine = br.readLine()) != null) {

                        // Add the single line of the file to the myData String,
                        // that holds all of the String lines of the file
                        myData += strLine;
                    }

                    // Close the input stream
                    in.close();

                    // Exception handle
                } catch (IOException e) {

                    // Print the stack trace
                    e.printStackTrace();
                }

                // Display the files contents in the EditText field
                inputText.setText(myData);

                // Display file retrieved message in the TextView field
                response.setText("SampleFile.txt data retrieved from External Storage...");
            }
        });

        /* Determine if External Storage is available upon app start up */

        // If External Storage is not available nor writable...
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {

            // Disable the save button
            saveButton.setEnabled(false);

            // If External Storage is available as well as writable...
        } else {

            // Create a File in the External storage directory,
            // passing the directory in External storage to write to,
            // as well as the file name
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }
    }

    // isExternalStorageReadOnly() determines if External Storage is readable only
    // and not writable on the device
    private static boolean isExternalStorageReadOnly() {

        // Get the state of External Storage on the device
        String extStorageState = Environment.getExternalStorageState();

        // If External Storage is readable only and not writable...
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {

            // Return true
            return true;
        }

        // If External Storage is writable, return false
        return false;
    }

    // isExternalStorageReadOnly() determines if External Storage is available on the device
    private static boolean isExternalStorageAvailable() {

        // Get the state of External Storage on the device
        String extStorageState = Environment.getExternalStorageState();

        // If External Storage is available on the device
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {

            // Return true
            return true;
        }

        // If External Storage is not available on the device, return false
        return false;
    }
}
