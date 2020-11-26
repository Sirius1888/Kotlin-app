package com.example.firstapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.firstapp.data.models.Playlist
import com.example.firstapp.data.models.converter.PlaylistItemsConverter

@Database(entities = [Playlist::class], version = 1)
@TypeConverters(PlaylistItemsConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playlistDao(): PlaylistDao

}


