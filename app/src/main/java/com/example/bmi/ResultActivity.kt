package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.graphics.blue
import androidx.core.graphics.toColorInt
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        val bmi = weight / ( height * height )
        val result = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중경도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상 체중"
            else -> "저체중"
        }

        val standardWeight = (height - 100) * 0.9

        val bmiTxt: TextView by lazy { findViewById(R.id.bmi) }
        val resultTxt: TextView by lazy { findViewById(R.id.result) }
        val standard: TextView by lazy { findViewById(R.id.standardWeight) }

        bmiTxt.text = bmi.toString()
        resultTxt.text = "$result 입니다."
        standard.text = standardWeight.toString()
    }
}