package com.onurgunes.caloriehandbookretrofitmvvm.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onurgunes.caloriehandbookretrofitmvvm.Model.Besin
import com.onurgunes.caloriehandbookretrofitmvvm.databinding.RecyclerRowBinding


class BesinAdapter2 (val besinList : ArrayList<Besin>)  : RecyclerView.Adapter<BesinAdapter2.BesinViewHolder> (){
    class BesinViewHolder (var binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
       var recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BesinViewHolder(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
        return besinList.size
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        holder.binding.isim.text = besinList[position].besinIsim
        holder.binding.kalori.text = besinList[position].besinKalori
    }


}