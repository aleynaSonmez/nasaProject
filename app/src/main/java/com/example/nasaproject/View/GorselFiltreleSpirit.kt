package com.example.nasaproject.View

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasaproject.R
import com.example.nasaproject.RecyclerView.AllAdapter
import com.example.nasaproject.ViewModel.MainViewModel
import kotlinx.android.synthetic.main.gorsel_filtrele_layout.*

class GorselFiltreleSpirit : AppCompatActivity(){
    private lateinit var viewmodel: MainViewModel
    private lateinit var GET: SharedPreferences
    private lateinit var SET: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gorsel_filtrele_layout)
        GET = getSharedPreferences(packageName, MODE_PRIVATE)
        SET = GET.edit()
        viewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewmodel.getDataFromApiS()
        getDat()
    }

    private fun getDat() {
        viewmodel.nasa_data.observe(this, Observer { data ->
            data?.let {
                recycler_view.adapter = AllAdapter(data.photos)
                recycler_view.layoutManager = LinearLayoutManager(this)
                recycler_view.setHasFixedSize(true)
                //tabs.getTabAt(0)!!.setText(data.photos!![0].camera.toString())
                //->birinci dünya tarihini çekiyor.
                //tabs içerisine ya da rc içine olmadıkça verileri bütün olarak
                //çekebiliyorum.


            }
        })
    }

    /*override fun onItemClick(position: Int) {

        Toast.makeText(this,"ıtem $position cliked", Toast.LENGTH_SHORT).show()
        var i = Intent(this, PopupMain::class.java)
        startActivity(i)
    }*/


}