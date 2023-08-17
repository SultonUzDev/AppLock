package com.example.applockapp.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.applockapp.data.db.App
import com.example.applockapp.data.db.AppDatabase
import com.example.applockapp.data.repository.AppRepository
import com.example.applockapp.helper.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(app: Application) : AndroidViewModel(app) {
    private val appRepository: AppRepository


    init {
        val dao = AppDatabase.getInstance(app).appDao()
        appRepository = AppRepository(dao)
    }

    private val _app = MutableLiveData<Resource<List<App>>>()
    val apps: LiveData<Resource<List<App>>> = _app


    fun getApps() {
        viewModelScope.launch {
            _app.value = Resource.Loading(data = null)
            try {
                val mApps = appRepository.getApps()
                _app.value = Resource.Success(data = mApps)
            } catch (e: Exception) {
                _app.value =
                    Resource.Error(data = null, message = "Get apps has error ${e.message} ")
            }


        }
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