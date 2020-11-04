package com.example.firstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_change.*

class ChangeActivity : AppCompatActivity() {

    private var data: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)
        getIntentData()
        returnDataAction()
    }

    private fun getIntentData() {
        data = intent.getStringExtra("text")
        edit_text.setText(data)
    }

    private fun returnDataAction() {
        return_btn.setOnClickListener {
            val newData = edit_text.text.toString()
            if (newData == data) showToast("Поменяйте данные")
            else returnData(newData)
        }
    }

    private fun returnData(data: String) {
        val intent = Intent()
        intent.putExtra("result", data)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}