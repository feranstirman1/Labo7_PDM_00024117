package com.feranstirman.lab7.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.feranstirman.lab7.Database.GithubDao
import com.feranstirman.lab7.Database.GithubRepo

class GithubRepository(private val repoDao: GithubDao) {

    @WorkerThread
    suspend fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()

}