package com.example.rickymortyapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        toolbar = findViewById(R.id.toolbarMain)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        setToolBar()

        viewModel.characters.observe(this, Observer { characters ->
            if (characters != null) {
                recyclerView.adapter = CharacterAdapter(characters)
            }
        })

        viewModel.fetchCharacters()
    }

    private fun setToolBar() {
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        supportActionBar?.apply {
            title = "Dashboard"
        }
    }
}
