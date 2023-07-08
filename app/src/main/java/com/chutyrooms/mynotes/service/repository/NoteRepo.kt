package com.chutyrooms.mynotes.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chutyrooms.mynotes.service.model.Note
import com.chutyrooms.mynotes.service.network.db.NoteDatabase

class NoteRepo(private val db: NoteDatabase) {


    suspend fun addNote(note: Note)=db.getNoteDao().addNote(note)

    suspend fun updateNote(note: Note)=db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note)=db.getNoteDao().deleteNote(note)

    fun getAllNotes():LiveData<List<Note>>{
        return db.getNoteDao().getAllNotes()
    }

    fun searchNote(query: String?): LiveData<List<Note>> {
        return db.getNoteDao().searchNote(query)
    }


}