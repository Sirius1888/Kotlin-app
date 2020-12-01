package com.example.firstapp.ui.detail_playlist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.data.models.PlaylistItems
import com.example.firstapp.showToast
import com.example.firstapp.ui.detail_playlist.adapter.DetailPlaylistAdapter
import com.example.firstapp.ui.detail_video.DetailVideoActivity
import kotlinx.android.synthetic.main.activity_detail_playlist.*
import org.koin.android.ext.android.inject

class DetailPlaylistActivity : AppCompatActivity() {

    private val viewModel by inject<DetailPlaylistViewModel>()

    private lateinit var adapter: DetailPlaylistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_playlist)
        setupAdapter()
        subscribeDetailPlaylist()
        fetchDetailPlaylist()
        subscribeErrorMessage()
    }

    private fun setupAdapter() {
        adapter = DetailPlaylistAdapter(this::onItemClick)
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = adapter
    }

    private fun onItemClick(item: PlaylistItems) {
        DetailVideoActivity.instanceActivity(this, item)
    }

    private fun subscribeDetailPlaylist() {
        viewModel.detailPlaylists.observeForever {
            adapter.addItems(it)
        }
    }

    private fun fetchDetailPlaylist() {
        viewModel.fetchPlaylistVideo((playlist?.id))
    }

    private fun subscribeErrorMessage() {
        viewModel.errorMessage.observeForever {
            showToast(it)
        }
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