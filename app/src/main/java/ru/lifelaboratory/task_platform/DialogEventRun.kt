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

class DialogEventRun : DialogFragment() {

    lateinit var scanQR: Button
    lateinit var addToTeam: Button

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var _view: View = getActivity()!!.getLayoutInflater().inflate(R.layout.dialog_event_run, null)

        this.scanQR = _view.findViewById(R.id.scan_qr)
        this.addToTeam = _view.findViewById(R.id.input_command_code)

        var alert = AlertDialog.Builder(this.activity!!)
        alert.setView(_view)

        this.scanQR.setOnClickListener {
            val scanner = IntentIntegrator(this.activity!!)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            scanner.setBeepEnabled(false)
            scanner.initiateScan()
        }

        this.addToTeam.setOnClickListener {
            val context = this
            val builder = AlertDialog.Builder(this.activity!!)
            builder.setTitle("Ввести код команды")

            val view = layoutInflater.inflate(R.layout.dialog_event_team_code, null)

            val categoryEditText = view.findViewById(R.id.team_code_input) as EditText

            builder.setView(view)

            builder.setPositiveButton(android.R.string.ok) { dialog, p1 ->
                val newCategory = categoryEditText.text
                var isValid = true
                if (newCategory.isBlank()) {
                    categoryEditText.error = "Error"
                    isValid = false
                }

                if (isValid) {
                    Toast.makeText(this.activity!!, newCategory, Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }

                if (isValid) {
                    dialog.dismiss()
                }
            }

            builder.setNegativeButton(android.R.string.cancel) { dialog, p1 ->
                dialog.cancel()
            }

            builder.show();
        }

        return alert.create()
    }
}