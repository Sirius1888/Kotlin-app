package com.example.firstapp.ui.playlists

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.data.models.PlaylistItems
import com.example.firstapp.data.network.Status
import com.example.firstapp.repository.YoutubeRepository

class PlaylistViewModel(var repository: YoutubeRepository) : ViewModel() {

    var errorMessage = MutableLiveData<String>()
    var playlists = MutableLiveData<MutableList<PlaylistItems>>()

    fun fetchPlaylists() {
        repository.fetchPlaylists().observeForever {
            when (it.status) {
                Status.SUCCESS -> playlists.postValue(it.data?.items)
                Status.ERROR -> errorMessage.postValue(it.message.toString())
            }
        }
    }
}