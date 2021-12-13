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
import com.example.rpsgamechapter5.databinding.ActivityCpuBinding
import com.example.rpsgamechapter5.ui.dialog.HasilDialogFragment

@RequiresApi(Build.VERSION_CODES.M)
open class CpuActivity : AppCompatActivity(), Callback, CallbackDialog {
    private lateinit var binding: ActivityCpuBinding
    private var hasilPemainSatu = ""
    private var hasilPemainDua = ""
    val nama by lazy { intent.getStringExtra("name") }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCpuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pemain1.text = nama
        val namaPemain1 = nama.toString()
        val namaPemain2 = "CPU"

        val btnPemain1 = arrayOf(
            binding.ivRockPemain1,
            binding.ivPaperPemain1,
            binding.ivScissorPemain1
        )
        val btnCpu = arrayOf(
            binding.ivRockCom,
            binding.ivPaperCom,
            binding.ivScissorCom
        )

        val controllerVsCpu = Controller(this)
        btnPemain1.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val dataCpu = btnCpu.random()
                Log.d(
                    "${btnPemain1[index].contentDescription} ${btnCpu[index].contentDescription}",
                    "Clicked"
                )
                dataCpu.setBackgroundResource(R.drawable.bg_image)
                disableClick(false)
                hasilPemainSatu = btnPemain1[index].contentDescription.toString()
                hasilPemainDua = dataCpu.contentDescription.toString()
                controllerVsCpu.cekSuit(
                    hasilPemainSatu,
                    hasilPemainDua,
                    namaPemain1,
                    namaPemain2
                )
                Toast.makeText(this, btnPemain1[index].contentDescription, Toast.LENGTH_SHORT)
                    .show()
                btnPemain1.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPemain1[index].setBackgroundResource(R.drawable.bg_image)
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

    private fun disableClick(isEnable: Boolean) {
        binding.ivPaperPemain1.isEnabled = isEnable
        binding.ivRockPemain1.isEnabled = isEnable
        binding.ivScissorPemain1.isEnabled = isEnable
    }

    override fun hasil(text: Int, background: Int, textcolor: Int) {
        binding.tvResult.text = getString(text).replace("Pemain 1", nama.toString())
        binding.tvResult.setBackgroundColor(getColor(background))
        binding.tvResult.setTextColor(getColor(textcolor))
        binding.tvResult.setTextSize(30f)

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
        binding.ivRockCom.setBackgroundResource(background)
        binding.ivPaperCom.setBackgroundResource(background)
        binding.ivScissorCom.setBackgroundResource(background)
        binding.tvResult.text = getString(R.string.vs)
        binding.tvResult.setBackgroundColor(getColor(android.R.color.transparent))
        binding.tvResult.setTextColor(getColor(R.color.merah))
        binding.tvResult.setTextSize(16f)
        disableClick(true)
        hasilPemainSatu = ""
        hasilPemainDua = ""
    }


}