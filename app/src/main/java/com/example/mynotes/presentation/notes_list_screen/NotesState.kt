package com.example.mynotes.presentation.notes_list_screen

import com.example.mynotes.domain.model.Note

data class NotesState(val notes: List<Note> = emptyList())
