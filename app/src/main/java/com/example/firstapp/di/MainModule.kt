package com.example.firstapp.di

import com.example.firstapp.data.network.RetrofitClient
import com.example.firstapp.repository.YoutubeRepository
import com.example.firstapp.test_di.*
import com.example.firstapp.ui.detail_playlist.DetailPlaylistViewModel
import com.example.firstapp.ui.playlists.PlaylistViewModel
import com.example.firstapp.ui.playlists.PlaylistsActivity
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var mainModule = module {
    factory { PeopleInfo(get(), get()) }
    factory { Car(get(), get()) }
    factory { ValueEngine() }
    factory { EngineCar(androidContext()) }

    single { SharedPref(androidContext()) }
    single { RetrofitClient() }
    single { RetrofitClient().provideYoutubeApi() }

    factory { YoutubeRepository(get()) }
}

var viewModelModule = module {
    viewModel { PlaylistViewModel(get()) }
    viewModel { DetailPlaylistViewModel(get()) }
}