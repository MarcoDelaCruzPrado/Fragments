package com.silver.homework3.ui.dialog


import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.silver.homework3.R

class NoteDialogFragment : DialogFragment() {

    private var listener: DialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments?.getString("TITLE")
        val type = arguments?.getInt("TYPE")

        return AlertDialog.Builder(activity!!)
            .setTitle(title)
            .setPositiveButton("ACEPTAR") {_,_ ->
                listener?.onPositiveListener(null, type?:0)
            }
            .setNegativeButton("CANCELAR"){_,_ ->
                listener?.onNegativeListener(null, type?:0)
            }
            .create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is DialogListener)
        {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface DialogListener {
        fun onPositiveListener(any:Any?, type:Int)
        fun onNegativeListener(any:Any?, type:Int)
    }
}
