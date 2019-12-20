package com.silver.homework2.storage

import androidx.room.*
import com.silver.homework2.RNoteEntity

@Dao
interface RNoteDao {

    @Query("SELECT * from tb_notes")
    fun notes(): List<RNoteEntity>

    @Query("select * from tb_notes where id = :id")
    fun noteById(id: Int): RNoteEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: RNoteEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOrReplaceNotes(vararg notes: RNoteEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note: RNoteEntity)

    @Delete
    fun deleteNote(note: RNoteEntity)

    @Query("DELETE from tb_notes")
    fun deleteAll()

}