package com.example.mynotes.presentation.note_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.usecase.UseCases
import com.example.mynotes.presentation.notes_list_screen.NotesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteScreenViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle

) :ViewModel()
{


    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if(noteId != -1) {
                viewModelScope.launch {
                    useCases.getNote(noteId)?.also { note ->
                        _state.value = note
                    }
                }
            }
        }
    }

    private val _state = mutableStateOf(Note())
    val state: State<Note> = _state

    fun saveNote(note:Note)
    {
        _state.value = state.value.copy(
            title = note.title,
            content = note.content
        )
        viewModelScope.launch {
            useCases.addNote(state.value)
        }
    }
}