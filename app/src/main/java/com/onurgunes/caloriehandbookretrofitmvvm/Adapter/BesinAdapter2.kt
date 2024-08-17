package com.onurgunes.caloriehandbookretrofitmvvm.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onurgunes.caloriehandbookretrofitmvvm.Model.Besin
import com.onurgunes.caloriehandbookretrofitmvvm.databinding.RecyclerRowBinding


class BesinAdapter2  (val besinList : ArrayList<Besin>) : RecyclerView.Adapter<BesinAdapter2.besinViewHolder>() {
    class besinViewHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): besinViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  besinViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return besinList.size
    }

    fun besinListesiniGuncelle (yeniBesinListesi : List<Besin>)  {
        besinList.clear()
        besinList.addAll(yeniBesinListesi)
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: besinViewHolder, position: Int) {
        holder.binding.isim.text = besinList[position].besinIsim
        holder.binding.kalori.text =besinList[position].besinKalori
    }
}