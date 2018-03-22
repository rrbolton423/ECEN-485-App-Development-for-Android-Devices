package com.romellbolton.fragmentsapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by romellbolton on 3/21/18.
 */

// Have the Fragment class extend Fragment class
public class FragmentOne extends Fragment {

    // Override Fragment's onCreateView() method
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for FragmentOne in the Fragment Container
        return inflater.inflate(
                R.layout.fragment_one, container, false);
    }
}
