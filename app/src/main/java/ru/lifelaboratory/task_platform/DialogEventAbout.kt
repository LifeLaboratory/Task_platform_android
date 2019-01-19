package ru.lifelaboratory.task_platform

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import ru.lifelaboratory.task_platform.REST.Event

class DialogEventAbout : DialogFragment() {

    lateinit var eventTitle : TextView
    lateinit var eventImage : ImageView
    lateinit var eventDescription : TextView
    lateinit var eventUsers : TextView
    lateinit var eventDate : TextView
    lateinit var eventRun : Button
    lateinit var event : Event
    lateinit var supportFragmentManager: FragmentManager

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var _view: View = getActivity()!!.getLayoutInflater().inflate(R.layout.dialog_event_about, null)

        this.eventTitle = _view.findViewById(R.id.event_title)
        this.eventTitle.text = event.name

        this.eventImage = _view.findViewById(R.id.event_image)
        Picasso.get().load(event.pictureUrl).into(this.eventImage)

        this.eventDescription = _view.findViewById(R.id.event_description)
        this.eventDate = _view.findViewById(R.id.event_date)
        this.eventUsers = _view.findViewById(R.id.event_users)
        this.eventRun = _view.findViewById(R.id.event_btn_add)

        this.eventDescription.text = event.description
        this.eventDate.text = event.startDate + " - " + event.endDate
        this.eventUsers.text = event.users

        this.eventRun.setOnClickListener {
            var myFragment : DialogEventRun = DialogEventRun()
            myFragment.show(supportFragmentManager, "DialogEventRun")
        }

        var alert = AlertDialog.Builder(this.activity!!)
        alert.setView(_view)

        return alert.create()
    }
}