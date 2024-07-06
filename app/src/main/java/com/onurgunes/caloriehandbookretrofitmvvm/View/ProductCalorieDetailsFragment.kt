package com.onurgunes.caloriehandbookretrofitmvvm.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.onurgunes.caloriehandbookretrofitmvvm.R
import com.onurgunes.caloriehandbookretrofitmvvm.databinding.FragmentProductCalorieDetailsBinding


class ProductCalorieDetailsFragment : Fragment() {
    private var _binding: FragmentProductCalorieDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductCalorieDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}