package com.example.firstapp.ui.detail_playlist

import androidx.lifecycle.ViewModel
import com.example.firstapp.data.models.Playlist
import com.example.firstapp.repository.YoutubeRepository


class DetailPlaylistViewModel(var repository: YoutubeRepository) : ViewModel() {

    fun fetchDetailPlaylist(playlistId: String?): MutableList<Playlist>? {
        var result = repository.fetchDetailPlaylists(playlistId)

        val array: MutableList<Playlist>? = null
        result.observeForever {
            it?.data?.items?.let { result -> array?.addAll(result) }
            if (!it.data?.nextPage.isNullOrEmpty()) {
                val nextPage = it.data?.nextPage
                result = repository.fetchDetailPlaylists(playlistId, nextPage)
            }
        }

        return array
    }
}