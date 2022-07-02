package com.example.mynotes.presentation.note_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.mynotes.domain.model.Note

@Composable
fun AddEditNote(
    note:Note,
    onFinish :(Note?) -> Unit
)
{
    var noteTitle by rememberSaveable{ mutableStateOf(note.title?:"")}
    var noteContent by rememberSaveable{ mutableStateOf(note.content?:"")}

    LaunchedEffect(note)
    {
        noteTitle = note.title?:""
        noteContent = note.content?:""
    }

    Scaffold(
        topBar = {
            TopAppBar {
                IconButton(onClick = { onFinish(null) }) {
                    Icon(Icons.Filled.ArrowBack   , contentDescription = "Save Note")
                }
                TextField( value = noteTitle, onValueChange = { noteTitle = it },

                )
                IconButton(onClick = { onFinish(Note(noteTitle,noteContent)) }) {
                    Icon(Icons.Filled.Send   , contentDescription = "Save Note")
                }
            }
        }
    ) {

        TextField(value = noteContent, onValueChange = { noteContent = it },
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxSize()
        )

    }
}

@Preview
@Composable
fun AddEditNotePreview() 
{
    AddEditNote(note = Note("test", "this is a test\n" +
            "sadsadaswdsawds\n" +
            "awdsasdw\n" +
            "sawdsa\n" +
            "dwasad")
    ) {}
}