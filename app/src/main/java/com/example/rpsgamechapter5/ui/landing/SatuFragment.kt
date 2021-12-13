package com.example.rpsgamechapter5.ui.landing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.rpsgamechapter5.databinding.FragmentSatuBinding

class SatuFragment : Fragment() {

    private lateinit var binding: FragmentSatuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSatuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this)
            .load("https://raw.githubusercontent.com/fikridivas/asset-code-challenge-chapter-5/master/PNG/landing-page1.png") // url website
            .override(500, 500) // resize gambar
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.ivLandingPage1); // set image dari website
    }

}