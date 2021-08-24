package org.techtown.mvpproject.presenter

import android.util.Log
import org.json.JSONObject
import org.techtown.mvpproject.Contract
import org.techtown.mvpproject.model.InfoDataSource
import org.techtown.mvpproject.model.InfoRepository

class Presenter(val view: Contract.View,
                val repository: InfoRepository) : Contract.Presenter {

    override fun initInfo() {
        repository.getInfo(object : InfoDataSource.LoadInfoCallback{
            override fun onInfoLoaded(info: JSONObject) {
                Log.d("MVP","onInfoLoaded")
               view.showInfo(info)
            }

            override fun onDataNotAvailable() {
                //Do nothing.
            }

        })
    }

    override fun setInfo(info: JSONObject) {
        view.showInfo(info)
    }

    override fun saveInfo(info: JSONObject) {
      repository.saveInfo(info)
    }
}