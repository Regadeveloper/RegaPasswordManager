package com.regadera.regapasswordmanagerfoss.WebData.repository


import androidx.lifecycle.LiveData
import com.regadera.regapasswordmanagerfoss.WebData.data.WebDaoInterface
import com.regadera.regapasswordmanagerfoss.WebData.model.Web

class WebRepository (private val webDao : WebDaoInterface) {

    val readData: LiveData<List<Web>> = webDao.readWebData()

    suspend fun addWeb (web: Web){
        webDao.addWeb(web)
    }

    suspend fun updateWeb (web: Web){
        webDao.updateWeb(web)
    }
}