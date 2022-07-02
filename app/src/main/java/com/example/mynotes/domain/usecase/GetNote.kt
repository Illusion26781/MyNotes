package com.example.mynotes.domain.usecase

import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.repository.NotesRepository

class GetNote(private val repository: NotesRepository)
{
    suspend operator fun invoke(noteId: Int): Note?
    {
        return repository.getNoteById(noteId)
    }
}