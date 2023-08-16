package com.example.applockapp.service

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import com.example.applockapp.data.db.AppDao
import com.example.applockapp.data.db.AppDatabase
import com.example.applockapp.presentation.lock.LockScreenActivity

class AppLockAccessibilityService : AccessibilityService() {

    private lateinit var appDatabase: AppDatabase
    private lateinit var appDao: AppDao

    override fun onServiceConnected() {
        super.onServiceConnected()
        isRunService = true
        Log.d("mlog", "Service connected: ");
        appDatabase = AppDatabase.getInstance(this)
        appDao = appDatabase.appDao()

    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event != null) {
            Log.d("mlog", "Current event is: ${event.eventType}");
            if (event.packageName != null && event.packageName != prevPackageName) {
                currentPackageName = prevPackageName
                prevPackageName = event.packageName.toString()
                Log.d("mlog", "Current package is: $currentPackageName");
                val app = appDao.isAppLocked(event.packageName.toString())
                if (app.locked) {
                    Log.d("mlog", "${app.appName}: is locked");
                    val intent = Intent(applicationContext, LockScreenActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                }


            } else {
                Log.d("mlog", "Current event is null");
            }
        }

    }

    override fun onInterrupt() {

    }

    companion object {
        var isRunService = false
        var prevPackageName = "com.example.applockapp"
        var currentPackageName = "com.example.applockapp"
    }
}