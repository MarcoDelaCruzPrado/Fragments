package com.silver.homework3.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.silver.homework3.R

class NoteViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val ivNote = view.findViewById<ImageView>(R.id.iv_note)
    val tvName = view.findViewById<TextView>(R.id.tv_name)
}