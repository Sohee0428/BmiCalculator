package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val heightEdt = findViewById<EditText>(R.id.heightEdt)
    private val weightEdt = findViewById<EditText>(R.id.weightEdt)
    private val womanBtn = findViewById<Button>(R.id.womanBtn)
    private val manBtn = findViewById<Button>(R.id.manBtn)
    private val bmiBtn = findViewById<Button>(R.id.bmiCheck)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}