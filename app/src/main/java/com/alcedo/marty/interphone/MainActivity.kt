package com.alcedo.marty.interphone

import android.app.ActivityOptions
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.MotionEvent
import android.view.ViewGroup
import android.graphics.PixelFormat
import android.view.Gravity
import android.app.Activity
import android.content.Context
import android.content.Context.WINDOW_SERVICE
import android.net.Uri
import android.os.Handler
import androidx.core.content.ContextCompat.getSystemService
import android.util.Log
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.ebanx.swipebtn.OnStateChangeListener
import com.ebanx.swipebtn.SwipeButton


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val m = MediaController(this)
        val vid = findViewById(R.id.videoView) as VideoView
        vid.setMediaController(m)
        val path = "android.resource://com.alcedo.marty.interphone/"+R.raw.boxe
        val u = Uri.parse(path)
        vid.setVideoURI(u)
        vid.start()

        val enableButton = findViewById(R.id.swipe_btn) as SwipeButton
        enableButton.setOnStateChangeListener { active ->
            Toast.makeText(
                this@MainActivity,
                "State: $active",
                Toast.LENGTH_SHORT
            ).show()
        }

        Handler().postDelayed({
            //Do something after 100ms
            Toast.makeText(getApplicationContext(), "Bouh!", Toast.LENGTH_SHORT).show()
            //Icon ring animation appear with ring song
            //Slider appear
        }, 1000)

        Handler().postDelayed({
            //Do something after 100ms
            Toast.makeText(getApplicationContext(), "Bah!", Toast.LENGTH_SHORT).show();
        }, 5000)


    }
}