package com.example.mynotes.presentation.notes_list_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynotes.domain.model.Note
import com.example.mynotes.presentation.notes_list_screen.NotesEvents
import com.example.mynotes.presentation.notes_list_screen.components.Note as NoteComp

@Composable
fun NotesScaffold(
    notes: List<Note>,
    onEvent: (NotesEvents)->Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
                 TopAppBar() {
                     Row{
                         Text("MyNote")
                     }
                 }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onEvent(NotesEvents.AddNote) },
                backgroundColor = MaterialTheme.colors.primary
            )
            {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add new note")

            }
        },
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        scaffoldState = scaffoldState,

    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        )
        {
            items(notes)
            {   note ->

                NoteComp(note = note, onEvent = onEvent)

                Spacer(modifier = Modifier.height(16.dp))

            }
        }
    }
}

@Preview
@Composable
fun NotesScaffoldPreview(

)
{
    val notes = listOf(
        Note(),
        Note("Testing"),
    ).toMutableStateList()

}