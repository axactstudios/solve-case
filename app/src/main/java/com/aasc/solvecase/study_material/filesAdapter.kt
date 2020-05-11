package com.aasc.solvecase.study_material

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aasc.solvecase.R
import com.aasc.solvecase.recyclerViewAdapter

class filesAdapter (val filesList: ArrayList<filesDetailsModel>, var clickListener : onFilesClickListenerListener) :
        RecyclerView.Adapter<filesAdapter.ViewHolder> () {

    class ViewHolder(studyitem : View) : RecyclerView.ViewHolder (studyitem) {
        var filename : TextView = studyitem.findViewById(R.id.tvFilename)
        var fileurl : TextView = studyitem.findViewById(R.id.tvFileurl)

        fun initialize(studyitem: filesDetailsModel,action: onFilesClickListenerListener) {
            filename.text = studyitem.filename
            fileurl.text = studyitem.fileurl

            itemView.setOnClickListener {
                action.onItemClick(studyitem,adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): filesAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.studyitem,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filesList.size
    }

    override fun onBindViewHolder(holder: filesAdapter.ViewHolder, position: Int) {
        //var files : filesDetailsModel = filesList[position]
        //holder.filename.text = filename.title
        holder.initialize(filesList.get(position),clickListener)
    }
}

interface onFilesClickListenerListener {
    fun onItemClick(item: filesDetailsModel, position: Int)
}