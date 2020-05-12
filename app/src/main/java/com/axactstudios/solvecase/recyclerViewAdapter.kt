package com.axactstudios.solvecase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class recyclerViewAdapter(val videolist: ArrayList<videoDetailsModel>, var clickListener: onVideoItemClickListener) :
    RecyclerView.Adapter<recyclerViewAdapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var title : TextView = item.findViewById(R.id.tvTitle)
        var videokey : TextView = item.findViewById(R.id.tvKey)

        fun initialize(item: videoDetailsModel,action: onVideoItemClickListener) {
            title.text = item.title
            videokey.text = item.videokey

            itemView.setOnClickListener {
                action.onItemClick(item,adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return videolist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //var video : videoDetailsModel = videolist[position]
        //holder.title.text = video.title
        holder.initialize(videolist.get(position),clickListener)
    }
}

interface onVideoItemClickListener {
    fun onItemClick(item: videoDetailsModel, position: Int)
}