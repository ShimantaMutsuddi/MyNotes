package com.chutyrooms.mynotes.service.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable
@Parcelize
@Entity(tableName = "my_notes")

data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val noteTitle: String,
    val noteBody: String
): Parcelable
