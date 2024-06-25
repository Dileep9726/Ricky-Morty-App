package com.example.rickymortyapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {
    private val apiService = ApiService.create()

    fun getCharacters(onResult: (List<Character>?) -> Unit) {
        apiService.getCharacters().enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                onResult(response.body()?.results)
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                onResult(null)
            }
        })
    }
}
