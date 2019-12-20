package com.silver.lessononeexercises.contact

import com.silver.lessononeexercises.model.ContactEntity

interface OnContactListener  {

    fun onSendMessage(msg: String)
    fun selectedItemContact(contactEntity: ContactEntity)
    fun renderFirst(contactEntity: ContactEntity?)
}