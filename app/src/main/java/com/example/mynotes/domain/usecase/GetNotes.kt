package com.example.mynotes.domain.usecase

import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow

class GetNotes(private val repository: NotesRepository) {

    operator fun invoke(): Flow<List<Note>>
    {
        return repository.getNotes()
    }
}