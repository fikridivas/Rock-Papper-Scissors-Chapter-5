package com.example.rpsgamechapter5.ui.landing

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.rpsgamechapter5.databinding.FragmentTigaBinding
import com.example.rpsgamechapter5.ui.menu.MainActivity

class TigaFragment : Fragment() {
    private lateinit var binding: FragmentTigaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this)
            .load("https://raw.githubusercontent.com/fikridivas/asset-code-challenge-chapter-5/master/PNG/landing-page3.png") // url website
            .override(500, 500) // resize gambar
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.ivLandingPage3); // set image dari website

        binding.etNama.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tombolNext.isVisible = s.toString().trim().isNotEmpty()
            }
        })
        binding.tombolNext.setOnClickListener {
            if (binding.etNama.text.isNotEmpty()){
                val nama = binding.etNama.text.toString()
                val intent = Intent(activity, MainActivity::class.java)
                intent.putExtra("name", nama)
                startActivity(intent)
            }
        }

//
    }


}