package com.example.nasaproject.RecyclerView

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyViewPagerAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(
    supportFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    private val fragmentList: ArrayList<Fragment> = ArrayList()
    private val titleList: ArrayList<String> = ArrayList()

    //Fragment'in pozisyonunu veriyoruz
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    //Fragment sayısını veriyoruz
    override fun getCount(): Int {
        return fragmentList.size
    }

    //Bu fonksiyon ile Fragment'leri ve title'ları ekliyoruz
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }

    //Title'ların pozisyonunu veriyoruz
    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}