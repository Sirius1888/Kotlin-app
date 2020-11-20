package com.example.firstapp.di

import com.example.firstapp.data.network.RetrofitClient
import com.example.firstapp.repository.YoutubeRepository
import com.example.firstapp.ui.detail_playlist.DetailPlaylistViewModel
import com.example.firstapp.ui.playlists.PlaylistViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var mainModule = module {
    single { RetrofitClient() }
    single { RetrofitClient().provideYoutubeApi() }

    factory { YoutubeRepository(get()) }
}

var viewModelModule = module {
    viewModel { PlaylistViewModel(get()) }
    viewModel { DetailPlaylistViewModel(get()) }
}