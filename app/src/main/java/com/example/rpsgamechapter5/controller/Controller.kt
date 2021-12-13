package com.example.rpsgamechapter5.controller

import android.util.Log
import com.example.rpsgamechapter5.R

class Controller(private val callback: Callback) : InterfaceController {
    override fun cekSuit(pemain1: CharSequence, komputer: CharSequence, playerSatu: String, playerDua: String){
        if (pemain1 == komputer) {
            Log.d("result", "draw")
            callback.hasil(R.string.draw, R.color.biru, R.color.white)
            callback.checkGame("DRAW")

        } else if (pemain1 == "batu" && komputer == "gunting" || pemain1 == "gunting" && komputer == "kertas" || pemain1 == "kertas" && komputer == "batu") {
            Log.d("result", "pemain 1 menang")
            callback.hasil(R.string.pemain1menang, R.color.hijau, R.color.white)
            callback.checkGame("$playerSatu WIN")

        } else {
            Log.d("result", "pemain 2 menang")
            callback.hasil(R.string.pemain2menang, R.color.hijau, R.color.white)
            callback.checkGame("$playerDua WIN")
        }
    }
}