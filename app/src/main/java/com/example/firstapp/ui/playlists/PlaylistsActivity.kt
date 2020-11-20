package com.example.firstapp.ui.playlists

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.data.models.PlaylistItems
import com.example.firstapp.showToast
import com.example.firstapp.ui.detail_playlist.DetailPlaylistActivity
import com.example.firstapp.ui.playlists.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class PlaylistsActivity : AppCompatActivity() {
    //1. Добавить бд рум
    //2. Добавить TypeConverter для наших моделей
    //3. Подправить наши модели, чтобы они имели возможность сохранять в бд
    //4. Сделать сохрание в бд 2-х запросов
    //5. Выполнить текущие экраны по дизайну

    private lateinit var adapter: MainAdapter
    private val viewModel by inject<PlaylistViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()

        subscribeToPlaylists()
        subscribeErrorMessage()
        fetchPlaylists()
    }

    private fun setupAdapter() {
        adapter = MainAdapter(this::onItemClick)
        recycler_view.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = adapter
    }

    private fun subscribeToPlaylists() {
        viewModel.playlists.observeForever {
            adapter.addItems(it)
        }
    }

    private fun subscribeErrorMessage() {
        viewModel.errorMessage.observeForever {
            showToast(it)
        }
    }

    private fun fetchPlaylists() {
        viewModel.fetchPlaylists()
    }

    private fun onItemClick(item: PlaylistItems) {
        DetailPlaylistActivity.instanceActivity(this, item)
    }

}