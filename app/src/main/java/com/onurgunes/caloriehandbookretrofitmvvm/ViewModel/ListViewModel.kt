package com.onurgunes.caloriehandbookretrofitmvvm.ViewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.onurgunes.caloriehandbookretrofitmvvm.Model.Besin
import com.onurgunes.caloriehandbookretrofitmvvm.RoomDB.BesinDataBase
import com.onurgunes.caloriehandbookretrofitmvvm.Service.BesinAPI
import com.onurgunes.caloriehandbookretrofitmvvm.Service.BesinAPIService

import com.onurgunes.caloriehandbookretrofitmvvm.SharedPreferences.PrivateSharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val besinApiService = BesinAPIService()

    private val sharedPreferences = PrivateSharedPreferences(getApplication())

    val besinler = MutableLiveData<List<Besin>>()
    val besinYukleniyor = MutableLiveData<Boolean>()
    val besinHataMesaji = MutableLiveData<Boolean>()


    private val timeUpdate = 10 * 60 * 1000 * 1000 * 1000L

     fun refreshData () {
        val timeSaver = sharedPreferences.timeGet()
        if (timeSaver != null && timeSaver != 0L && System.nanoTime() - timeSaver < timeUpdate ){
         getDataFromRoom()
        } else {
            getDataFromInternet()
        }
    }

    fun refreshDataFromInternet () {

        getDataFromInternet()
    }



    private fun getDataFromInternet() {
        besinYukleniyor.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val besinler = besinApiService.getBesinData()

            withContext(Dispatchers.Main) {
                besinYukleniyor.value = false

                saveToRoom(besinler)
                Toast.makeText(getApplication(), "Loaded by Internet", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun getDataFromRoom () {
        besinYukleniyor.value = true

        viewModelScope.launch {
            val besinListesi = BesinDataBase(getApplication()).besinDAO().getAllBesin()
            showNutrient(besinListesi)
            Toast.makeText(getApplication(),"Room'dan Aldik",Toast.LENGTH_LONG).show()
        }
    }



    private fun showNutrient(besinlerList: List<Besin>) {
        // Check if the list is not empty before updating
        if (besinlerList.isNotEmpty()) {
            besinler.value = besinlerList // Update the list of nutrients
            besinHataMesaji.value = false  // Clear any error messages
        } else {
            besinHataMesaji.value = true   // Optionally set an error if the list is empty
        }

        besinYukleniyor.value = false // Set loading state to false
    }


    private fun saveToRoom(besinlerList: List<Besin>) {

        viewModelScope.launch {

            val dao = BesinDataBase(getApplication()).besinDAO()
            dao.deleteBesin()
            val uuidList = dao.insertBesin(*besinlerList.toTypedArray())

            var i = 0
            while (i < besinlerList.size) {
                besinlerList[i].uuid = uuidList[i].toInt()
                i = i + 1
            }

            showNutrient(besinlerList)


        }

        sharedPreferences.timeSAVER(System.nanoTime())


    }
}



