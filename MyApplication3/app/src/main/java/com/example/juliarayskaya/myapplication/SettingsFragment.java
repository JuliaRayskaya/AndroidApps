package com.example.juliarayskaya.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat
        implements SharedPreferences.OnSharedPreferenceChangeListener {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        addPreferencesFromResource(R.xml.preference);

        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();

        Preference excludeFilter = getPreferenceScreen().getPreference(0);
        String valueFilter = sharedPreferences.getString(excludeFilter.getKey(), getString(R.string.pref_default_exclude_filter));
        excludeFilter.setSummary(valueFilter);

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference workTime = findPreference(key);
        if (workTime != null){
            String valueWorkTime = sharedPreferences.getString(key,getString(R.string.pref_default_exclude_filter));
            workTime.setSummary(valueWorkTime);
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}