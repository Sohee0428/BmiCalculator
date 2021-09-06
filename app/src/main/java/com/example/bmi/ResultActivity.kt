package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.graphics.blue
import androidx.core.graphics.toColorInt
import java.lang.reflect.Array.get
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)
        val wm = intent.getStringExtra("WM")

        val bmi = weight / (height / 100.0).pow(2.0)
        val result = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중경도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상 체중"
            else -> "저체중"
        }

        val standardWeight: Double =
        when (wm) {
            "M" -> (height * height) * 22.0 * 0.0001
            "W" -> height.toDouble().pow(2) * 21 * 0.0001
            else -> 0.0
        }

        val bmiTxt: TextView by lazy { findViewById(R.id.bmi) }
        val resultTxt: TextView by lazy { findViewById(R.id.result) }
        val standard: TextView by lazy { findViewById(R.id.standardWeight) }

        bmiTxt.text = bmi.toString().substring(0, 5)
        resultTxt.text = "$result 입니다."
        standard.text = standardWeight.toString().substring(0, 5)
    }
}