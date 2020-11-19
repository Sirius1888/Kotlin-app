package com.example.firstapp.ui.playlists

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.data.models.Playlist
import com.example.firstapp.data.network.Resource
import com.example.firstapp.repository.YoutubeRepository
import com.example.firstapp.test_di.PeopleInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlaylistViewModel(var repository: YoutubeRepository) : ViewModel() {

    fun fetchPlaylists(): LiveData<Resource<Playlist>> {
        return repository.fetchPlaylists()
    }

//    fun fetc...

//    fun fetchDetail(): Double {
//        var result = 0.0
//        CoroutineScope(Dispatchers.Main).launch {
//            result = YoutubeRepository().fetchDetailPlaylists()
//            Log.v("RESULT_BIG_SUM", result.toString())
//        }
//        return result
//    }



}