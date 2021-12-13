package com.example.rpsgamechapter5.ui.player

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.rpsgamechapter5.R
import com.example.rpsgamechapter5.controller.Callback
import com.example.rpsgamechapter5.controller.CallbackDialog
import com.example.rpsgamechapter5.controller.Controller
import com.example.rpsgamechapter5.databinding.ActivityPemainBinding
import com.example.rpsgamechapter5.ui.dialog.HasilDialogFragment

@RequiresApi(Build.VERSION_CODES.M)
open class PemainActivity : AppCompatActivity(), Callback, CallbackDialog {
    private lateinit var binding: ActivityPemainBinding
    private var hasilPemainSatu = ""
    private var hasilPemainDua = ""
    val nama by lazy { intent.getStringExtra("name") }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPemainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pemain1.text = nama
        val namaPemain1 = nama.toString()
        val namaPemain2 = "Pemain 2"

        val btnPemain1 = arrayOf(
            binding.ivPaperPemain1,
            binding.ivRockPemain1,
            binding.ivScissorPemain1
        )

        val btnPemain2 = arrayOf(
            binding.ivPaperPemain2,
            binding.ivRockPemain2,
            binding.ivScissorPemain2
        )

        val controllerPemainvsPemain = Controller(this)
        btnPemain1.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                Log.d(
                    "${btnPemain1[index].contentDescription}",
                    "Clicked"
                )
                hasilPemainSatu = btnPemain1[index].contentDescription.toString()
                disableClickPemain1(false)
                Toast.makeText(this, btnPemain1[index].contentDescription, Toast.LENGTH_SHORT)
                    .show()
                btnPemain1.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPemain1[index].setBackgroundResource(R.drawable.bg_image)
            }
        }

        btnPemain2.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val mydialog = HasilDialogFragment()
                Log.d(
                    "${btnPemain2[index].contentDescription}",
                    "Clicked"
                )
                hasilPemainDua = btnPemain2[index].contentDescription.toString()
                disableClickPemain2(false)
                if (hasilPemainSatu != "") {
                    controllerPemainvsPemain.cekSuit(
                        hasilPemainSatu,
                        hasilPemainDua,
                        namaPemain1,
                        namaPemain2
                    )
                    Toast.makeText(this, btnPemain2[index].contentDescription, Toast.LENGTH_SHORT)
                        .show()
                    btnPemain2.forEach {
                        it.setBackgroundResource(android.R.color.transparent)
                    }
                    btnPemain2[index].setBackgroundResource(R.drawable.bg_image)
                } else {
                    btnPemain2[index].setBackgroundResource(android.R.color.transparent)
                    Toast.makeText(
                        this,
                        "Silahkan restart dan pilih pilihan pemain 1",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        binding.ivRestart.setOnClickListener {
            Toast.makeText(this, "Mulai ulang permainan", Toast.LENGTH_SHORT).show()
            Log.d("reset", "Clicked")
            hasil(R.string.vs, android.R.color.transparent, R.color.merah)
            hasilPemainSatu = ""
            hasilPemainDua = ""
            restartGame(android.R.color.transparent, "", "")
        }

        binding.btnCloseSilang.setOnClickListener {
            finish()
        }
    }

    private fun disableClickPemain1(isEnable: Boolean) {
        binding.ivPaperPemain1.isEnabled = isEnable
        binding.ivRockPemain1.isEnabled = isEnable
        binding.ivScissorPemain1.isEnabled = isEnable
    }

    private fun disableClickPemain2(isEnable: Boolean) {
        binding.ivPaperPemain2.isEnabled = isEnable
        binding.ivRockPemain2.isEnabled = isEnable
        binding.ivScissorPemain2.isEnabled = isEnable
    }

    override fun hasil(text: Int, background: Int, textcolor: Int) {
        binding.tvResult.text = getString(text).replace("Pemain 1", nama.toString())
        binding.tvResult.setBackgroundColor(getColor(background))
        binding.tvResult.setTextColor(getColor(textcolor))
        binding.tvResult.setTextSize(16f)
    }

    override fun checkGame(hasilGame: String) {
        val resultDialog = HasilDialogFragment()
        val bundle = Bundle()
        bundle.putString("hasil", hasilGame)
        resultDialog.arguments = bundle
        resultDialog.show(supportFragmentManager, "DialogResult")

    }

    override fun restartGame(background: Int, hasilPlayerSatu: String, hasilPlayerDua: String) {
        binding.ivRockPemain1.setBackgroundResource(background)
        binding.ivPaperPemain1.setBackgroundResource(background)
        binding.ivScissorPemain1.setBackgroundResource(background)
        binding.ivRockPemain2.setBackgroundResource(background)
        binding.ivPaperPemain2.setBackgroundResource(background)
        binding.ivScissorPemain2.setBackgroundResource(background)
        binding.tvResult.text = getString(R.string.vs)
        binding.tvResult.setBackgroundColor(getColor(android.R.color.transparent))
        binding.tvResult.setTextColor(getColor(R.color.merah))
        binding.tvResult.setTextSize(16f)
        disableClickPemain1(true)
        disableClickPemain2(true)
        hasilPemainSatu = ""
        hasilPemainDua = ""
    }
}