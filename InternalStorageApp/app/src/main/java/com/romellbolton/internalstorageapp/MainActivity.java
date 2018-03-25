package com.romellbolton.internalstorageapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

    // Define EditText
    EditText mEditText;

    // Create numeric amount for characters to be read
    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate EditText
        mEditText = (EditText) findViewById(R.id.editText1);
    }

    // writeBtn() creates a file in Internal Storage and writes text to it
    public void writeBtn(View view) {

        // add-write text into file
        try {

            // Create FileOutputStream, passing the file and the privacy mode
            FileOutputStream fileOutputStream = openFileOutput("mytextfile.txt", MODE_PRIVATE);

            // Create OutputStreamWriter, passing the FileOutputStream
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileOutputStream);

            // Write to the file using the outputWriter
            outputWriter.write(mEditText.getText().toString());

            // Close the writer object
            outputWriter.close();

            // Display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

            // Exception Handle
        } catch (Exception e) {

            // Print the stacktrace
            e.printStackTrace();
        }
    }

    // readBtn() reads text from a file in Internal Storage
    public void ReadBtn(View view) {

        // reading text from existing file
        try {

            // Create a FileInputStream, passing in a text file
            FileInputStream fileIn = openFileInput("mytextfile.txt");

            // Create an InputStreamReader, passing the InputStream
            InputStreamReader inputStreamReader = new InputStreamReader(fileIn);

            // Create a input buffer reading 100 chars at a time
            char[] inputBuffer = new char[READ_BLOCK_SIZE];

            // Create an empty String
            String fileText = "";

            // Int the represent the number of characters being read at a time
            int charRead;

            // While the reader is still reading into the inputBuffer...
            while ((charRead = inputStreamReader.read(inputBuffer)) > 0) {

                // Char to String conversion
                // Take the String value of the chars read and assign it to readString
                String readString = String.copyValueOf(inputBuffer, 0, charRead);

                // Keep building up the result String every time through the while loop
                fileText += readString;
            }

            // Close the input reader
            inputStreamReader.close();

            // Set the text of the EditText to the resulting String from the XML file
            mEditText.setText(fileText);

            // Exception Handle
        } catch (Exception e) {

            // Print the stacktrace
            e.printStackTrace();
        }
    }
}
