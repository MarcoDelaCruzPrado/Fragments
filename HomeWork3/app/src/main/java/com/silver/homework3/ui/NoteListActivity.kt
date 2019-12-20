package com.silver.homework3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.silver.homework3.R
import com.silver.homework3.model.NoteEntity
import com.silver.homework3.ui.adapter.NoteAdapter
import com.silver.homework3.ui.adapter.RecycleTouchListener
import com.silver.homework3.ui.adapter.RecyclerClickListener
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    private lateinit var mDatabase: DatabaseReference
    private var noteAdapter: NoteAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        setUpFireBaseDb()
        ui()
    }

    private fun ui(){
        recyclerViewNotes.layoutManager = LinearLayoutManager(this)
        recyclerViewNotes.setHasFixedSize(true)
        loadNotes()

        //  events
        btnAddNote.setOnClickListener {
            goToAddNote()
        }

        recyclerViewNotes.addOnItemTouchListener(
            RecycleTouchListener(this, recyclerViewNotes,
                object: RecyclerClickListener {
                    override fun onClick(view: View, position: Int) {
                        val note: NoteEntity? = noteAdapter?.getItem(position)
                        note?.let {
                            goToNote(note)
                        }
                    }

                    override fun onLongClick(view: View, position: Int) {

                    }
                })
        )
    }

    private fun setUpFireBaseDb() {
        mDatabase = FirebaseDatabase.getInstance().reference
    }

    private fun loadNotes() {
        val notesQuery:Query = mDatabase.child("notes")
        val options = FirebaseRecyclerOptions.Builder<NoteEntity>()
            .setQuery(notesQuery, NoteEntity::class.java)
            .build()

        noteAdapter = NoteAdapter(options)
        recyclerViewNotes.adapter = noteAdapter
    }

    override fun onStart() {
        super.onStart()
        noteAdapter?.startListening()
    }

    override fun onStop() {
        super.onStop()
        noteAdapter?.stopListening()
    }

    private fun goToAddNote(){
        startActivity(Intent(this, AddNoteActivity::class.java))
    }

    private fun goToNote(note:NoteEntity){
        val bundle = Bundle()
        bundle.putSerializable("NOTE",note)
        val intent = Intent(this, EditNoteActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
