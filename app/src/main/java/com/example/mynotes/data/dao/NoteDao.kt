package com.example.mynotes.data.dao

import androidx.room.*
import com.example.mynotes.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("select * from Note")
    fun getNotes(): Flow<List<Note>>

    @Query("select * from Note where id = :id")
    suspend fun getNoteById(id:Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}