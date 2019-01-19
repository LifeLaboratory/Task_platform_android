package ru.lifelaboratory.task_platform.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_event_list.view.*
import ru.lifelaboratory.task_platform.R
import ru.lifelaboratory.task_platform.REST.Event

class EventListAdapter (private val list:ArrayList<Event>) : RecyclerView.Adapter<EventListAdapter.Holder>() {

    var context : Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_event_list,parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.view.event_title.text = list.get(position).name
        holder.view.event_date.text = list.get(position).startDate + " - " + list.get(position).endDate
        Picasso.get().load(list.get(position).pictureUrl).into(holder.view.event_image)

        holder.view.setOnClickListener { Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show() }

    }

    class Holder(val view: View) : RecyclerView.ViewHolder(view)
}