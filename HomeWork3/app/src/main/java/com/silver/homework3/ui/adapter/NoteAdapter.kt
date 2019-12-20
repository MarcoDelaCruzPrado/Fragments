package com.silver.homework3.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.silver.homework3.R
import com.silver.homework3.model.NoteEntity

class NoteAdapter(options:FirebaseRecyclerOptions<NoteEntity>) : FirebaseRecyclerAdapter<NoteEntity, NoteViewHolder>(options){
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return NoteViewHolder(inflater.inflate(R.layout.card_note, viewGroup, false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int, model: NoteEntity) {
        holder.tvName.text = model.name

    }

}