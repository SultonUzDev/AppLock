package com.example.applockapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface AppDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertApp(vararg apps: App)

    @Update
    suspend fun updateAppStatus(app: App)

    @Query(value = "select * from apps order by appName")
    fun getApps(): LiveData<List<App>>

    @Query(value = "select * from apps  WHERE packageName LIKE :currentPackageName")
    fun isAppLocked(currentPackageName: String): App?
}