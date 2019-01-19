package ru.lifelaboratory.task_platform

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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
            val repeatPass = findViewById<TextView>(R.id.reppass).text.toString()
            if(pass.equals(repeatPass) == false){
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                findViewById<TextView>(R.id.password).text = ""
                findViewById<TextView>(R.id.reppass).text = ""
            }
            //отправить запрос с этими всеми данными на сервер
        }
    }

}
