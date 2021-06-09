package com.tientienstudio.guideclashofclans

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ErrorDialogFragment : DialogFragment() {
    interface NoticeDialogListener {
        fun onDialogTryAgainClick()
        fun onDialogCancelClick()
    }

    // Use this instance of the interface to deliver action events
    var mListener: NoticeDialogListener? = null
    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = activity as NoticeDialogListener
        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface, throw exception
            throw ClassCastException(
                activity.toString()
                        + " must implement NoticeDialogListener"
            )
        }
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the Builder class for convenient dialog construction
        val builder: AlertDialog.Builder = AlertDialog.Builder(context!!)
        builder.setMessage(R.string.network_error)
            .setPositiveButton(R.string.try_again,
                DialogInterface.OnClickListener { dialog, id ->
                    // FIRE ZE MISSILES!
                    dialog.dismiss()
                    mListener?.onDialogTryAgainClick()
                })
            .setNegativeButton(R.string.cancel,
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                    dialog.dismiss()
                    mListener?.onDialogCancelClick()
                })
        // Create the AlertDialog object and return it
        return builder.create()
    }
}