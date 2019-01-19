package ru.lifelaboratory.task_platform

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import ru.lifelaboratory.task_platform.REST.Registration
import ru.lifelaboratory.task_platform.REST.User

class RegisterActivity : AppCompatActivity() {

    val testObj by lazy {
        User.create()
    }

    var disposable: Disposable? = null

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
            if(pass != repeatPass){
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                findViewById<TextView>(R.id.password).text = ""
                findViewById<TextView>(R.id.reppass).text = ""
            } else {
                disposable = testObj.registration(Registration(name, login, pass, email))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->
                            when (result.answer) {
                                200 -> {
                                    Toast.makeText(this, "Регистрация пройдена успешно", Toast.LENGTH_SHORT).show()
                                    val toMainActivity: Intent = Intent(this, MainActivity::class.java)
                                    startActivity(toMainActivity)
                                }
                                else -> {
                                    Toast.makeText(this, result.answer, Toast.LENGTH_SHORT).show()
                                }
                            }
                        },
                        { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
                    )
            }
        }
    }

}
