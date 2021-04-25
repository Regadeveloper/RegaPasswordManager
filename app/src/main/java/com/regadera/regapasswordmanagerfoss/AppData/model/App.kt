package com.regadera.regapasswordmanagerfoss.AppData.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "app_table")
data class App (
        @PrimaryKey(autoGenerate = true)
    val id : Int,
        val userName: String,
        val mainPassword: String,
        val appName : String
    ) : Parcelable