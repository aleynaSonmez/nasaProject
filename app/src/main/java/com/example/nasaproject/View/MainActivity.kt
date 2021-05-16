@file:Suppress("DEPRECATION")

package com.example.nasaproject.View

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.nasaproject.R
import com.example.nasaproject.RecyclerView.MyViewPagerAdapter
import com.example.nasaproject.ViewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

private var TAG = "MainActivity"

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel: MainViewModel
    private lateinit var GET: SharedPreferences
    private lateinit var SET: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GET = getSharedPreferences(packageName, MODE_PRIVATE)
        SET = GET.edit()
        viewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewmodel.getDataFromApi()
        getDat()

    }
    private fun getDat() {

        viewmodel.nasa_data.observe(this, Observer { data ->
            data?.let {
                val adapter = MyViewPagerAdapter(supportFragmentManager)
                adapter.addFragment(CuriosityFragment(), "Curiosity")
                adapter.addFragment(OpportunityFragment(), "Opportunity")
                adapter.addFragment(SpiritFragment(), "Spirit")
                viewPager.adapter = adapter
                tabs.setupWithViewPager(viewPager)
                if(tabs.getTabAt(0)?.isSelected == true)
                {
                    tabs.getTabAt(0)!!.setText("Curiosity")
                }
                if(tabs.getTabAt(1)?.isSelected == true)
                {
                    tabs.getTabAt(1)!!.setText("Opportunity")
                }
                if(tabs.getTabAt(2)?.isSelected == true)
                {
                    tabs.getTabAt(2)!!.setText("Spirit")
                }

                //tabs.getTabAt(0)!!.setText(data.photos!![0].camera.toString())
                //->birinci dünya tarihini çekiyor.
                //tabs içerisine ya da rc içine olmadıkça verileri bütün olarak
                //çekebiliyorum.

            }
        })
    }


}