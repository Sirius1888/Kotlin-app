package com.example.firstapp.ui.detail_video

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.util.SparseArray
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile
import com.example.firstapp.R
import com.example.firstapp.base.BaseActivity
import com.example.firstapp.base.PlayerManager
import com.example.firstapp.data.models.PlaylistItems
import com.example.firstapp.data.models.YoutubeVideo
import com.example.firstapp.ui.playlists.PlaylistViewModel
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_detail_video.*


class DetailVideoActivity :
    BaseActivity<PlaylistViewModel>(R.layout.activity_detail_video, PlaylistViewModel::class){

    //1. Сделать при перевороте экрана фулл скрин и обратно
    //2. Добавить алерт диалог со списком видео
    //3. И сделать скачивание файла

    val videoPath = "https://www.youtube.com/watch?v=${playlist?.contentDetails?.videoId}"

    override fun setupViews() {
        title_text_view.text = playlist?.snippet?.title
        description_text_view.text = playlist?.snippet?.description
        player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                videoPath.let { youTubePlayer.loadVideo(it, 0f) }
            }
        })
    }

    override fun setupLiveData() {}

    override fun setupFetchRequests() {}

    companion object {
        var playlist: PlaylistItems? = null
        fun instanceActivity(activity: Activity?, playlist: PlaylistItems) {
            val intent = Intent(activity, DetailVideoActivity::class.java)
            this.playlist = playlist
            activity?.startActivity(intent)
        }
    }
}