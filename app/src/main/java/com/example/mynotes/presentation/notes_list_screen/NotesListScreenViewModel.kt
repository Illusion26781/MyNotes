package com.example.mynotes.presentation.notes_list_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotes.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesListScreenViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel()
{


    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    init {
        getNotes()
    }

    fun onEvent(event: NotesEvents)
    {
        when(event)
        {
            is NotesEvents.RemoveNote ->
            {
                viewModelScope.launch{ useCases.removeNote(event.note) }
                getNotes()
            }
            else -> {}
        }
    }

    private fun getNotes()
    {
        useCases.getNotes()
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                )
            }
            .launchIn(viewModelScope)
    }
}