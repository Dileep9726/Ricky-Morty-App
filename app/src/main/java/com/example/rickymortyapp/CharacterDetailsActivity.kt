package com.example.rickymortyapp


import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso

class CharacterDetailsActivity : AppCompatActivity() {
    private lateinit var favoriteButton: Button
    private var isFavorite: Boolean = false
    private lateinit var favoriteTextView: TextView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        val imageView: ImageView = findViewById(R.id.imageView)
        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val statusTextView: TextView = findViewById(R.id.statusTextView)
        val speciesTextView: TextView = findViewById(R.id.speciesTextView)
        val genderTextView: TextView = findViewById(R.id.genderTextView)
        val typeTextView: TextView = findViewById(R.id.typeTextView)
        favoriteTextView = findViewById(R.id.favoriteTextView)
        favoriteButton = findViewById(R.id.favoriteButton)
        toolbar = findViewById(R.id.toolbarCharDetails)

        setToolBar()

        val character = intent.getParcelableExtra<Character>("character")
        character?.let {
            Picasso.get().load(it.image).into(imageView)
            nameTextView.text = it.name
            statusTextView.text = it.status
            speciesTextView.text = it.species
            genderTextView.text = it.gender

            if (it.type == "") {
                typeTextView.text = "NA"
            } else {
                typeTextView.text = it.type
            }
            isFavorite = getFavoriteStatus(it.id)

            updateFavoriteButton()

            favoriteButton.setOnClickListener { _ ->
                isFavorite = !isFavorite
                setFavoriteStatus(it.id, isFavorite)
                updateFavoriteButton()
            }
        }
    }

    private fun updateFavoriteButton() {

        val drawableBlack: Drawable? = ContextCompat.getDrawable(this, R.drawable.iv_heart)
        val drawableRed: Drawable? = ContextCompat.getDrawable(this, R.drawable.iv_heart_red)

        if (isFavorite) {
            favoriteButton.text = "Remove from Favorite"
            favoriteTextView.text = "Favorite"
            favoriteTextView.setCompoundDrawablesWithIntrinsicBounds(
                drawableRed, null, null, null
            )
        } else {
            favoriteButton.text = "Add to Favorite"
            favoriteTextView.text = "Not Favorite"
            favoriteTextView.setCompoundDrawablesWithIntrinsicBounds(
                drawableBlack,
                null,
                null,
                null
            )
        }
    }

    private fun getFavoriteStatus(characterId: Int): Boolean {
        val sharedPreferences = getSharedPreferences("favorites", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(characterId.toString(), false)
    }

    private fun setFavoriteStatus(characterId: Int, isFavorite: Boolean) {
        val sharedPreferences = getSharedPreferences("favorites", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putBoolean(characterId.toString(), isFavorite)
            apply()
        }
    }

    private fun setToolBar() {
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "Character Details"
        }
    }

    companion object {
        fun newIntent(context: Context, character: Character): Intent {
            return Intent(context, CharacterDetailsActivity::class.java).apply {
                putExtra("character", character)
            }
        }
    }
}
