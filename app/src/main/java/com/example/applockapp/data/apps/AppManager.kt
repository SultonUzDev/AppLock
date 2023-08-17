package com.example.applockapp.data.apps

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import com.example.applockapp.data.db.App
import com.example.applockapp.data.db.AppDatabase

class AppManager(private val context: Context) {


    private val appDatabase = AppDatabase.getInstance(context)

    @SuppressLint("NewApi", "QueryPermissionsNeeded")
    fun getInstalledApp(): List<App> {
        val flags = PackageManager.GET_META_DATA or PackageManager.GET_SHARED_LIBRARY_FILES

        val packages = context.packageManager.getInstalledPackages(
            PackageManager.PackageInfoFlags.of(flags.toLong())
        )
        val apps = ArrayList<App>()
        packages.forEachIndexed { index, packageInfo ->
            val app = App(
                id = index,
                packageName = packageInfo.applicationInfo.packageName,
                appName = packageInfo.applicationInfo.loadLabel(context.packageManager).toString(),
                locked = false
            )
            apps.add(app)
        }
        return apps
    }


}