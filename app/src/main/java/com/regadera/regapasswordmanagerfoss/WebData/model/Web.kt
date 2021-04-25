package com.regadera.regapasswordmanagerfoss.WebData.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "web_table")
data class Web (
        @PrimaryKey(autoGenerate = true)
    val id : Int,
        val userName: String,
        val mainPassword: String,
        val website : String
    ) : Parcelable