package com.silver.lessononeexercises.contact

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.silver.lessononeexercises.R
import com.silver.lessononeexercises.adapters.ContactAdapter
import com.silver.lessononeexercises.model.ContactEntity
import kotlinx.android.synthetic.main.fragment_box_two.*
import java.lang.RuntimeException

class BoxTwoFragment : Fragment() {

    private var listener: OnContactListener? = null
    private var contacts = mutableListOf<ContactEntity>()

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_box_two, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnContactListener){
            listener = context
        }else{
            throw RuntimeException("$context must implement OnContactListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setData()
        context?.let {
            lv_contact.adapter = ContactAdapter(it, contacts)
        }

        lv_contact.setOnItemClickListener{ _,_,i,_ ->
            listener?.let {
                it.selectedItemContact(contacts[i])
            }
        }
        listener?.renderFirst(first())
    }

    private fun setData(){
        val contact1 = ContactEntity(1, "Pedro Salas",R.mipmap.men_1,"999999999","pedro.salas@gmail.com", "https://.....")
        val contact2 = ContactEntity(2, "Sergio Salazar",R.mipmap.men_2,"999999999","sergio" +
                ".salazar@gmail.com", "https://.....")
        val contact3 = ContactEntity(3, "Juan Dominguez",R.mipmap.men_3,"999999999","juan" +
                ".dominguez@gmail.com", "https://.....")
        val contact4 = ContactEntity(4, "Liz Mendez",R.mipmap.woman_1,"999999999","liz" +
                ".mendez@gmail.com", "https://.....")
        val contact5 = ContactEntity(5, "Amanda Ramos",R.mipmap.woman_2,"999999999","amanda" +
                ".ramos@gmail.com", "https://.....")
        val contact6 = ContactEntity(6, "Yanela Perez",R.mipmap.woman_3,"999999999","yanele" +
                ".perez@gmail.com", "https://.....")
        val contact7 = ContactEntity(7, "Luis Felipe",R.mipmap.men_4,"999999999","luis" +
                ".felipe@gmail.com", "https://.....")
        contacts.add(contact1)
        contacts.add(contact2)
        contacts.add(contact3)
        contacts.add(contact4)
        contacts.add(contact5)
        contacts.add(contact6)
        contacts.add(contact7)
    }

    private fun first(): ContactEntity? {
        contacts?.let {
            return it[0]
        }
        return null
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
