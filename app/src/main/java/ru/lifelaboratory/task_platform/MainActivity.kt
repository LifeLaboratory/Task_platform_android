package ru.lifelaboratory.task_platform

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val reg = findViewById<Button>(R.id.register)
        val signin = findViewById<Button>(R.id.sign_in)
        val stat = findViewById<Button>(R.id.stat)
        reg.setOnClickListener(){
            val regIntent = Intent(this, RegisterActivity::class.java)
            startActivity(regIntent)
        }
        signin.setOnClickListener(){
            val signIntent = Intent(this, LoginActivity::class.java)
            startActivity(signIntent)
        }
        stat.setOnClickListener(){
            val statIntent = Intent(this, Statistics::class.java)
            startActivity(statIntent)
        }
    }

}
