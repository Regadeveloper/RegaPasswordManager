package com.regadera.regapasswordmanagerfoss.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.regadera.regapasswordmanagerfoss.userData.model.User
import com.regadera.regapasswordmanagerfoss.webData.model.Web

data class UserWithWebs (
        @Embedded val user : User,
        @Relation(
                parentColumn = "userName",
                entityColumn =  "ownerUser"
        )
        val webs: List<Web>
)