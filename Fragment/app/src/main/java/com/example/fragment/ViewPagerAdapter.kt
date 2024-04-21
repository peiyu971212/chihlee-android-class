package com.example.fragment

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    //回傳對應位置的 Fragment，決定頁面的呈現順序
    override fun getItem(position: Int) = when(position) {
        0 -> FirstFragment() //第一頁要呈現的 Fragment
        1 -> SecondFragment() //第二頁要呈現的 Fragment
        else -> ThirdFragment() //第三頁要呈現的 Fragment
    }
    //回傳 Fragment 頁數
    override fun getCount() = 3
}
