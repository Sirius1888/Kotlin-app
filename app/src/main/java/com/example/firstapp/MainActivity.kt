package com.example.firstapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    //добавить условие на отправку данных, не отправлять пустые значения, в двух активити.
    //Сохранять все введенные значения и добавить TextView и кнопку показать и отобразить все данные в TextView
    //вынести showToast в отдельный класс

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendAction()
    }

    private fun sendAction() {
        send_to_change.setOnClickListener {
            val intent = Intent(this, ChangeActivity::class.java)
            intent.putExtra("text", edit_text.text.toString())
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            0 -> if (resultCode == Activity.RESULT_OK) edit_text.setText(data?.getStringExtra("result"))
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}