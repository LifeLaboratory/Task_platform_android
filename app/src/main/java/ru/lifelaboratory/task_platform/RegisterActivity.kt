package ru.lifelaboratory.task_platform

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val reg = findViewById<Button>(R.id.register)
        reg.setOnClickListener(){
            val name = findViewById<TextView>(R.id.name).text.toString()
            val login = findViewById<TextView>(R.id.login).text.toString()
            val email = findViewById<TextView>(R.id.email).text.toString()
            val pass = findViewById<TextView>(R.id.password).text.toString()
            //отправить запрос с этими всеми данными на сервер
        }
    }

}
