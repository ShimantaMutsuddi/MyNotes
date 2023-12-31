package com.chutyrooms.mynotes.service.network.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.chutyrooms.mynotes.service.model.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note:Note)

    @Delete
    suspend fun deleteNote(note:Note)

    @Query("SELECT * FROM my_notes ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>
    @Query("SELECT * FROM my_notes WHERE noteTitle LIKE :query OR noteBody LIKE :query")
    fun searchNote(query: String?):LiveData<List<Note>>

}