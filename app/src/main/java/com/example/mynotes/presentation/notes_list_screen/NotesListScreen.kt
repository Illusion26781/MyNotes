package com.example.mynotes.presentation.notes_list_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mynotes.presentation.destinations.NoteScreenDestination
import com.example.mynotes.presentation.notes_list_screen.components.NotesScaffold
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun NotesListScreen(
    navigator: DestinationsNavigator,
    viewModel: NotesListScreenViewModel = hiltViewModel()
)
{
    val state = viewModel.state.value

    NotesScaffold(notes = state.notes)
    {
        when(it)
        {
            is NotesEvents.AddNote -> {navigator.navigate(NoteScreenDestination())}
            is NotesEvents.EditNote -> {
                navigator.navigate(NoteScreenDestination(it.note))
            }
            else -> viewModel.onEvent(it)
        }
    }
}