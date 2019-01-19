package ru.lifelaboratory.task_platform

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jjoe64.graphview.series.LineGraphSeries
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint


class Statistics : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)
        val graph = findViewById(R.id.graph) as GraphView

        graph.getViewport().setScalable(true)
        graph.getViewport().setScrollable(true)
        graph.getViewport().setScalableY(true)
        graph.getViewport().setScrollableY(true)

        val series = BarGraphSeries<DataPoint>(
            arrayOf<DataPoint>(
                DataPoint(0.0, 1.0),
                DataPoint(1.0, 5.0),
                DataPoint(2.0, 3.0),
                DataPoint(3.0, 2.0),
                DataPoint(4.0, 6.0)
            )
        )
        graph.addSeries(series)
    }
}
