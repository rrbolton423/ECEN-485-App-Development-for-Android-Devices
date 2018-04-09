package com.romellbolton.jsonparservolley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    // Define TextView to display TextView data
    private TextView mTextViewResult;

    // Define RequestQueue object that will dispatch a request
    // RequestQueue is used to stack your request and handles your cache.
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate TextView from XML file
        mTextViewResult = findViewById(R.id.text_view_result);

        // Inflate Button from XML file
        Button buttonParse = findViewById(R.id.button_parse);

        // Get an instance of a RequestQueue object
        mQueue = Volley.newRequestQueue(this);

        // Set a listener on the button widget
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Call the jsonParse() method... which parses the JSON from the web service
                jsonParse();
            }
        });
    }

    // jsonParse() creates a GET request, parses the JSON from the web service, and displays the parsed data
    // in a TextView
    private void jsonParse() {

        // Create a String URL to the location of the web service
        String url = "https://api.myjson.com/bins/kp9wz";

        // Create a request for retrieving a JSONObject response body at a given URL
        JsonObjectRequest request = new JsonObjectRequest(

                // Specify the type of request (GET), the url to the web request
                Request.Method.GET,

                // Specify the url to get a response from
                url,

                // Null argument
                null,

                // Add a listener for a successful response
                new Response.Listener<JSONObject>() {

                    // If a response is received...
                    @Override
                    public void onResponse(JSONObject response) {

                        // Try to...
                        try {

                            // Obtain the JSON Array named "employees"
                            JSONArray jsonArray = response.getJSONArray("employees");

                            // Loop through the length of the JSON Array "employees"...
                            for (int i = 0; i < jsonArray.length(); i++) {

                                // Get the current JSONObject from the JSON Array
                                JSONObject employee = jsonArray.getJSONObject(i);

                                // Get the first name String from the JSON Object
                                String firstName = employee.getString("firstname");

                                // Get the age int from the JSON Object
                                int age = employee.getInt("age");

                                // Get the mail String from the current JSON Object
                                String mail = employee.getString("mail");

                                // Display the parsed JSON data in the TextView
                                mTextViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
                            }

                            // JSONException Handle
                        } catch (JSONException e) {

                            // Print the Stack Trace
                            e.printStackTrace();
                        }
                    }
                },

                // Add a listener for a un-successful error response
                new Response.ErrorListener() {

            // If a response is NOT received...
            @Override
            public void onErrorResponse(VolleyError error) {

                // Print the Stack Trace
                error.printStackTrace();
            }
        });

        // Add the created JSONObjectRequest to the RequestQueue object
        // Add the one GET request to the queue
        mQueue.add(request);
    }
}