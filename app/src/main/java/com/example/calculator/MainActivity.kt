package com.example.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var firstFactor: Float = 0f
    private var secondFactor: Float = 0f
    private var operationPressed: Boolean = false
    private var operation: String = ""
    private var outputNumber = "0"
        get() = binding.resultTv.text.toString()
        set(value) {
            binding.resultTv.text = value.toString()
            field = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun onItemClick(view: View) {
        if (operationPressed){

        }

        when (view.id){
            R.id.number0Btn -> {
                setNumber("0")
            }

            R.id.number1Btn -> {
                setNumber("1")
            }

            R.id.number2Btn -> {
                setNumber("2")
            }

            R.id.number3Btn -> {
                setNumber("3")
            }

            R.id.number4Btn -> {
                setNumber("4")
            }

            R.id.number5Btn -> {
                setNumber("5")
            }

            R.id.number6Btn -> {
                setNumber("6")
            }

            R.id.number7Btn -> {
                setNumber("7")
            }

            R.id.number8Btn -> {
                setNumber("8")
            }

            R.id.number9Btn -> {
                setNumber("9")
            }

            R.id.decimalBtn -> {

            }

            R.id.cancelBtn -> {

            }

            R.id.invertBtn -> {

            }

            R.id.percentageBtn -> {

            }

            R.id.divideBtn -> {

            }

            R.id.multiplicationBtn -> {

            }

            R.id.subtractionBtn -> {

            }

            R.id.additionBtn -> {
                if (!operationPressed){
                    operation = "+"
                    firstFactor = outputNumber.toFloat()
                }
            }

            R.id.equalBtn -> {

            }
        }
    }

    private fun setNumber(value: String) {
        if (outputNumber == "0" || outputNumber == "0.0")
            outputNumber = value
        else
            outputNumber += value
    }

    private fun calculateResult() {

    }
}