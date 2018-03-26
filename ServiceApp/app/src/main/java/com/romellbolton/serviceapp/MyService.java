package com.romellbolton.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

// Have class extend the Service class
public class MyService extends Service {

    // Create TAG for logging
    private static final String TAG = "MyService";

    // Boolean to track whether Service is running or not
    private boolean isRunning  = false;

    // onCreate() is called when the Service is first created
    @Override
    public void onCreate() {

        // Display Service Started Toast Message
        Toast.makeText(MyService.this, "Service Started...", Toast.LENGTH_SHORT).show();

        // Log information
        Log.i(TAG, "Service onCreate");

        // Service is running
        isRunning = true;
    }

    // onStartCommand() called when the client starts the service with the startService() method
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Log information
        Log.i(TAG, "Service onStartCommand");

        // Creating new thread for my service
        // Always write your long running tasks in a separate thread, to avoid ANR
        new Thread(new Runnable() {
            @Override
            public void run() {

                // Your logic that service will perform will be placed here
                // In this example we are just looping and waits for 1000 milliseconds in each loop.

                // Loop 5 times
                for (int i = 0; i < 5; i++) {

                    try {

                        // Sleep the thread for 1 second
                        Thread.sleep(1000);

                        // Exception Handle
                    } catch (Exception e) {

                        // Print the stacktrace
                        e.printStackTrace();
                    }

                    // If the Service is indeed running...
                    if(isRunning){

                        // Log information
                        Log.i(TAG, "Service running");
                    }
                }

                // Stop service once it finishes its task
                stopSelf();
            }

            // Start the service initially when the Service class starts up
        }).start();

        // For backwards compatibility, the default implementation calls onStart
        // and returns either START_STICKY or START_STICKY_COMPATIBILITY.
        return Service.START_STICKY;
    }

    // This class is an unbound Service... no implementation needed of onBind()
    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    // onDestroy() called when the Service is destroyed
    @Override
    public void onDestroy() {

        // Service is no longer running
        isRunning = false;

        // Log information
        Log.i(TAG, "Service onDestroy");

        // Display Service Completed Toast Message
        Toast.makeText(MyService.this, "Service Completed!", Toast.LENGTH_SHORT).show();
    }
}
