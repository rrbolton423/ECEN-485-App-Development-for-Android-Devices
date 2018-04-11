package com.romellbolton.navigationdrawerapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare ActionBarDrawerToggle
    ActionBarDrawerToggle mActionBarDrawerToggle;

    // Declare DrawerLayout
    DrawerLayout mDrawerLayout;

    // Declare TextView
    TextView messageTextView;

    // Declare ListView
    ListView mDrawerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to the TextView
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        // Get reference to the DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Display the top-left hamburger button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Instantiate the ActionBarDrawerToggle in order to make the hamburger button work
        // Parameters include...
        // 1. Application Context
        // 2. The DrawerLayout itself
        // 3. OpenDrawerContentDescription
        // 4. CloseDrawerContentDescription
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.app_name, R.string.app_name) {

            // Method is called when the drawer is closed
            @Override
            public void onDrawerClosed(View drawerView) {
            }

            // Method is called when the drawer is opened
            @Override
            public void onDrawerOpened(View drawerView) {
            }
        };

        // Set a drawer listener on the drawer layout to notify it of drawer events
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        // Sync the state of the drawer toggle with the drawer layout
        mActionBarDrawerToggle.syncState();

        // Get reference to the ListView
        mDrawerListView = (ListView) findViewById(R.id.left_drawer);

        // Set an OnItemClickListener on the ListView in the DrawerLayout
        mDrawerListView.setOnItemClickListener(new ListView.OnItemClickListener() {

            // Method called when an item in the ListView is clicked
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Change the TextView message when the ListView item is clicked
                messageTextView.setText("Menu Item at position " + position + " clicked.");

                // Close the drawer after ListView item is clicked
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    // onOptionsItemSelected() is called when a menu item is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {

            // Return true
            return true;
        }

        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    // onPostCreate() is called when the Activity start up is complete
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Sync the toggle state after onRestoreInstanceState has occurred
        mActionBarDrawerToggle.syncState();
    }

    // onConfigurationChanged() is called when a configuration change occurs
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Dispatch change to configuration of the ActionBarDrawerToggle
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

}