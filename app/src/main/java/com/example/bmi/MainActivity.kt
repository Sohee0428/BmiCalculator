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

    private var wm = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bmiBtn.setOnClickListener {

            if (heightEdt.text.isEmpty() || weightEdt.text.isEmpty() || wm.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height: Int = heightEdt.text.toString().toInt()
            val weight: Int = weightEdt.text.toString().toInt()
            val intent = Intent(this, ResultActivity::class.java)
                .putExtra("height", height)
                .putExtra("weight", weight)
                .putExtra("WM", wm)
            startActivity(intent)
        }

        manBtn.setOnClickListener {
            womanBtn.setBackgroundResource(R.drawable.check_item)
            womanBtn.setTextColor(resources.getColor(R.color.black, null))
            manBtn.setBackgroundResource(R.drawable.checked_item)
            manBtn.setTextColor(resources.getColor(R.color.white, null))

            wm = "M"

        }

        womanBtn.setOnClickListener {
            womanBtn.setBackgroundResource(R.drawable.checked_item)
            womanBtn.setTextColor(resources.getColor(R.color.white, null))
            manBtn.setBackgroundResource(R.drawable.check_item)
            manBtn.setTextColor(resources.getColor(R.color.black, null))

            wm = "W"
        }
    }
}