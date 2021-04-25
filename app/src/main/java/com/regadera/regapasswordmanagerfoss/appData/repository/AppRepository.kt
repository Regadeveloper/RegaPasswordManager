package com.regadera.regapasswordmanagerfoss.appData.repository


import androidx.lifecycle.LiveData
import com.regadera.regapasswordmanagerfoss.appData.data.AppDaoInterface
import com.regadera.regapasswordmanagerfoss.appData.model.App

class AppRepository (private val appDao : AppDaoInterface) {

    val readData: LiveData<List<App>> = appDao.readAppData()

    suspend fun addApp (app: App){
        appDao.addApp(app)
    }

    suspend fun updateApp (app: App){
        appDao.updateApp(app)
    }
}