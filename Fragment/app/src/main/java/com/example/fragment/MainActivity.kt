package com.example.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //建立 FragmentPagerAdapter 物件
        val adapter = ViewPagerAdapter(supportFragmentManager)
        //連接 Adapter，讓畫面(Fragment)與 ViewPager 建立關聯
        findViewById<ViewPager>(R.id.viewPager).adapter = adapter
    }
}
