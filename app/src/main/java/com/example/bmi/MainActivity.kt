package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val heightEdt: EditText by lazy { findViewById<EditText>(R.id.heightEdt) }
    private val weightEdt: EditText by lazy { findViewById<EditText>(R.id.weightEdt) }
    private val womanBtn: Button by lazy { findViewById<Button>(R.id.womanBtn) }
    private val manBtn: Button by lazy { findViewById<Button>(R.id.manBtn) }
    private val bmiBtn: Button by lazy { findViewById<Button>(R.id.bmiCheck) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bmiBtn.setOnClickListener {

            if (heightEdt.text.isEmpty() || weightEdt.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height: Int = heightEdt.text.toString().toInt()
            val weight: Int = weightEdt.text.toString().toInt()
            val intent = Intent(this, ResultActivity::class.java)
                .putExtra("height", height)
                .putExtra("weight",weight)
            startActivity(intent)
        }
    }
}