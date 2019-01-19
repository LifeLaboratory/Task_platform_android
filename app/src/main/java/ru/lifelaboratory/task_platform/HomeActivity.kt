package ru.lifelaboratory.task_platform

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
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
        val graph = findViewById(R.id.graph) as GraphView

        graph.getViewport().setScalable(true)
        graph.getViewport().setScrollable(true)
        graph.getViewport().setScalableY(true)
        graph.getViewport().setScrollableY(true)

        val series = LineGraphSeries<DataPoint>(
            arrayOf<DataPoint>(
                DataPoint(0.0, 1.0),
                DataPoint(1.0, 5.0),
                DataPoint(2.0, 3.0),
                DataPoint(3.0, 2.0),
                DataPoint(4.0, 6.0)
            )
        )
        graph.addSeries(series)
        val logout = findViewById<Button>(R.id.logout)
        logout.setOnClickListener (){
            val logoutIntent = Intent(this, MainActivity::class.java)
            startActivity(logoutIntent)
        }
    }
}