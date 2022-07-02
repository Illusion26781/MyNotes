package com.example.mynotes.domain.usecase

import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.repository.NotesRepository

class AddNote(private val repository: NotesRepository)
{
    suspend operator fun invoke(note: Note)
    {
        repository.insertNote(note)
    }

}