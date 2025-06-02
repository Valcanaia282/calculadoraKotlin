package com.example.calculadora

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Calculator {
    var input by mutableStateOf("0")
    var lastValue by mutableStateOf("")
    var operation by mutableStateOf("")

    fun onButtonClick(value: String) {
        when (value) {
            "C" -> {
                input = "0"
                lastValue = ""
                operation = ""
            }
            "=" -> {
                if (lastValue.isNotEmpty() && operation.isNotEmpty()) {
                    val result = when (operation) {
                        "+" -> lastValue.toDouble() + input.toDouble()
                        "-" -> lastValue.toDouble() - input.toDouble()
                        "x" -> lastValue.toDouble() * input.toDouble()
                        "/" -> if (input != "0") lastValue.toDouble() / input.toDouble() else 0.0
                        else -> input.toDouble()
                    }
                    input = result.toString()
                    lastValue = ""
                    operation = ""
                }
            }
            "+", "-", "x", "/" -> {
                lastValue = input
                operation = value
                input = "0"
            }
            else -> {
                input = if (input == "0") value else input + value
            }
        }
    }
}