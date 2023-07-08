package com.chutyrooms.mynotes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chutyrooms.mynotes.service.model.Note
import com.chutyrooms.mynotes.service.repository.NoteRepo
import kotlinx.coroutines.launch

class NoteViewModel(private val noteRepo: NoteRepo): ViewModel() {



    fun addNote(note: Note) = viewModelScope.launch {
        noteRepo.addNote(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRepo.deleteNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        noteRepo.updateNote(note)
    }

    fun getAllNotes():LiveData<List<Note>> = noteRepo.getAllNotes()

    fun searchNote(query: String?):LiveData<List<Note>> = noteRepo.searchNote(query)

}