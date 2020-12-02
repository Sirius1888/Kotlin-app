package com.example.firstapp.data.repository

import androidx.lifecycle.liveData
import com.example.firstapp.data.db.PlaylistDao
import com.example.firstapp.data.network.Resource
import com.example.firstapp.data.network.YoutubeApi
import kotlinx.coroutines.Dispatchers

open class BaseRepository {

    suspend fun <T> baseRequest(dto: T) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = dto))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message =  e.message ?: "Error"))
        }
    }

    fun <T> baseRequestWithDB(dto: T, fetchData: T) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        emit(Resource.fetchFromDB(fetchData))
        try {
            emit(Resource.success(data = dto))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message =  e.message ?: "Error"))
        }
    }
}

class YoutubeRepository(private var api: YoutubeApi, private var playlistDao: PlaylistDao): BaseRepository() {

//    val channel = "UC8butISFwT-Wl7EV0hUK0BQ"
    val channel = "UCDsHatv4GJ6e4up6mCSfZTg"
    val key = "AIzaSyAx8p70xc-SuyvmfhLZbCCJNiqQOQG0nj0"
    val part = "snippet,contentDetails"

//    fun fetchPlaylists() = liveData(Dispatchers.IO) {
//        val request = baseRequestWithDB(api.fetchPlaylists(part, key, channel), playlistDao.getPlaylist()).value
//        request?.data?.let { playlistDao.insertPlaylist(it) }
//        emit (request)
//    }
//    fun fetchPlaylists() = liveData(Dispatchers.IO) {
//        val request = baseRequest(api.fetchPlaylists(part, key, channel)).value
//        emit(request)
//    }

    fun fetchPlaylists() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        emit(Resource.fetchFromDB(playlistDao.getPlaylist()))
        try {
            val request = api.fetchPlaylists(part, key, channel)
            playlistDao.insertPlaylist(request)
            emit(Resource.success(data = request))
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