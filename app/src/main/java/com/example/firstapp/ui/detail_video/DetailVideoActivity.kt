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
    BaseActivity<PlaylistViewModel>(R.layout.activity_detail_video, PlaylistViewModel::class),
    PlayerManager.PlayerCallBack {

    //1. Сделать при перевороте экрана фулл скрин и обратно
    //2. Добавить алерт диалог со списком видео
    //3. И сделать скачивание файла

    val urlsArray = mutableListOf<YoutubeVideo>()
//    private lateinit var player: Player
//    private lateinit var playerManager: PlayerManager
//    private lateinit var playerView: PlayerView
//    private var videoPlayer: SimpleExoPlayer? = null

    val videoPath =
        "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"//"https://www.youtube.com/watch?v=${playlist?.contentDetails?.videoId}"

    override fun setupViews() {
//        playerView = findViewById(R.id.player_view)
//        playerManager = PlayerManager.getSharedInstance(this)
//        player = playerManager.playerView.player
        title_text_view.text = playlist?.snippet?.title
        description_text_view.text = playlist?.snippet?.description
        player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                videoPath?.let { youTubePlayer.loadVideo(it, 0f) }
            }
        })
//        playExoPlayerVideo(videoPath)
//        fetchUrl()
    }

//    @SuppressLint("StaticFieldLeak")
//    private fun fetchUrl() {
//        val videoPath = "https://www.youtube.com/watch?v=${playlist?.contentDetails?.videoId}"
//        object : YouTubeExtractor(this) {
//            override fun onExtractionComplete(
//                ytFiles: SparseArray<YtFile>?,
//                videoMeta: VideoMeta?
//            ) {
//                var itag: Int
//                if (ytFiles == null) return
//                for (i in 0 until ytFiles.size()) {
//                    itag = ytFiles.keyAt(i)
//                    val ytFile = ytFiles.get(itag)
//                    urlsArray.add(YoutubeVideo().addFormatToList(urlsArray, ytFile, ytFiles))
//                }
//                val url = urlsArray[urlsArray.lastIndex]
//                playExoPlayerVideo(url.videoFile?.url.toString())
//            }
//        }.extract(videoPath, true, false)
//    }
//
//    private fun playExoPlayerVideo(url: String) {
//        if (urlsArray.isNullOrEmpty()) return
//        player_view.player = player
//        PlayerManager.getSharedInstance(this).playStream(url)
//        PlayerManager.getSharedInstance(this).setPlayerListener(this)
//    }

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

    override fun onPlayingEnd() {}

    override fun onItemClickOnItem(albumId: Int) {}

//    override fun onPause() {
//        super.onPause()
//        playerManager.pausePlayer()
//    }
//    override fun onRestart() {
//        super.onRestart();
//        playerManager.resumePlayer()
//    }
//
//    public override fun onDestroy() {
//        super.onDestroy()
//        player.release()
//        playerManager.releasePlayer()
//    }

}