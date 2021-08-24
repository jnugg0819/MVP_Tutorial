package org.techtown.mvpproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONObject
import org.techtown.mvpproject.databinding.ActivityMainBinding
import org.techtown.mvpproject.model.InfoRepository
import org.techtown.mvpproject.presenter.Presenter

class MainActivity : AppCompatActivity() , Contract.View{

    private lateinit var presenter: Presenter
    private lateinit var repository: InfoRepository

    //viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewBinding setting.
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        repository = InfoRepository(this)
        presenter = Presenter(this, repository)

        presenter.initInfo()
        initButtonListener()

    }

    override fun showInfo(info: JSONObject) {
        binding.nameOutput.text = info.getString("name")
        binding.emailOutput.text = info.getString("email")
    }

    private fun initButtonListener(){
        binding.buttonSubmit.setOnClickListener {

            var info = JSONObject()
            info.put("name", binding.nameInput.text.toString())
            info.put("email", binding.emailInput.text.toString())

            binding.nameInput.text.clear()
            binding.emailInput.text.clear()

            presenter.setInfo(info)
            presenter.saveInfo(info)
        }
    }
}