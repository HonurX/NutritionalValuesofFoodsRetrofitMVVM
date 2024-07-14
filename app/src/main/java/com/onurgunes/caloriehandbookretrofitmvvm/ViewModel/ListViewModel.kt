package com.onurgunes.caloriehandbookretrofitmvvm.ViewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.onurgunes.caloriehandbookretrofitmvvm.Model.Besin
import com.onurgunes.caloriehandbookretrofitmvvm.Model.BesinAPIService

import com.onurgunes.caloriehandbookretrofitmvvm.SharedPreferences.PrivateSharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val besinApiService = BesinAPIService()

  private  val sharedPreferences = PrivateSharedPreferences(getApplication())

     val besinler = MutableLiveData<List<Besin>>()
    val besinYukleniyor = MutableLiveData<Boolean>()
    val besinHataMesaji = MutableLiveData<Boolean>()


    private fun getDataFromInternet () {
         besinYukleniyor.value = true
        viewModelScope.launch(Dispatchers.IO) {
           val besinlerList = besinApiService.getBesinData()

            withContext(Dispatchers.Main) {
                besinYukleniyor.value = false
            Toast.makeText(getApplication(),"Loaded by Internet", Toast.LENGTH_LONG).show()
            }

        }


    }


    private fun saveToRoom () {

        viewModelScope.launch {

        }


    }



}