package com.example.lessonk1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textViewDataClass: TextView
    private lateinit var textViewCopyDataClass: TextView
    private lateinit var button: Button
    private lateinit var buttonCopy: Button

    private var counter = 0
    private val COUNTER_KEY = "COUNTER"
    private var data = DataClass(counter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        initListener()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(COUNTER_KEY, data)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        data = savedInstanceState.getParcelable(COUNTER_KEY)!!
        setTextViewContent(data.counter)
    }


    private fun initView() {
        textView = findViewById(R.id.text_view)
        textViewDataClass = findViewById(R.id.text_view_data_class)
        textViewCopyDataClass = findViewById(R.id.text_view_copy_data_class)
        button = findViewById(R.id.button)
        buttonCopy = findViewById(R.id.buttonCopy)
    }

    private fun setTextViewContent(counter: Int) {
        textView.text = "$counter"
        data.counter = counter
        textViewDataClass.text = data.counter.toString()
    }

    private fun initListener() {
        button.setOnClickListener {
            counter++
            setTextViewContent(counter)
        }

        buttonCopy.setOnClickListener {
            if (!data.copyKey) {
                val dataCopy = data.copy()
                data.copyKey = true
                textViewCopyDataClass.text = dataCopy.counter.toString()
            } else {
                textViewCopyDataClass.text = data.text
            }
        }
    }
}