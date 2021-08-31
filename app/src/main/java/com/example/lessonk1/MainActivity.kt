package com.example.lessonk1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter = 0
        initView()

        button.setOnClickListener {
            counter ++
            textView.text = "button clicked $counter times"
        }
    }

    private fun initView() {
        textView = findViewById<TextView>(R.id.text_view)
        button = findViewById<Button>(R.id.button)
    }
}