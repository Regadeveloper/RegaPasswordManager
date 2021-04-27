package com.regadera.regapasswordmanagerfoss.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.regadera.regapasswordmanagerfoss.appData.model.App
import com.regadera.regapasswordmanagerfoss.userData.model.User

data class UserWithApps (
    @Embedded val user : User,
    @Relation(
            parentColumn = "userName",
            entityColumn =  "ownerUser"
    )
    val apps: List<App>
)