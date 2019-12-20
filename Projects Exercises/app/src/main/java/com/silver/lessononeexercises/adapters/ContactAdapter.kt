package com.silver.lessononeexercises.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.silver.lessononeexercises.R
import com.silver.lessononeexercises.model.ContactEntity

class ContactAdapter(private val context: Context, private val contacts: List<ContactEntity>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val container = inflater.inflate(R.layout.card_contact, null)
        val imgContact = container.findViewById<ImageView>(R.id.iv_contact)
        val tvName = container.findViewById<TextView>(R.id.tv_name)

        // Extraer la entidad
        val contactEntity = contacts[position]

        // Asociar la entidad con el XML
        tvName.text = contactEntity.NameComplete
        imgContact.setImageResource(contactEntity.Image)

        return container
    }

    override fun getItem(position: Int): Any = contacts[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = contacts.count()
}

