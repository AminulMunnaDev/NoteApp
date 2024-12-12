package com.example.notetakingapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notetakingapp.Dao.NoteDao
import com.example.notetakingapp.Model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
 abstract class NoteDatabase:RoomDatabase() {

     abstract fun noteDao():NoteDao
     companion object {
         var INSTANCE:NoteDatabase? = null

         fun initDatabase(context: Context):NoteDatabase {
             var instance = Room.databaseBuilder(
                 context.applicationContext,
                 NoteDatabase::class.java,
                 "note_database"
             ).build()
             INSTANCE=instance
             return instance
         }

     }

























//    abstract fun noteDao():NoteDao
//    companion object{
//        var INSTANCE:NoteDatabase? = null
//
//        fun initDatabase(context: Context):NoteDatabase{
//            var instance=Room.databaseBuilder(
//                context.applicationContext,
//                NoteDatabase::class.java,
//                "note_database"
//            ).build()
//            INSTANCE=instance
//            return instance
//        }
//    }
}