package com.example.notetakingapp.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.notetakingapp.Model.NoteModel

@Dao
interface NoteDao {

    @Query("select * from note_table")
    fun getAllNotes():List<NoteModel>
//    @Query("select * from note_table where title like:title limit 4 ")
//    fun getAllNotesByTitle(title:String)
    @Delete
    fun deleteNotes(note: NoteModel)
    @Insert
    fun insert(note:NoteModel)
}