package ru.lifelaboratory.task_platform

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator

import kotlinx.android.synthetic.main.activity_event_list.*
import ru.lifelaboratory.task_platform.Adapter.EventListAdapter
import ru.lifelaboratory.task_platform.REST.Event

class EventListActivity : AppCompatActivity() {

    val list = ArrayList<Event>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)
        setSupportActionBar(toolbar)

        val listUsers = arrayOf<Event>(Event("Событие 1", "https://miro.medium.com/max/864/1*gZ9XF80M8yOasLiFUzL07g.png", "Прикольное событие", "02.01.2019", "08.01.2019"),
                               Event("Событие 2", "https://miro.medium.com/max/864/1*gZ9XF80M8yOasLiFUzL07g.png", "Интересное событие", "03.01.2019", "11.01.2019"),
                               Event("Событие 3", "https://miro.medium.com/max/864/1*gZ9XF80M8yOasLiFUzL07g.png", "Хорошее событие", "05.01.2019", "30.01.2019"))
        list.addAll(listUsers)
        val eventList = findViewById(R.id.event_list) as RecyclerView
        eventList.layoutManager = LinearLayoutManager(this)
        val adapter = EventListAdapter(list, supportFragmentManager)
        eventList.adapter = adapter
        adapter.notifyDataSetChanged()

        navigation.setOnNavigationItemSelectedListener { it ->
            when (it.itemId) {
                R.id.navigation_user -> {
                    val homeActivity : Intent = Intent(this, HomeActivity::class.java)
                    startActivity(homeActivity)
                }
                R.id.navigation_eventlist -> {
                    Toast.makeText(this, "Список событий", Toast.LENGTH_SHORT).show()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(this, "Отменено", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Результат сканирования: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

}
