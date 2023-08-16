package com.example.applockapp.data.preference

import android.content.Context
import androidx.preference.PreferenceManager
import com.example.applockapp.helper.Constants

class AppPreferences(
    private val context: Context,
) {

    private val preferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(context)
    }
    var password by PreferencesDelegate<String>(preferences, Constants.PASSWORD, "")
}