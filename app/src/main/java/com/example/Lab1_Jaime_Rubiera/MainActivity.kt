package com.example.Lab1_Jaime_Rubiera

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.util.Log
import android.view.View
import android.widget.TextView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.graphics.toColorInt
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    // lateinit var viewModel: ViewModel_BMI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            countText.text = "BMI is ${String.format("%.2f",bmi)}. ${bmiRes(bmi)}." // I am rounding the value to only 2 decimals
        }


       /* var viewModel= ViewModelProvider(this).get(ViewModel_BMI::class.java)
        viewModel.bmi.observe(this) { bmi ->
            viewModel = ViewModelProvider(this).get(ViewModel_BMI::class.java)
            viewModel.bmi.observe(this) { bmi ->
                val infobmi = findViewById<TextView>(R.id.countText) // bmi res el el cuadro de texto debajo del numero que dice el estado en el que está
                countText.visibility = View.VISIBLE
                countText.text = "${String.format("%.3f", bmi)}"
                infobmi.visibility = View.VISIBLE
            }
        }

        val infobmi = findViewById<TextView>(R.id.countText)
        infobmi.visibility = View.INVISIBLE

        val button2=findViewById<TextView>(R.id.button)
        button2.setOnClickListener {

            val massEditText=findViewById<TextView>(R.id.massEditText)
            var mass:Double = massEditText.text.toString().toDouble()

            val heightEditText=findViewById<TextView>(R.id.heightEditText)
            var height:Double = heightEditText.text.toString().toDouble()

            viewModel.countBmi(mass, height)
        }*/
    }

    fun OpenBMI_underweight () {
        val i = Intent(applicationContext, BMI_underweight::class.java)
        startActivity(i)
    }
    fun OpenBMI_normal () {
        val i = Intent(applicationContext, BMI_normal::class.java)
        startActivity(i)
    }
    fun OpenBMI_overweight_ () {
        val i = Intent(applicationContext, BMI_overweight::class.java)
        startActivity(i)
    }
    fun OpenBMI_obese () {
        val i = Intent(applicationContext, BMI_obese::class.java)
        startActivity(i)
    }

    fun bmiRes(bmi:Double):String{
        var ans=""
        if (bmi<18.5){
            ans="Underweight";
            val textView = findViewById<TextView>(R.id.countText)
            textView.setTextColor(Color.parseColor("#00BCD4"))
            textView. setOnClickListener {
                OpenBMI_underweight()
            }
        }
        else if (bmi>18.5 && bmi<24.9){
            ans="Normal"
            val textView = findViewById<TextView>(R.id.countText)
            textView.setTextColor(Color.parseColor("#4CAF50"))
            textView.setOnClickListener {
                OpenBMI_normal()
            }
        }
        else if (bmi>25 && bmi<29.9){
            ans="Overweight"
            val textView = findViewById<TextView>(R.id.countText)
            textView.setTextColor(Color.parseColor("#FF5722"))
            textView.setOnClickListener {
                OpenBMI_overweight_()
            }
        }
        else {
            ans="Obese"
            val textView = findViewById<TextView>(R.id.countText)
            textView.setTextColor(Color.parseColor("#E91E1E"))
            textView.setOnClickListener {
                OpenBMI_obese()
            }
        }
        return ans
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Imperial_Units -> {
                Toast.makeText(applicationContext, "Changed to Imperial Units", Toast.LENGTH_LONG)
                    .show()
                val i = Intent(applicationContext, Imperial::class.java)
                startActivity(i)
                return true
            }
            R.id.Author_information -> {
                Toast.makeText(applicationContext, "Changed to Author information", Toast.LENGTH_LONG)
                    .show()
                val i = Intent(applicationContext, Author_information::class.java)
                startActivity(i)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}