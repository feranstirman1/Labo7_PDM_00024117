package com.feranstirman.lab7.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.feranstirman.lab7.Database.GithubDatabase
import com.feranstirman.lab7.Database.GithubRepo
import com.feranstirman.lab7.Repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubViewModel(app:Application):AndroidViewModel(app) {

    private val repository:GithubRepository

    init{
        val repoDao = GithubDatabase.getInstance(app).repoDao()
        repository = GithubRepository(repoDao)
    }

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()

    fun nuke() = repository.nuke()

}