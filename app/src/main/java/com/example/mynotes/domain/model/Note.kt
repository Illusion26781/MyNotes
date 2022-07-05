package com.example.mynotes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Note(
    var title: String? = null,
    var content: String? = null,
    @PrimaryKey(autoGenerate = true)  val id: Int? = null
) : Serializable
