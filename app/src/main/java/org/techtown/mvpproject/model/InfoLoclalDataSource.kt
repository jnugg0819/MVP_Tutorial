package org.techtown.mvpproject.model

import android.content.Context
import org.json.JSONObject
import org.techtown.mvpproject.model.InfoDataSource

class InfoLoclalDataSource(context:Context) : InfoDataSource {

    private val sharedPreferences = context.getSharedPreferences("info", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    override fun getInfo(callback: InfoDataSource.LoadInfoCallback) {
        var info = sharedPreferences.getString("info",null)
        if(info !=null){
            callback.onInfoLoaded(JSONObject(info))
        } else {
            callback.onDataNotAvailable()
        }
    }

    override fun saveInfo(info: JSONObject) {
        editor.putString("info",info.toString())
        editor.commit()
    }
}