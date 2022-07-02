package com.example.mynotes.domain.usecase

data class UseCases(
    val addNote: AddNote,
    val removeNote: RemoveNote,
    val getNotes: GetNotes,
    val getNote: GetNote
)