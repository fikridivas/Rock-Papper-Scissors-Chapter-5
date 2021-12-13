package com.example.rpsgamechapter5.ui.landing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.rpsgamechapter5.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewpager2)
        val fragment: ArrayList<Fragment> = arrayListOf(
            SatuFragment(),
            DuaFragment(),
            TigaFragment()
        )
        val adapter = ViewPagerAdapter(
            fragment, this
        )
        viewPager2.adapter = adapter
        dotsIndicator.setViewPager2(viewPager2)
    }
}