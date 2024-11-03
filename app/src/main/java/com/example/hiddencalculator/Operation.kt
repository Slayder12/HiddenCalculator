package com.example.hiddencalculator;

class Operation (private val first: Double, private val second: Double){
    fun sum() = first + second
    fun dif() = first - second
    fun mul() = first * second
    fun div() = if (second == 0.0) 0.0 else first / second
}
