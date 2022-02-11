package com.example.fakeapplication_snapchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapplication_snapchat.data.BVideos

class DescubirAdapter (
         private val mDataSet: ArrayList<BVideos>
    )
    : RecyclerView.Adapter<DescubirAdapter.DescubirViewHolder>() {

    // En este ejemplo cada elemento consta solo de un nombre
    inner class DescubirViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

    // El layout manager invoca este método para renderizar cada elemento
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescubirViewHolder {
        return DescubirViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_descubir, parent, false))
    }

    // Este método asigna valores para cada elemento de la lista
    override fun onBindViewHolder(holder: DescubirViewHolder, position: Int) {
        val videos = mDataSet[position]
    }

    // Cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejm, si implementamos filtros o búsquedas)
    override fun getItemCount() = mDataSet.size
}