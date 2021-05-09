package com.regadera.regapasswordmanagerfoss.webData.repository


import android.util.Log
import androidx.lifecycle.LiveData
import com.regadera.regapasswordmanagerfoss.globals.MyGlobals
import com.regadera.regapasswordmanagerfoss.relations.UserWithWebs
import com.regadera.regapasswordmanagerfoss.userData.model.User
import com.regadera.regapasswordmanagerfoss.webData.data.WebDaoInterface
import com.regadera.regapasswordmanagerfoss.webData.model.Web

class WebRepository (private val webDao : WebDaoInterface) {

    val readData: LiveData<List<Web>> = webDao.readWebData()
    val userWithWebs: LiveData<List<UserWithWebs?>> = webDao.getUserWithWebs(MyGlobals.currentUserName)


    suspend fun addWeb (web: Web){
        webDao.addWeb(web)
    }

    suspend fun updateWeb (web: Web){
        webDao.updateWeb(web)
    }

    suspend fun getUserWithWebs (ownerUser: String): LiveData<List<UserWithWebs?>> {
        Log.i("este tag","el user que le estoy pasando es $ownerUser")
        return webDao.getUserWithWebs(ownerUser)
    }
}