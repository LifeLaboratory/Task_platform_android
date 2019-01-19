package ru.lifelaboratory.task_platform.Adapter

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_event_list.view.*
import ru.lifelaboratory.task_platform.DialogEventAbout
import ru.lifelaboratory.task_platform.DialogEventRun
import ru.lifelaboratory.task_platform.R
import ru.lifelaboratory.task_platform.REST.Event

class EventListAdapter (private val list: ArrayList<Event>, private val supportFragmentManager: FragmentManager) : RecyclerView.Adapter<EventListAdapter.Holder>() {

    var context : Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_event_list,parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.view.event_title.text = list.get(position).name
        holder.view.event_date.text = list.get(position).startDate + "-" + list.get(position).endDate
        holder.view.event_users.text = list.get(position).users
        Picasso.get().load(list.get(position).pictureUrl).into(holder.view.event_image)

        holder.view.event_btn_about.setOnClickListener {
            var myFragment : DialogEventAbout = DialogEventAbout()
            myFragment.event = list.get(position)
            myFragment.supportFragmentManager = supportFragmentManager
            myFragment.show(supportFragmentManager, "DialogEventAbout")
        }

        holder.view.event_btn_run.setOnClickListener {
            var myFragment : DialogEventRun = DialogEventRun()
            myFragment.show(supportFragmentManager, "DialogEventRun")
        }

    }

    class Holder(val view: View) : RecyclerView.ViewHolder(view)
}