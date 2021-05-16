package com.example.nasaproject.View

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.nasaproject.R

class SplashScreen : AppCompatActivity() {
    lateinit var mActivity: SplashScreen
    var progressBar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        progressBar = findViewById<ProgressBar>(R.id.progress_circular)
        mActivity = this
        val splashScreen = splashScreen()
        splashScreen.start()
    }

   inner class splashScreen : Thread() {
        override fun run() {
            try {
                sleep((1000 * 3).toLong())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            val intent = Intent(mActivity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}