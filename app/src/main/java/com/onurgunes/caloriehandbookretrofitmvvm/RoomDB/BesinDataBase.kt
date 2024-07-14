package com.onurgunes.caloriehandbookretrofitmvvm.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.onurgunes.caloriehandbookretrofitmvvm.Model.Besin
import kotlin.concurrent.Volatile

@Database (entities =[ Besin::class], version = 1)

 abstract  class BesinDataBase : RoomDatabase() {
    abstract fun BesinDAO( ) : BesinDAO

}

/*
 @Volatile
         private var instance : BesinDataBase? = null
         private val  lock = Any()

         operator  fun invoke (context: Context ) = instance ?: synchronized(lock) {
             instance ?: databaseOlustur(context).also {
                 instance = it
             }

         }

          private fun databaseOlustur(context: Context)  = Room.databaseBuilder(context.applicationContext,
              BesinDataBase::class.java,"BesinDataBase").build()
 */