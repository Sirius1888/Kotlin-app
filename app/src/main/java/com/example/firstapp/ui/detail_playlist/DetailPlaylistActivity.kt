package com.example.firstapp.ui.detail_playlist

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firstapp.R
import com.example.firstapp.data.models.DetailPlaylist
import com.example.firstapp.data.models.Playlist
import com.example.firstapp.data.models.PlaylistItems
import com.example.firstapp.data.network.Resource
import com.example.firstapp.showToast
import com.example.firstapp.ui.playlists.PlaylistViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class DetailPlaylistActivity : AppCompatActivity() {

    private val viewModel by inject<DetailPlaylistViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_playlist)
        subscribeDetailPlaylist()
    }

    private fun subscribeDetailPlaylist() {
        val result = viewModel.fetchDetailPlaylist(playlist?.snippet?.channelId)
        showToast(result?.count().toString())
    }

    companion object {
        var playlist: PlaylistItems? = null
        fun instanceActivity(activity: Activity?, playlist: PlaylistItems) {
            val intent = Intent(activity, DetailPlaylistActivity::class.java)
            this.playlist = playlist
            activity?.startActivity(intent)
        }
    }

}