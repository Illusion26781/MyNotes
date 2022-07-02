package com.example.mynotes.presentation.note_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import com.example.mynotes.domain.model.Note
import com.example.mynotes.presentation.note_screen.components.AddEditNote

@Composable
fun NoteScreen(
    navController: NavController,
    viewModel: NoteScreenViewModel = hiltViewModel(),
) {

    val note = viewModel.state.value
    AddEditNote(note)
    {
        if (it != null) {
            viewModel.saveNote(it)
        }
        navController.navigateUp()
    }
}