package com.example.Lab1_Jaime_Rubiera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ViewModel_BMI : ViewModel() {
    private var iBmi = MutableLiveData<Double>()
    val bmi: LiveData<Double> = iBmi


    fun countBmi (mass: Double, height: Double){
        var bmi: Double = ((mass / (height * height)) * 10000)
        iBmi.value = bmi
    }
}