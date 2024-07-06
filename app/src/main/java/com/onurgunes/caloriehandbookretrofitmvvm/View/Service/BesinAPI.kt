package com.onurgunes.caloriehandbookretrofitmvvm.View.Service

import com.onurgunes.caloriehandbookretrofitmvvm.View.Model.Besin
import retrofit2.http.GET

interface BesinAPI {
//GET, POST

    //https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    // BASE_URL -> https://raw.githubusercontent.com/
    // atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json
    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
     suspend fun  getBesin() : List<Besin>





}