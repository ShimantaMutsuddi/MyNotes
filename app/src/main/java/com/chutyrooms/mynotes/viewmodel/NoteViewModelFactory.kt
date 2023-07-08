package com.chutyrooms.mynotes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chutyrooms.mynotes.service.repository.NoteRepo

class NoteViewModelFactory(
    private val noteRepository: NoteRepo
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel( noteRepository) as T
    }
}