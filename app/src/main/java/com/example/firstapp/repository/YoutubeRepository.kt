package com.example.firstapp.repository

import androidx.lifecycle.liveData
import com.example.firstapp.data.network.Resource
import com.example.firstapp.data.network.YoutubeApi
import kotlinx.coroutines.Dispatchers

class YoutubeRepository(private var api: YoutubeApi): BaseRepository() {

    val channel = "UC8butISFwT-Wl7EV0hUK0BQ"
    val key = "AIzaSyAx8p70xc-SuyvmfhLZbCCJNiqQOQG0nj0"
    val part = "snippet,contentDetails"

    fun fetchPlaylists() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.fetchPlaylists(part, key, channel)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message =  e.message ?: "Error"))
        }
    }

    fun fetchDetailPlaylists(playlistId: String?, pageToken: String?) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.fetchDetailPlaylist(part, key, playlistId, pageToken)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message =  e.message ?: "Error"))
        }
    }

}

























open class BaseRepository {
//
//    fun <T> baseRequest(dto: T) = liveData(Dispatchers.IO) {
//        emit(Resource.loading(data = null))
//        try {
//            emit(Resource.success(data = dto))
//        } catch (e: Exception) {
//            emit(Resource.error(data = null, message =  e.message ?: "Error"))
//        }
//    }
}