package com.example.applockapp.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apps")
data class App(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "packageName") val packageName: String?,
    @ColumnInfo(name = "appName") val appName: String?,
    @ColumnInfo(name = "lockStatus") val locked: Boolean = false
)
