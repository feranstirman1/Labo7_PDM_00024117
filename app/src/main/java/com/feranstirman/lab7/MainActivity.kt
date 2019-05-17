package com.feranstirman.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.feranstirman.lab7.Database.GithubRepo
import com.feranstirman.lab7.ViewModels.GithubViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GithubViewModel::class.java)

        btn_main.setOnClickListener {
            val name = et_main.text.toString()
            tv_main.text = name
            if(name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }
        viewModel.getAll().observe(this, Observer { repos->
            Log.d("LISTA DE REPOS","______________________")
            for(repo in repos){
                Log.d("LISTA DE REPOS",repo.name)
            }

        })



    }
}
