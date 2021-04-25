package com.regadera.regapasswordmanagerfoss.AppData.repository


import androidx.lifecycle.LiveData
import com.regadera.regapasswordmanagerfoss.AppData.data.AppDaoInterface
import com.regadera.regapasswordmanagerfoss.AppData.model.App

class AppRepository (private val appDao : AppDaoInterface) {

    val readData: LiveData<List<App>> = appDao.readAppData()

    suspend fun addApp (app: App){
        appDao.addApp(app)
    }

    suspend fun updateApp (app: App){
        appDao.updateApp(app)
    }
}