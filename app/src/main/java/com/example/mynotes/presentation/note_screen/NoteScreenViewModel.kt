package com.example.mynotes.presentation.note_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.usecase.UseCases
import com.example.mynotes.presentation.navArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteScreenViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle

) :ViewModel()
{
    private val _state = mutableStateOf(Note())
    val state: State<Note> = _state

    init {

        _state.value = savedStateHandle.navArgs()
    }

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