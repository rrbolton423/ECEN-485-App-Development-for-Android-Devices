package com.romellbolton.notificationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// This notification is launched as a result of the notification click
public class NotificationView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view);
    }
}
