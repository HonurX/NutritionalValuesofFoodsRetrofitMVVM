package com.onurgunes.caloriehandbookretrofitmvvm.Model

import com.onurgunes.caloriehandbookretrofitmvvm.Service.BesinAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BesinAPIService
{


    private  val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BesinAPI::class.java)

   suspend fun getBesinData () : List<Besin> {
       return  retrofit.getBesin()
   }

}

