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

    companion object {
        var isRunService = false
        var prevPackageName = "com.example.applockapp"
        var currentPackageName = "com.example.applockapp"
        var isCurrentOpenToUsingPackage = false
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        isRunService = true
        appDatabase = AppDatabase.getInstance(this)
        appDao = appDatabase.appDao()

    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event != null) {
            if (event.packageName != null && event.packageName != prevPackageName) {
                currentPackageName = prevPackageName
                prevPackageName = event.packageName.toString()

                val app = appDao.isAppLocked(event.packageName.toString())
                Log.d("mlog", "currentPackageName: $currentPackageName");
                if (app != null) {
                    if (app.locked) {
                        Log.d("mlog", "App is  locked: ");
                        val intent = Intent(this, LockScreenActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)

                    }


                } else {
                    Log.d("mlog", "App does not exist: ");
                }
            }
        } else {
            Log.d("mlog", "Current event is null");
        }

    }

    override fun onInterrupt() {
        Log.d("mlog", "onInterrupt : works");
    }

}