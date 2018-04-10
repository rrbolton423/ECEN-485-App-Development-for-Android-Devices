package com.romellbolton.preferencesscreenapp;

import android.os.Bundle;
import android.preference.PreferenceActivity;

// Have the preference activity extend "PreferenceActivity"
public class PrefsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the PreferenceActivity layout
        addPreferencesFromResource(R.xml.prefs);
    }
}
