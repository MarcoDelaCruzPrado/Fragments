package com.silver.lessononeexercises.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.silver.lessononeexercises.R
import com.silver.lessononeexercises.model.ContactEntity

class ExerciseTwoActivity : AppCompatActivity(), OnContactListener {

    private lateinit var contactsFragment: BoxTwoFragment
    private lateinit var contactDetilFragment: DetailTwoFragment
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_two)

        fragmentManager = supportFragmentManager
        contactsFragment = fragmentManager.findFragmentById(R.id.fg_contacts) as BoxTwoFragment
        contactDetilFragment = fragmentManager.findFragmentById(R.id.fg_detail_contact) as DetailTwoFragment
    }

    override fun onSendMessage(msg: String) {
    }

    override fun selectedItemContact(contactEntity: ContactEntity) {
        contactDetilFragment.renderContact(contactEntity)
    }

    override fun renderFirst(contactEntity: ContactEntity?) {
        contactEntity?.let {
            selectedItemContact(it)
        }
    }


}
