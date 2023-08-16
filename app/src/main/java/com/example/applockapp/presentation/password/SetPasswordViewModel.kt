package com.example.applockapp.presentation.password

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.applockapp.data.preference.AppPreferences
import kotlinx.coroutines.launch

class SetPasswordViewModel(app: Application) : AndroidViewModel(application = app) {

    val appPreferences: AppPreferences

    init {
        appPreferences = AppPreferences(app)
    }

    fun setPassword(password: String) {
        viewModelScope.launch {
            appPreferences.password = password
        }
    }
}