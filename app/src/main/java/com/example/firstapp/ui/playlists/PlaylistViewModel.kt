package com.example.firstapp.ui.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.repository.YoutubeRepository
import com.example.firstapp.data.models.Playlist
import com.example.firstapp.data.network.Resource

class PlaylistViewModel : ViewModel() {

    fun fetchPlaylists(): LiveData<Resource<Playlist>> {
        return YoutubeRepository().fetchPlaylists()
    }
}