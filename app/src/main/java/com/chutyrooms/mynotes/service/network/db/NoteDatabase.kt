package com.chutyrooms.mynotes.service.network.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chutyrooms.mynotes.service.model.Note


@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object{
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context:Context):NoteDatabase{
            if(INSTANCE==null){
                synchronized(this)
                {
                    INSTANCE= Room.databaseBuilder(context,NoteDatabase::class.java,"note_db").build()
                }

            }
            return INSTANCE!!
        }
    }

}