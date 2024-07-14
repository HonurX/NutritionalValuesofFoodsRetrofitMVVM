package com.onurgunes.caloriehandbookretrofitmvvm.SharedPreferences

import android.content.Context
import android.content.SharedPreferences
import com.onurgunes.caloriehandbookretrofitmvvm.RoomDB.BesinDataBase
import java.sql.Time

class PrivateSharedPreferences {



    companion object {
        private  var sharedPreferences : SharedPreferences? = null
        private val TIME = "zaman"

        @Volatile
        private var instance : PrivateSharedPreferences? = null
        private val  lock = Any()

        operator  fun invoke (context: Context ) = instance ?: synchronized(lock) {
            instance ?: CreateSharedPreferences(context).also {
                instance = it
            }
        }

        private fun CreateSharedPreferences (context: Context) : PrivateSharedPreferences {
            sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
            return PrivateSharedPreferences()
        }

    }



    fun timeSAVER (zaman : Long)  {
        sharedPreferences?.edit()?.putLong(TIME,zaman)?.apply()

    }

    fun timeGet() = sharedPreferences?.getLong(TIME,0)


}
