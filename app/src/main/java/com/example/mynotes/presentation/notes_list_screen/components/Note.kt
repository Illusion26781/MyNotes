package com.example.mynotes.presentation.notes_list_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynotes.domain.model.Note
import com.example.mynotes.presentation.notes_list_screen.NotesEvents

@Composable
fun Note(
    note: Note,
    onEvent: (NotesEvents) -> Unit
) {
    Box(
        Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .defaultMinSize(100.dp, 50.dp)
            .padding(20.dp)
            .clickable {
                onEvent(NotesEvents.EditNote(note))
            }
    )

    {
        Row{
            note.title?.let { Text(it) }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                onEvent(NotesEvents.RemoveNote(note))
            }) {
                Icon(Icons.Default.Delete, contentDescription = null)

            }
        }
    }
}

@Preview
@Composable
fun PreviewNote() {
    Column(){
        Note(Note(title = "It's ok")){}
        Spacer(Modifier.height(10.dp))
        Note(Note()){}
    }
}