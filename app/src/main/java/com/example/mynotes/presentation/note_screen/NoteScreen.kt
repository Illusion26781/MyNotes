package com.example.mynotes.presentation.note_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import com.example.mynotes.domain.model.Note
import com.example.mynotes.presentation.note_screen.components.AddEditNote
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun NoteScreen(
    navigator: DestinationsNavigator,
    viewModel: NoteScreenViewModel = hiltViewModel(),
    note: Note = Note()
) {

    AddEditNote(note)
    {
        if (it != null) {
            viewModel.saveNote(it)
        }
        navigator.navigateUp()
    }
}