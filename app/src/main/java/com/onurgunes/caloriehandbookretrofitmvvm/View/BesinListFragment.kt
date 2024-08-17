package com.onurgunes.caloriehandbookretrofitmvvm.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onurgunes.caloriehandbookretrofitmvvm.Adapter.BesinAdapter2

import com.onurgunes.caloriehandbookretrofitmvvm.ViewModel.ListViewModel
import com.onurgunes.caloriehandbookretrofitmvvm.databinding.FragmentBesinListBinding

class BesinListFragment : Fragment() {
    private var _binding: FragmentBesinListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : ListViewModel

    private val besinAdapterListe =  BesinAdapter2(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBesinListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        viewModel.refreshDataFromInternet()
        viewModel.refreshData()
        binding.besinListRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.besinListRecycler.adapter = besinAdapterListe




        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.visibility = View.VISIBLE
            binding.besinListRecycler.visibility = View.GONE
            binding.besinHataMesaji.visibility = View.GONE

            viewModel.refreshDataFromInternet()
            binding.swipeRefreshLayout.isRefreshing = false
        }
        observeLiveData()


    }

    private  fun observeLiveData ( ) {

        viewModel.besinler.observe(viewLifecycleOwner) {
         besinAdapterListe.besinListesiniGuncelle(it)


            binding.besinListRecycler.visibility = View.VISIBLE



        }

        viewModel.besinYukleniyor.observe(viewLifecycleOwner) {
            if (it) {
                binding.swipeRefreshLayout.visibility = View.VISIBLE
                binding.besinYukleniyor.visibility = View.GONE
                binding.besinHataMesaji.visibility = View.GONE
            } else {
                binding.swipeRefreshLayout.visibility = View.GONE
            }

        }

        viewModel.besinHataMesaji.observe(viewLifecycleOwner){
            if (it) {
                binding.besinHataMesaji.visibility = View.VISIBLE
                binding.besinListRecycler.visibility = View.GONE
            } else {
                binding.besinHataMesaji.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}









