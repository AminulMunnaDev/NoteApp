package com.example.notetakingapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "note_table")
data class NoteModel(
    @PrimaryKey (autoGenerate = true)
    val id:Int?,
    @ColumnInfo(name = "title")
    val title:String?,
    @ColumnInfo(name = "description")
    val description:String?
)
