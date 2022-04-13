package com.example.Lab1_Jaime_Rubiera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class BMI_normal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_normal)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Metric_Units -> {
                Toast.makeText(applicationContext, "Changed to Metric Units", Toast.LENGTH_LONG)
                    .show()
                val i = Intent(applicationContext, MainActivity::class.java)
                startActivity(i)
                return true
            }
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