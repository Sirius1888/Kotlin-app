package com.example.firstapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.firstapp.R
import com.example.firstapp.gone
import com.example.firstapp.showToast
import com.example.firstapp.ui.adapter.MainAdapter
import com.example.firstapp.visible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Прочитать документацияю по youtube API
    // Получить youtube API key
    // Сделать запрос (в постмане или инсомния) на получение списка плейлистов https://www.googleapis.com/youtube/v3/playlists.

    val urls = mutableListOf<String>().apply {
        add("https://api.interior.ru/images/APR_AGENCY/Chicago.jpg.webp")
        add("https://cdn.iz.ru/sites/default/files/styles/900x506/public/news-2018-03/Depositphotos_31242805_m-2015.jpg?itok=_u8w9wvh")
        add("https://tochka-mira.ru/wp-content/uploads/2018/01/16-1024x640.jpg")
        add("https://api.interior.ru/images/APR_AGENCY/Chicago.jpg.webp")
        add("https://cdn.iz.ru/sites/default/files/styles/900x506/public/news-2018-03/Depositphotos_31242805_m-2015.jpg?itok=_u8w9wvh")
        add("https://tochka-mira.ru/wp-content/uploads/2018/01/16-1024x640.jpg")
    }

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
        removeAction()
        addAction()
    }

    private fun setupAdapter() {
        adapter = MainAdapter()
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view.adapter = adapter
        val snap = LinearSnapHelper()
        snap.attachToRecyclerView(recycler_view)
        adapter.addItems(urls)
    }

    private fun removeAction() {
        remove.setOnClickListener {
           adapter.itemRemove(adapter.holder.adapterPosition)
        }
    }

    private var isAdding = false
    private fun addAction() {
        add.setOnClickListener {
            if (isAdding) showTypeUrl()
            else hideTypeUrl()
        }
    }

    private fun showTypeUrl() {
        val value = type_url.text.toString()
        if (value.isNotEmpty() && value.startsWith("https://")) {
            urls.add(value)
            adapter.addItem(value)
            isAdding = false
            type_url.gone()
        } else {
            return
        }
    }

    private fun hideTypeUrl() {
        type_url.visible()
        isAdding = true
    }
}