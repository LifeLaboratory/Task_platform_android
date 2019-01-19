package ru.lifelaboratory.task_platform

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

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
        val adapter = EventListAdapter(list)
        eventList.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}
