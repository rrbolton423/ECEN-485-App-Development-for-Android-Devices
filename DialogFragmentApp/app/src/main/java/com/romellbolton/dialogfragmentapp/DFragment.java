package com.romellbolton.dialogfragmentapp;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Have DFragment class extend "DialogFragment"
public class DFragment extends DialogFragment {

    // onCreateView() inflates the Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the Fragment, passing the dialog fragment layout itself, and the container
        View rootView = inflater.inflate(R.layout.dialog_fragment, container,
                false);

        // Set the title of the Fragment
        getDialog().setTitle("DialogFragment Tutorial");

        // Return the Fragment
        return rootView;
    }
}