package com.example.notetakingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notetakingapp.Database.NoteDatabase
import com.example.notetakingapp.Model.NoteModel
import com.example.notetakingapp.databinding.ActivityDescriptionBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DescriptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDescriptionBinding
    private lateinit var appDB: NoteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDB = NoteDatabase.initDatabase(this)

        binding.saveBtn.setOnClickListener() {

            var title = binding.noteTitleET.text.toString()
            var description = binding.noteDetailsET.text.toString()

            var modelObject = NoteModel(null, title, description)
             GlobalScope.launch {
                 appDB.noteDao().insert(modelObject)
             }
            Toast.makeText(this@DescriptionActivity, "Note added successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@DescriptionActivity,MainActivity::class.java))

        }
    }
}