package com.example.rpsgamechapter5.ui.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.rpsgamechapter5.R
import com.example.rpsgamechapter5.controller.CallbackDialog
import java.lang.Exception

class HasilDialogFragment: DialogFragment() {
    private var callDialog: CallbackDialog? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.dialog_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnMainLagi = view.findViewById<Button>(R.id.btnMainLagi)
        val HasilMain = view.findViewById<TextView>(R.id.tvHasilSuit)
        val btnKembali = view.findViewById<Button>(R.id.btnKembali)

        btnMainLagi.setOnClickListener {
            dismiss()
            callDialog?.restartGame(android.R.color.transparent, "", "")
        }
        if (arguments != null){
            val hasil = arguments?.getString("hasil", "")
            HasilMain.text = hasil
        }

        btnKembali.setOnClickListener {
            activity?.finish()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callDialog = context as CallbackDialog
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}