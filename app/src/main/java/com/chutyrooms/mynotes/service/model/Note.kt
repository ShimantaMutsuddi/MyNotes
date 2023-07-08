package com.chutyrooms.mynotes.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val noteTitle: String,
    val noteBody: String
)
