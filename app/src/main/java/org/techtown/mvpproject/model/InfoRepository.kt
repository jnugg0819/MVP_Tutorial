package org.techtown.mvpproject.model

import android.content.Context
import org.json.JSONObject
import org.techtown.mvpproject.model.InfoDataSource
import org.techtown.mvpproject.model.InfoLoclalDataSource

class InfoRepository(context: Context) : InfoDataSource {

    private val infoLocalDataSource = InfoLoclalDataSource(context)

    override fun getInfo(callback: InfoDataSource.LoadInfoCallback) {
        infoLocalDataSource.getInfo(callback)
    }

    override fun saveInfo(info: JSONObject) {
        infoLocalDataSource.saveInfo(info)
    }
}