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
import android.media.MediaPlayer
import android.net.Uri
import android.os.Handler
import androidx.core.content.ContextCompat.getSystemService
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.airbnb.lottie.LottieAnimationView
import com.ebanx.swipebtn.OnStateChangeListener
import com.ebanx.swipebtn.SwipeButton


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.ring)

        val m = MediaController(this)
        val vid = findViewById(R.id.videoView) as VideoView
        vid.setMediaController(m)
        val path = "android.resource://com.alcedo.marty.interphone/"+R.raw.boxe
        val u = Uri.parse(path)
        vid.setVideoURI(u)
        vid.setVisibility(INVISIBLE)

        val enableButton = findViewById(R.id.swipe_btn) as SwipeButton
        enableButton.setVisibility(INVISIBLE)

        val animationButton= findViewById(R.id.animation_view) as LottieAnimationView
        animationButton.setVisibility(INVISIBLE)

        enableButton.setOnStateChangeListener { active ->

            if (active) {
                animationButton.setVisibility(INVISIBLE)
                enableButton.setVisibility(INVISIBLE)
                mediaPlayer?.reset()
                mediaPlayer?.release()
            }
        }

        Handler().postDelayed({
            //Do something after 100ms
            Toast.makeText(getApplicationContext(), "Bouh!", Toast.LENGTH_SHORT).show()
            //Icon ring animation appear with ring song
            //Slider appear
            mediaPlayer?.start()
            animationButton.setVisibility(VISIBLE)
            enableButton.setVisibility(VISIBLE)
        }, 5000)

    }
}