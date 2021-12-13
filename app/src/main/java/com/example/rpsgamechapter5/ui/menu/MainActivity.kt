package com.example.rpsgamechapter5.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.rpsgamechapter5.databinding.ActivityMainBinding
import com.example.rpsgamechapter5.ui.player.CpuActivity
import com.example.rpsgamechapter5.ui.player.PemainActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageVsPemain = binding.ivPemainVsPemain
        Glide.with(this)
            .load("https://raw.githubusercontent.com/fikridivas/asset-code-challenge-chapter-5/master/PNG/landing-page1.png") // url website
            .override(500, 500) // resize gambar
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageVsPemain); // set image dari website

        val imageVsCpu = binding.ivPemainVsCpu
        Glide.with(this)
            .load("https://raw.githubusercontent.com/fikridivas/asset-code-challenge-chapter-5/master/PNG/landing-page2.png") // url website
            .override(500, 500) // resize gambar
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageVsCpu); // set image dari website

        val vspemain = "vs Pemain"
        val vscpu = "vs CPU"
        val nama = intent.getStringExtra("name")
        binding.tvPemainVsPemain.text = nama.plus(" ").plus(vspemain)
        binding.tvPemainVsCpu.text = nama.plus(" ").plus(vscpu)

        binding.ivPemainVsPemain.setOnClickListener {
            val intent = Intent(this, PemainActivity::class.java)
            intent.putExtra("name", nama)
            startActivity(intent)
        }

        binding.ivPemainVsCpu.setOnClickListener {
            val intentCpu = Intent(this, CpuActivity::class.java)
            intentCpu.putExtra("name", nama)
            startActivity(intentCpu)
        }


        Snackbar.make(binding.mainActivity,
            "Selamat Datang $nama",
            Snackbar.LENGTH_LONG).setAction("Close"){
                Toast.makeText(this, "Silahkan pilih menu permainan", Toast.LENGTH_SHORT).show()
        }.show()


//        cara menggunakan glide
//        val image = findViewById<ImageView>(R.id.ivImage)
//        Glide.with(this)
//            .load("https://raw.githubusercontent.com/fikridivas/asset-code-challenge-chapter-5/master/PNG/landing-page1.png") // url website
//            .override(200, 200) // resize gambar
//            .into(image); // set image dari website
    }
}