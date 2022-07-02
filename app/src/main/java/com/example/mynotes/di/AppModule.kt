package com.example.mynotes.di

import android.app.Application
import androidx.room.Room
import com.example.mynotes.data.dao.NoteDatabase
import com.example.mynotes.data.repository.NotesRepositoryImpl
import com.example.mynotes.domain.repository.NotesRepository
import com.example.mynotes.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule
{
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase
    {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: NoteDatabase):NotesRepository
    {
        return NotesRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NotesRepository):UseCases
    {
        return UseCases(
            AddNote(repository),
            RemoveNote(repository),
            GetNotes(repository),
            GetNote(repository)
        )
    }
}