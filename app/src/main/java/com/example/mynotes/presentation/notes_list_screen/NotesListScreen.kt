package com.example.mynotes.presentation.notes_list_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mynotes.presentation.notes_list_screen.components.NotesScaffold

@Composable
fun NotesListScreen(
    navController: NavController,
    viewModel: NotesListScreenViewModel = hiltViewModel()
)
{
    val state = viewModel.state.value

    NotesScaffold(notes = state.notes)
    {
        when(it)
        {
            is NotesEvents.AddNote -> navController.navigate("note")
            is NotesEvents.EditNote -> {
                navController.navigate("note?noteId=${it.note.id!!}")
            }
            else -> viewModel.onEvent(it)
        }
    }
}