package com.example.firstapp.data.models

import android.graphics.pdf.PdfDocument

data class DetailPlaylist(
    var king: String? = null,
    var page: PageInfo? = null,
    var etag: String? = null,
    var items: MutableList<Playlist>,
    var nextPage: String
)

data class PageInfo(
    var totalResult: Int? = null,
    var resultPerPage: Int? = null
)