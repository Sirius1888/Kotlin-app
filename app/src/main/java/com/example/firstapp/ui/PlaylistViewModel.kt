package com.example.firstapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.repository.YoutubeRepository
import com.example.firstapp.models.Playlist

class PlaylistViewModel : ViewModel() {


    fun fetchPlaylists(): MutableLiveData<Playlist?> {
        return YoutubeRepository().fetchPlaylistsFromNetwork()
    }
}