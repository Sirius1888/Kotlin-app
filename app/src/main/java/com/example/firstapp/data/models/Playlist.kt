package com.example.firstapp.data.models

data class Playlist(
    var kind: String? = null,
    var etag: String? = null,
    var items: MutableList<PlaylistItems>? = null
)

data class PlaylistItems(
    var kind: String? = null,
    var etag: String? = null,
    var id: String? = null,
    var snippet: Snippet? = null,
    var contentDetails: ContentDetails? = null,
    var nextPageToken: String? = null
)

data class Snippet(
    var publishedAt: String? = null,
    var channelId: String? = null,
    var title: String? = null,
    var description: String? = null,
    var thumbnails: Thumbnails? = null
)

data class Thumbnails(
    var medium: Medium? = null
)

data class Medium(
    var url: String? = null
)

data class ContentDetails(
    var itemCount: String? = null
)