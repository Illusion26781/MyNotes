package com.example.mynotes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mynotes.presentation.note_screen.NoteScreen
import com.example.mynotes.presentation.note_screen.NoteScreenViewModel
import com.example.mynotes.presentation.notes_list_screen.NotesListScreen
import com.example.mynotes.ui.theme.MyNotesTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            MyNotesTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}