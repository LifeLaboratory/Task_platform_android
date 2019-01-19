package ru.lifelaboratory.task_platform

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.lifelaboratory.task_platform.REST.Auth
import ru.lifelaboratory.task_platform.REST.User


class LoginActivity : AppCompatActivity() {
    val testObj by lazy {
        User.create()
    }

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val signin = findViewById<Button>(R.id.email_sign_in_button)
        signin.setOnClickListener(){
            var login = findViewById<TextView>(R.id.email).text.toString()
            var pass = findViewById<TextView>(R.id.password).text.toString()
            login = "test"
            pass = "test"
            disposable = testObj.auth(Auth(login, pass))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        when (result.answer) {
                            200 -> {
                                val toHome: Intent = Intent(this, HomeActivity::class.java)
                                toHome.putExtra("session", result.session)
                                startActivity(toHome)
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
