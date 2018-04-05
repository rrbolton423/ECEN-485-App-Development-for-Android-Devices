package com.romellbolton.httpurlconnectionapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // Define Views
    TextView tvWeatherJson;
    Button btnFetchWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate Views from XML file
        tvWeatherJson = (TextView) findViewById(R.id.tv_weather_json);
        btnFetchWeather = (Button) findViewById(R.id.btn_fetch_weather);

        // Set a click listener on the fetch weather button
        btnFetchWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create and execute the AsyncTask
                new FetchWeatherData().execute();
            }
        });
    }

    // Create the AsyncTask class, make sure it extends "AsyncTask", it receives nothing as
    // a parameter, and returns a String to the main thread
    private class FetchWeatherData extends AsyncTask<Void, Void, String> {

        // doInBackground() is called on a background thread and downloads the data
        // that will be returned to the onPostExecute() method
        @Override
        protected String doInBackground(Void... params) {

            /* These two need to be declared outside the try/catch
               so that they can be closed in the finally block. */

            // Create a HttpURLConnection object
            HttpURLConnection urlConnection = null;

            // Create a BufferedReader object
            BufferedReader reader = null;

            // Create String that will contain the raw JSON response as a string.
            String forecastJsonStr = null;

            // Try to...
            try {

                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are available at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast

                // Create a URL to the API
                URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+"chicago"+"&APPID=ea574594b9d36ab688642d5fbeab847e");

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                /* Read the input stream into a String */

                // Create a InputStream object
                InputStream inputStream = urlConnection.getInputStream();

                // Create a StringBuffer object
                StringBuffer buffer = new StringBuffer();

                // If the input stream is nul...
                if (inputStream == null) {

                    // Nothing to do.

                    // Return null
                    return null;
                }

                // Create a BufferedReader, passing a new InputStream reader containing
                // the inputStream
                reader = new BufferedReader(new InputStreamReader(inputStream));

                // Create a String to represent every line read from the buffer
                String line;

                // While there are lines still left to be read, continue to read the data from
                // the reader object into the line String
                while ((line = reader.readLine()) != null) {

                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.

                    // Append each read line to the StringBuffer object
                    buffer.append(line + "\n");
                }

                // If the Stream is empty...
                if (buffer.length() == 0) {

                    // Stream was empty.  No point in parsing.

                    // Return null
                    return null;
                }

                // Convert the buffer data into a String and assign it to a String variable
                forecastJsonStr = buffer.toString();

                // Return the String version of the data to the onPostExecute() method
                return forecastJsonStr;

                // IOException handle
            } catch (IOException e) {

                // Log out error
                Log.e("PlaceholderFragment", "Error ", e);

                // If the code didn't successfully get the weather data, there's no point in attempting
                // to parse it.

                // Return null
                return null;

                // Finally...
            } finally {

                // If url connection is not null...
                if (urlConnection != null) {

                    // Disconnect from the connection
                    urlConnection.disconnect();

                    // If the reader is not null...
                } if (reader != null) {

                    // Try to...
                    try {

                        // Close the reader
                        reader.close();

                        // IOExceptionHandle
                    } catch (final IOException e) {

                        // Log out error
                        Log.e("PlaceholderFragment", "Error closing stream", e);
                    }
                }
            }
        }

        // onPostExecute() is called after doInBackground(), on the main thread,
        // and receives the downloaded data from it in the form of a String
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            // Display the downloaded data in a TextView
            tvWeatherJson.setText(s);

            // Log the data
            Log.i("json", s);
        }
    }
}