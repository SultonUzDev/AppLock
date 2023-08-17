package com.example.applockapp.data.repository

import androidx.lifecycle.LiveData
import com.example.applockapp.data.db.App
import com.example.applockapp.data.db.AppDao

class AppRepository(private val appDao: AppDao) {

    fun getApps(): List<App> = appDao.getApps()

    suspend fun insertAppsToDb(app: App) {
        appDao.insertApp(app)
    }

    suspend fun updateAppStatus(app: App) {
        appDao.updateAppStatus(app)
    }



}