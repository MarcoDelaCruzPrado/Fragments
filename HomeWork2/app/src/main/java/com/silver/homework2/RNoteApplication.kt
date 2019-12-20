package com.silver.homework2

import android.app.Application
import com.silver.homework2.storage.RNoteRepository

class RNoteApplication :Application() {

    private lateinit var repository: RNoteRepository

    override fun onCreate() {
        super.onCreate()

        repository=RNoteRepository(this)
    }

    fun getNoteRepository():RNoteRepository{
        return repository
    }
}