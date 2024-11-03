package com.example.hiddencalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultMainTV: TextView
    private lateinit var calcBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultMainTV = findViewById(R.id.resultMainTV)
        calcBTN = findViewById(R.id.calcBTN)

        val result = intent.getStringExtra("key")
        resultMainTV.text = result

        calcBTN.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            launchSomeActivity.launch(intent)
        }

    }

    private val launchSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    )
    { result ->
        if (result.resultCode == RESULT_OK) {
            val date = result.data
            val value = date!!.getStringExtra("key")
            resultMainTV.text = value
        }

    }
}