package com.example.lessonk1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button

    private var counter = 0
    private val COUNTER_KEY = "COUNTER"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        initListener()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER_KEY, counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt(COUNTER_KEY)
        setTextViewContent(counter)
    }


    private fun initView() {
        textView = findViewById(R.id.text_view)
        button = findViewById(R.id.button)
    }

    private fun setTextViewContent(counter : Int) {
        textView.text = "$counter"
    }

    private fun initListener() {
        button.setOnClickListener {
            counter++
            setTextViewContent(counter)
        }
    }
}