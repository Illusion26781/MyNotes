package com.example.mynotes.presentation.notes_list_screen

import com.example.mynotes.domain.model.Note

sealed class NotesEvents
{
    object AddNote : NotesEvents()
    data class RemoveNote(val note: Note): NotesEvents()
    data class EditNote(val note: Note): NotesEvents()
}
