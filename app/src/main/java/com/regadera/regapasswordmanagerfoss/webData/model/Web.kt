package com.regadera.regapasswordmanagerfoss.webData.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "web_table")
data class Web (
        @PrimaryKey(autoGenerate = false)
        val userName: String,
        val mainPassword: String,
        val website : String,
        val ownerUser : String
    ) : Parcelable