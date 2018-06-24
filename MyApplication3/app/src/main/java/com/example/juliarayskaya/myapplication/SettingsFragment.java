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

        Preference excludeFilter = getPreferenceScreen().getPreference(1);
        String valueFilter = sharedPreferences.getString(excludeFilter.getKey(), getString(R.string.pref_default_exclude_filter));
        excludeFilter.setSummary(valueFilter);

        Preference searchWords = getPreferenceScreen().getPreference(0);
        String valueSearchWords = sharedPreferences.getString(searchWords.getKey(), getString(R.string.pref_default_search_words));
        searchWords.setSummary(valueSearchWords);

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference excludeFilter = findPreference(key);
        if (excludeFilter != null){
            String valueExclude = sharedPreferences.getString(key,getString(R.string.pref_default_exclude_filter));
            excludeFilter.setSummary(valueExclude);
        }

        Preference searchWords = findPreference(key);
        if (searchWords != null) {
            String valueSearchWords = sharedPreferences.getString(key, getString(R.string.pref_default_search_words));
            searchWords.setSummary(valueSearchWords);
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