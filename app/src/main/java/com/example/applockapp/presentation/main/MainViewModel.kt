package com.example.applockapp.presentation.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.applockapp.data.db.App
import com.example.applockapp.data.db.AppDatabase
import com.example.applockapp.data.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(app: Application) : AndroidViewModel(app) {
    val apps: LiveData<List<App>>
    private val appRepository: AppRepository


    private val _isLocked = MutableLiveData<Boolean>()
    val isLocked: LiveData<Boolean> = _isLocked


    init {
        val dao = AppDatabase.getInstance(app).appDao()
        appRepository = AppRepository(dao)
        apps = appRepository.getApps()
    }

    fun insertApp(app: App) {
        viewModelScope.launch(Dispatchers.Main) {
            appRepository.insertAppsToDb(app)

        }
    }

    fun updateAppStatus(app: App) {
        viewModelScope.launch(Dispatchers.Main) {
            appRepository.updateAppStatus(app)
        }
    }



}