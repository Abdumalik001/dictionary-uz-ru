package com.example.uzb_rus

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.lifecycle.ViewModelProvider
import com.example.uzb_rus.viewmodel.WordViewModel

class SplashActivity : AppCompatActivity() {
    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#17000000")
        setContentView(R.layout.activity_splash);



    }
}