package com.onurgunes.caloriehandbookretrofitmvvm.RoomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onurgunes.caloriehandbookretrofitmvvm.Model.Besin

@Database (entities =[ Besin::class], version = 1)

 abstract  class BesinDataBase : RoomDatabase() {
     abstract fun besinDao () : BesinDAO


}

