package com.example.firstapp.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import com.example.firstapp.showToast
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class BaseActivity<out ViewModel: BaseViewModel>(private var layoutId: Int, viewModelClass: KClass<ViewModel>): AppCompatActivity() {

    val viewModel: ViewModel by lazy { getViewModel<ViewModel>(viewModelClass)}

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        initLanguage()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        setupViews()
        setupLiveData()
        setupFetchRequests()
        showError()
    }

    private fun initLanguage() { }

    abstract fun setupLiveData()
    abstract fun setupViews()
    abstract fun setupFetchRequests()

    private fun showError() {
        viewModel.errorMessage.observeForever {
            showToast(it)
        }
    }
}