package com.example.firstapp.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.firstapp.data.models.Playlist
import com.example.firstapp.data.network.Resource
import com.example.firstapp.data.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class YoutubeRepository() {

    val channel = "UC8butISFwT-Wl7EV0hUK0BQ"
    val key = "AIzaSyAx8p70xc-SuyvmfhLZbCCJNiqQOQG0nj0"
    val part = "snippet,contentDetails"
    val maxResult = "50"


    private var api = RetrofitClient().instanceRetrofit()

    fun fetchPlaylists() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.fetchPlaylists(part, key, channel, maxResult)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message =  e.message ?: "Error"))
        }
    }

}