package com.onurgunes.caloriehandbookretrofitmvvm.RoomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.onurgunes.caloriehandbookretrofitmvvm.Model.Besin

@Dao
interface BesinDAO {


    @Insert
    suspend fun insertBesin (vararg  besin: Besin ) : List <Long>

    @Query ("SELECT * FROM besin")
    suspend fun getAllBesin () : List<Besin>

    @Query ("SELECT * FROM besin WHERE uuid = :besinId")
    suspend fun getBesin(besinId : Int) : List<Besin>


    @Query ("DELETE FROM besin")
    suspend fun deleteBesin ()


}



