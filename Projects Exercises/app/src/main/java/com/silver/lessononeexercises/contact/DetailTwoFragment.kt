package com.silver.lessononeexercises.contact

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.silver.lessononeexercises.R
import com.silver.lessononeexercises.model.ContactEntity
import kotlinx.android.synthetic.main.fragment_detail_two.*

class DetailTwoFragment : Fragment() {

    private var  listener: OnContactListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_two, container, false)
    }

    fun renderContact(contactEntity: ContactEntity){
        val name = contactEntity.NameComplete
        val phone = contactEntity.Phone
        val email = contactEntity.Email
        val webSite = contactEntity.WebSite

        tv_name_contact.text = name
        tv_phone.text = phone
        tv_email.text = email
        tv_website.text = webSite
        iv_contact.setImageResource(contactEntity.Image)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnContactListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnContactListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
