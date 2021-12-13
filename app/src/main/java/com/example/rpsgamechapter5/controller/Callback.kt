package com.example.rpsgamechapter5.controller

interface Callback {
    fun hasil(text: Int, background: Int, textcolor: Int)
    fun checkGame(hasilGame: String)
}