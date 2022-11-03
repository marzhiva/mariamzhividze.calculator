package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand=0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.textView)
    }

    fun numberClick(clickedView:View) {
        if (clickedView is TextView) {
            var text = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (text == "0") {
                text = ""
            }
            val result = text + number
            resultTextView.text = result
        }
    }
    fun operationClick (clickedView: View) {
        if (clickedView is TextView) {
            if (resultTextView.text.toString()!="") {
                operand = resultTextView.text.toString().toDouble()
                operation = clickedView.text.toString()
                resultTextView.text = ""
            } else {
                operation = clickedView.text.toString()
            }
        }
    }
    fun equalsClick (clickedView: View){
        val secondOperand = resultTextView.text.toString().toDouble()
        when (operation) {
            "+" -> resultTextView.text = (operand + secondOperand).toString()
            "-" -> resultTextView.text = (operand - secondOperand).toString()
            "*" -> resultTextView.text = (operand * secondOperand).toString()
            "/" -> resultTextView.text = (operand / secondOperand).toString()
        }
        if (resultTextView.text.toString().takeLast(2)==".0"){
            resultTextView.text=resultTextView.text.toString().dropLast(2)
        }

    }

    fun clearClick(clickedView: View) {
        if(clickedView is TextView){
            resultTextView.text="0"
        }
    }
    fun deleteClick(clickedView: View){
        if(clickedView is TextView){
            var text= resultTextView.text.toString()
            resultTextView.text=text.dropLast(1)
            if (resultTextView.text == ""){
                resultTextView.text="0"
            }

        }
    }
    fun dotClick(clickedView: View) {
        if (clickedView is TextView) {
            var text = resultTextView.text.toString()
            var dot = clickedView.text.toString()
            if (text.contains('.'))
                dot = ""
            resultTextView.text = text + dot
        }
    }
}