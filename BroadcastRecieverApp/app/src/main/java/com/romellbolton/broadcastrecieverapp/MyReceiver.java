package com.romellbolton.broadcastrecieverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by romellbolton on 3/22/18.
 */

// Have Receiver class extends BroadcastReciever
public class MyReceiver extends BroadcastReceiver {

    // Create Tag for logging
    private static final String TAG = "MyReceiver";

    // override onReceive() method
    @Override
    public void onReceive(Context context, Intent intent) {

        // Log information
        Log.i(TAG, "onReceive: ");

        // Create Toast message saying that the Intent was received
        Toast.makeText(context, "Intent Detected!", Toast.LENGTH_LONG).show();
    }
}
