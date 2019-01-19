package ru.lifelaboratory.task_platform

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator

class DialogEventTeamCode : DialogFragment() {

    lateinit var teamCode : EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var _view: View = getActivity()!!.getLayoutInflater().inflate(R.layout.dialog_event_team_code, null)

        this.teamCode = _view.findViewById(R.id.team_code_input)

        var alert = AlertDialog.Builder(this.activity!!)
        alert.setView(_view)

        return alert.create()
    }
}