package org.techtown.mvpproject.model

import org.json.JSONObject

interface InfoDataSource {

    interface LoadInfoCallback{
        fun onInfoLoaded(info: JSONObject)
        fun onDataNotAvailable()
    }

    fun getInfo(callback: LoadInfoCallback)

    fun saveInfo(info: JSONObject)
}