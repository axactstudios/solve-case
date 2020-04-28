package com.example.jiitsolutions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_layout.view.*

class FileAdapter(val context: Context,val fileName: List<FileName>) : RecyclerView.Adapter<FileAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
val view= LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
return fileName.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val file=fileName[position]
        holder.setData(file,position)
    }
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun setData(file:FileName?,pos:Int){
            itemView.fileName.text=file!!.fname
        }
    }
}