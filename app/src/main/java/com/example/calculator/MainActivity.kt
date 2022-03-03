package com.example.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var currentNumber = 0f
    private var oldNumber = 0f
    private var operation = ""
    private var previousOperation = ""
    private var isNewOperation = false
    private var outputNumber = "0"
        get() = binding.numberText.text.toString()
        set(value) {
            binding.numberText.text = value
            field = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onItemClick(view: View){
        if(isNewOperation){
            oldNumber = currentNumber
            outputNumber = ""
            isNewOperation = false
        }

        when(view.id){
            R.id.cancelButton -> {
                oldNumber = 0f
                currentNumber = 0f
                outputNumber = "0"
            }
            R.id.invertButton -> {
                if(!outputNumber.contains("-")) {
                    currentNumber *= -1
                    outputNumber = "-$outputNumber"
                }
                else{
                    currentNumber *= -1
                    outputNumber = outputNumber.drop(1)
                }
            }
            R.id.percentageButton -> {
                operation = "%"
                total()
                previousOperation = "%"
            }
            R.id.divide -> {
                operation = "/"
                total()
                previousOperation = "/"
            }
            R.id.number7 -> {
                setNumber(7)
            }
            R.id.number8 -> {
                setNumber(8)
            }
            R.id.number9 -> {
                setNumber(9)
            }
            R.id.multiply -> {
                operation = "*"
                total()
                previousOperation = "*"
            }
            R.id.number4 -> {
                setNumber(4)
            }
            R.id.number5 -> {
                setNumber(5)
            }
            R.id.number6 -> {
                setNumber(6)
            }
            R.id.subtract -> {
                operation = "-"
                total()
                previousOperation = "-"
            }
            R.id.number1 -> {
                setNumber(1)
            }
            R.id.number2 -> {
                setNumber(2)
            }
            R.id.number3 -> {
                setNumber(3)
            }
            R.id.add -> {
                operation = "+"
                total()
                previousOperation = "+"
            }
            R.id.number0 -> {
                setNumber(0)
            }
            R.id.pointButton -> {
                if(!outputNumber.contains("."))
                    outputNumber = "$outputNumber."
            }
            R.id.resultButton -> {
                makeOperations(operation)
            }
        }
    }

    private fun setNumber(number: Int){
        if(outputNumber == "0" || outputNumber == "0.0"){
            outputNumber = number.toString()
        }
        else{
            outputNumber += number
        }

        currentNumber = outputNumber.toFloat()
    }

    private fun total() {
        if(oldNumber != 0f && currentNumber != 0f){
            makeOperations(previousOperation)
        }
        isNewOperation = true
    }

    private fun makeOperations(operation: String){
        var finalResult = 0f
        when(operation){
            "+" -> {
                finalResult = oldNumber + currentNumber
            }

            "-" -> {
                finalResult = oldNumber - currentNumber
            }

            "*" -> {
                finalResult = oldNumber * currentNumber
            }

            "/" -> {
                finalResult = oldNumber / currentNumber
            }
            "%" -> {
                finalResult = (oldNumber / 100) * currentNumber
            }
        }
        currentNumber = finalResult
        outputNumber = finalResult.toString()
    }
}