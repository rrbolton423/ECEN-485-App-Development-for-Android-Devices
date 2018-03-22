package com.romellbolton.intentserviceapp;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by romellbolton on 3/22/18.
 */

// Extend IntentService class
public class Service extends IntentService {

    // Add required constructor
    public Service() {
        super("");
    }

    // Add Tag for logging
    private static final String TAG = "Service";

    // Override onHandleIntent method which executes on a separate thread
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        // Log that the service started
        Log.i( TAG ,"Service Commenced!");
    }
}
