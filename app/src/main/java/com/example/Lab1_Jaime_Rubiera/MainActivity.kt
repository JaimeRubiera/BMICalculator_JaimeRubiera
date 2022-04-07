package com.example.Lab1_Jaime_Rubiera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ViewModel_BMI


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel= ViewModelProvider(this).get(ViewModel_BMI::class.java)
        viewModel.bmi.observe(this){ bmi ->
            viewModel= ViewModelProvider(this).get(ViewModel_BMI::class.java)
            viewModel.bmi.observe(this){ bmi ->
                val countText = findViewById<TextView>(R.id.countText)
                val infobmi = findViewById<TextView>(R.id.bmires) // bmi res el el cuadro de texto debajo del numero que dice el estado en el que está
                countText.visibility = View.VISIBLE
                countText.text = "${String.format("%.3f", bmi)}"
                infobmi.visibility = View.VISIBLE
                infobmi.text = "${bmiresult(bmi)}" // bmi result es la funcion que te hace el if y te cuadra en delgado, obeso...
            }

            val infotxt = findViewById<TextView>(R.id.countText)
            val infobmi = findViewById<TextView>(R.id.bmires)
            infotxt.visibility = View.INVISIBLE
            infobmi.visibility = View.INVISIBLE

            val mbutton = findViewById<Button>(R.id.button)
            mbutton.setOnClickListener {

                val weightedit = findViewById<EditText>(R.id.weightimttxt)
                var weighted: Double = weightedit.text.toString().toDouble()

                val heightedit = findViewById<EditText>(R.id.heightimttxt)
                var heighted: Double = heightedit.text.toString().toDouble()

                viewModel.countBmi(weighted, heighted)

        val countText=findViewById<TextView>(R.id.countText) // Here I am REFERENCING THE ID, so I can later use it
        countText.visibility = View.INVISIBLE // I am making the BMI value field invisible bc I don't want it to show until I press the button

        val button=findViewById<TextView>(R.id.button)
        button.setOnClickListener { // When I click the button,

            val massEditText=findViewById<TextView>(R.id.massEditText)
            var mass:Double = massEditText.text.toString().toDouble()

            val heightEditText=findViewById<TextView>(R.id.heightEditText)
            var height:Double = heightEditText.text.toString().toDouble()

            var bmi:Double = (mass*10000)/(height*height) // I create the variable BMI and put its formula in order to calculate it. Mass*10000 bc height needs to be in cm, and formula is in metres.

            Log.i("message", "***mass is ${mass}, height is ${height}, BMI is ${bmi}") // I want to print value in our Logcat, so I look for "***" whenever I run it to find it

            countText.visibility = View.VISIBLE // Now that we have calculated value of BMI, we want the field to be visible
            countText.text = "BMI is ${String.format("%.2f",bmi)}" // I am rounding the value to only 2 decimals


        }





    }
}