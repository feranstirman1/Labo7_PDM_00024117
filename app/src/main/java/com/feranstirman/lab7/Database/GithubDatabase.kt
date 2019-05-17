package com.feranstirman.lab7.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GithubRepo::class],version = 1,exportSchema = false)
public abstract class GithubDatabase:RoomDatabase() {
    abstract fun repoDao():GithubDao

    companion object {
        private var INSTANCE:GithubDatabase?=null

        fun getInstance(context:Context):GithubDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room
                    .databaseBuilder(context,GithubDatabase::class.java,"RepoDB")
                    .build()
                INSTANCE= instance
                return instance
            }
        }
    }
}