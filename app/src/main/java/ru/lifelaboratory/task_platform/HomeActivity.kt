package ru.lifelaboratory.task_platform

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_eventlist -> {
                    val eventList : Intent = Intent(this, EventListActivity::class.java)
                    startActivity(eventList)
                }
                R.id.navigation_user -> {
                    Toast.makeText(this, "Личный кабинет", Toast.LENGTH_SHORT).show()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}