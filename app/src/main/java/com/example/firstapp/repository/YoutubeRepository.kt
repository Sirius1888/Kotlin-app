package com.example.firstapp.repository

import android.content.Context
import androidx.lifecycle.liveData
import com.example.firstapp.data.network.Resource
import com.example.firstapp.data.network.RetrofitClient
import com.example.firstapp.data.network.YoutubeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class DB(context: Context) {

}

class YoutubeRepository(var api: YoutubeApi) {

    val channel = "UC8butISFwT-Wl7EV0hUK0BQ"
    val key = "AIzaSyAx8p70xc-SuyvmfhLZbCCJNiqQOQG0nj0"
    val part = "snippet,contentDetails"
    val maxResult = "50"


//    private var api = RetrofitClient().instanceRetrofit()
//    private var langApi = RetrofitClient().instanceRetrofit()
//    private var diffApi = RetrofitClient().instanceRetrofit()

    fun fetchPlaylists() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.fetchPlaylists(part, key, channel, maxResult)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message =  e.message ?: "Error"))
        }
    }

    fun fetchDetailPlaylists(playlistId: String?, pageToken: String? = null) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.fetchDetailPlaylist(part, key, playlistId, maxResult, pageToken)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message =  e.message ?: "Error"))
        }
    }

}