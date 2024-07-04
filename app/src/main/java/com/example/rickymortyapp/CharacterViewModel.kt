package com.example.rickymortyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel : ViewModel() {
    private val repository = CharacterRepository()
    private val _characters = MutableLiveData<List<Character>?>()
    val characters: MutableLiveData<List<Character>?> = _characters

    fun fetchCharacters() {
        repository.getCharacters { characters ->
            _characters.postValue(characters)
        }
    }

    //commit 1
}
