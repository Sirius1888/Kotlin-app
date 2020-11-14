package com.example.firstapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.firstapp.models.Playlist
import com.example.firstapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class YoutubeRepository() {

    val channel = "UC8butISFwT-Wl7EV0hUK0BQ"
    val key = "AIzaSyAx8p70xc-SuyvmfhLZbCCJNiqQOQG0nj0"
    val part = "snippet,contentDetails"
    val maxResult = "50"


    private var api = RetrofitClient().instanceRetrofit()

    fun fetchPlaylistsFromNetwork(): MutableLiveData<Playlist?> {
        val data = MutableLiveData<Playlist?>()
        api.fetchPlaylists(part, key, channel, maxResult).enqueue(object : Callback<Playlist?> {
            override fun onFailure(call: Call<Playlist?>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(call: Call<Playlist?>, response: Response<Playlist?>) {
                data.value = response.body()
            }

        })
        return data
    }

}