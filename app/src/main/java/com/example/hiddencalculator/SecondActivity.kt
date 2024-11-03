package com.example.hiddencalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var plusBTN: Button
    private lateinit var minusBTN: Button
    private lateinit var multiplyBTN: Button
    private lateinit var divideBTN: Button
    private lateinit var transferDataBTN: Button
    private lateinit var resetBTN: Button

    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        plusBTN = findViewById(R.id.plusBTN)
        minusBTN = findViewById(R.id.minusBTN)
        multiplyBTN = findViewById(R.id.multiplyBTN)
        divideBTN = findViewById(R.id.divideBTN)
        transferDataBTN = findViewById(R.id.transferDataBTN)
        resetBTN = findViewById(R.id.resetBTN)

        plusBTN.setOnClickListener(this)
        minusBTN.setOnClickListener(this)
        multiplyBTN.setOnClickListener(this)
        divideBTN.setOnClickListener(this)
        transferDataBTN.setOnClickListener {
            if (resultTV.text.isEmpty()) return@setOnClickListener
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", resultTV.text.toString())
            startActivity(intent)
        }

        resetBTN.setOnClickListener{
            firstOperandET.text.clear()
            secondOperandET.text.clear()
            resultTV.text = ""
        }

        resultTV = findViewById(R.id.resultTV)
    }

    
    override fun onClick(v: View?) {

        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) {
            return
        }

        val firstOperand = firstOperandET.text.toString().toDouble()
        val secondOperand = secondOperandET.text.toString().toDouble()

        val result = when (v?.id) {
            R.id.plusBTN -> Operation(firstOperand, secondOperand).sum()
            R.id.minusBTN -> Operation(firstOperand, secondOperand).dif()
            R.id.multiplyBTN -> Operation(firstOperand, secondOperand).mul()
            R.id.divideBTN -> Operation(firstOperand, secondOperand).div()

            else -> 0.0
        }

        resultTV.text = result.toString()

    }

}