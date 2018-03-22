package com.romellbolton.okhttpapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    // Define TextView
    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextView
        mTextViewResult = findViewById(R.id.text_view_result);

        // Create Client
        OkHttpClient client = new OkHttpClient();

        // Create url
        String url = "https://reqres.in/api/users?page=2";

        // Build Request
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Start the request on a worker thread and listen for results
        client.newCall(request).enqueue(new Callback() {

            // If failed...
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

                // Print the stacktrace
                e.printStackTrace();
            }

            // If success...
            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                if (response.isSuccessful()) {

                    // Get the response in the form of a String
                    final String myResponse = response.body().string();

                    // Display the String on the Main UI Thread's TextView
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(myResponse);
                        }
                    });
                }
            }
        });
    }
}
