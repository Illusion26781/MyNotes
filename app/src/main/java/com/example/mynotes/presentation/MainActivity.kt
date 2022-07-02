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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            MyNotesTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "notesList" )
                {
                    composable(route = "notesList")
                    {
                        NotesListScreen(navController = navController)
                    }
                    composable(
                        route = "note?noteId={noteId}",
                        arguments = listOf(
                            navArgument("noteId"){
                                type = NavType.IntType
                                defaultValue=-1
                            }
                        )
                    )
                    {
                        NoteScreen(navController = navController)
                    }
                }
            }
        }
    }
}