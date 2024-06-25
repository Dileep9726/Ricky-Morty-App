package com.example.rickymortyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CharacterAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount() = characters.size

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val statusTextView: TextView = itemView.findViewById(R.id.statusTextView)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(character: Character) {
            nameTextView.text = character.name
            statusTextView.text = character.status
            Picasso.get().load(character.image).into(imageView)
        }

        override fun onClick(v: View?) {
            val character = characters[adapterPosition]
            val context = itemView.context
            val intent = CharacterDetailsActivity.newIntent(context, character)
            context.startActivity(intent)
        }
    }
}

