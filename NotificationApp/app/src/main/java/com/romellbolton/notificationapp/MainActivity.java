package com.romellbolton.notificationapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Define Button
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate button from XML
        button = (Button) findViewById(R.id.buttonNotification);

        // Set listener on button
        button.setOnClickListener(new View.OnClickListener() {

            // override onClick() method
            @Override
            public void onClick(View view) {

                // Create a Notification builder
                NotificationCompat.Builder b = new NotificationCompat.Builder(getApplicationContext());

                // Set various properties on the notification
                b.setAutoCancel(true)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setTicker("{your tiny message}")
                        .setContentTitle("Notification")
                        .setContentText("This is a notification")
                        .setContentInfo("INFO");

                // Create a Pending Intent so when the notification is clicked,
                // it launches the activity that responds to the notification
                Intent notificationIntent = new Intent(getApplicationContext(), NotificationView.class);
                PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                b.setContentIntent(contentIntent);

                // Create the NotificationManager
                NotificationManager nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

                // Call the notification manager's notify() method,
                // passing the id and the notification builder
                nm.notify(1, b.build());
            }
        });
    }
}

