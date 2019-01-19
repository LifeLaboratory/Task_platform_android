package ru.lifelaboratory.task_platform

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val signin = findViewById<Button>(R.id.email_sign_in_button)
        signin.setOnClickListener(){
            val login = findViewById<TextView>(R.id.email).text.toString()
            val pass = findViewById<TextView>(R.id.password).text.toString()
        }
    }
}
