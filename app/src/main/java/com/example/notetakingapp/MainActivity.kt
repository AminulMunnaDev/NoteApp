package com.example.notetakingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.notetakingapp.Adapter.NoteAdapter
import com.example.notetakingapp.Database.NoteDatabase
import com.example.notetakingapp.Model.NoteModel
import com.example.notetakingapp.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var appDB:NoteDatabase
    private lateinit var amaderDataList:ArrayList<NoteModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDB=NoteDatabase.initDatabase(this@MainActivity)
        getAllData()


        binding.addBtn.setOnClickListener(){
            intent= Intent(this@MainActivity,DescriptionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllData() {
        amaderDataList= arrayListOf()

        GlobalScope.launch{
            appDB.noteDao().getAllNotes().forEach{
                    singleData->amaderDataList.add(singleData)
            }
        }
        initRecyclerView()
    }
    private fun initRecyclerView(){
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=NoteAdapter(amaderDataList)

    }
}