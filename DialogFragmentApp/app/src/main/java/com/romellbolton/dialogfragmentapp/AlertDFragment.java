package com.romellbolton.dialogfragmentapp;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

// Have AlertDFragment class extend "DialogFragment"
public class AlertDFragment extends DialogFragment {

    // onCreateDialog() creates the Dialog Fragment
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Return the AlertDialog
        return new AlertDialog.Builder(getActivity())

                // Set Dialog Icon
                .setIcon(R.mipmap.ic_launcher)

                // Set Dialog Title
                .setTitle("Alert DialogFragment Title")

                // Set Dialog Message
                .setMessage("Alert DialogFragment Message")

                // Positive button
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something else
                    }
                })

                // Negative Button
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,	int which) {
                        // Do something else
                    }

                }).create(); // Create the AlertDialog
    }
}
