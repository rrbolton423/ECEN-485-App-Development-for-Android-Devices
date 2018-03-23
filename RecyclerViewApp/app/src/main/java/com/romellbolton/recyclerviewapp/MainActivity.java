package com.romellbolton.recyclerviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Define RecyclerView
    RecyclerView mRecyclerView;

    // Define LinearLayoutManager
    LinearLayoutManager mLinearLayoutManager;

    // Define a RecyclerViewAdapter
    RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Recycler View by id from layout file
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Create Linear Layout Manager which defines how it will be shown on the screen
        mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        // Set Layout Manager in the RecyclerView
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        // Create Adapter object from the data by calling default Constructor
        mRecyclerViewAdapter = new RecyclerViewAdapter(getTestListItems());

        // Set RecyclerView Adapter
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    // Create RecyclerViewAdapter class and extend RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder
    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        // Define list
        private ArrayList<String> myList;

        // Create constructor that accepts a list as a parameter
        public RecyclerViewAdapter(ArrayList<String> list) {

            // Save the list to the field of the class
            this.myList = list;
        }

        // Called when RecyclerView needs a new view
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            // Create a new itemView
            final View itemView = LayoutInflater.from(
                    parent.getContext()).inflate(R.layout.rcv_viewholder, parent, false);

            // Return a ViewHolder object with the current itemView
            return new ViewHolder(itemView);
        }

        // Called by RecyclerView to display the data at the specified position.
        // This method should update the contents of the views
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            // Get the String representation of the item from the list from the current position
            String itemText = myList.get(position);

            // Set the text of the current item to the current TextView using the holder
            holder.vText.setText(itemText);
        }

        // Returns the total number of items in the data set held by the adapter.
        @Override
        public int getItemCount() {

            // Return the size of the list
            return myList.size();
        }

        // Create ViewHolder class and extend RecyclerView.ViewHolder
        public class ViewHolder extends RecyclerView.ViewHolder {

            // Define a TextView
            protected TextView vText;

            // Create a ViewHolder constructor that receives a itemView
            public ViewHolder(View itemView) {

                // Call to super
                super(itemView);

                // Inflate the TextView from the XML
                vText = (TextView) itemView.findViewById(R.id.text);
            }
        }
    }

    // Method produces a list of 99 items
    private ArrayList<String> getTestListItems() {

        // Create a list
        ArrayList<String> list = new ArrayList<>();

        // Loop 99 times
        for (int i = 0; i < 100; i++) {

            // Add a item every time the loop goes
            list.add("Item " + i);
        }

        // Return the list of 99 items
        return list;
    }
}