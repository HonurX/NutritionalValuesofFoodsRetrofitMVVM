package com.onurgunes.caloriehandbookretrofitmvvm.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.onurgunes.caloriehandbookretrofitmvvm.R
import com.onurgunes.caloriehandbookretrofitmvvm.View.Service.BesinAPI
import com.onurgunes.caloriehandbookretrofitmvvm.databinding.FragmentNutrientListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.create as create1

class NutrientListFragment : Fragment() {
    private var _binding: FragmentNutrientListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNutrientListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.refreshLayout.setOnRefreshListener {

        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BesinAPI::class.java)

        CoroutineScope(Dispatchers.IO).launch {

             val besinler = retrofit.getBesin()
            besinler.forEach {
                println(it.besinIsim)
            }
        }
            
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



