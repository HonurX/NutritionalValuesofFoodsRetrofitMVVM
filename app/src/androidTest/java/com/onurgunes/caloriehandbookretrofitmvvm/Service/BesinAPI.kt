package com.onurgunes.caloriehandbookretrofitmvvm.Model

import retrofit2.http.GET

interface BesinAPI {

    @GET("")
   suspend fun  getBesin() : List<Besin>





}