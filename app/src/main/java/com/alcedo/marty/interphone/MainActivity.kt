package com.alcedo.marty.interphone

import android.app.ActivityOptions
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.PixelFormat
import android.app.Activity
import android.content.Context
import android.content.Context.WINDOW_SERVICE
import android.content.Intent
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
import android.media.MediaPlayer.OnCompletionListener
import android.view.*
import android.widget.ImageButton
import java.lang.Compiler.enable






class MainActivity : AppCompatActivity() {

    private var cpt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init
        cpt = 0
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //audio
        val mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.ring)
        mediaPlayer?.setLooping(true)

        //video
        val vid = findViewById(R.id.videoView) as VideoView
        vid.setMediaController(null)
        var path = ""
        var u = Uri.parse(path)
        vid.setVideoURI(u)
        vid.setVisibility(INVISIBLE)

        //Buttons
        val enableButton = findViewById(R.id.swipe_btn) as SwipeButton
        enableButton.setVisibility(INVISIBLE)
        val animationButton= findViewById(R.id.animation_view) as LottieAnimationView
        animationButton.setVisibility(INVISIBLE)
        val messagesButton = findViewById(R.id.imageBtn) as ImageButton

        //Calls
        enableButton.setOnStateChangeListener { active ->

            if (active) {
                animationButton.setVisibility(INVISIBLE)
                enableButton.setVisibility(INVISIBLE)
                mediaPlayer?.pause()

                when (cpt) {
                    0 -> path = "android.resource://com.alcedo.marty.interphone/"+R.raw.fetedetrop1
                    1 -> path = "android.resource://com.alcedo.marty.interphone/"+R.raw.fetedetrop2
                    2 -> path = "android.resource://com.alcedo.marty.interphone/"+R.raw.fetedetrop3
                    3 -> path = "android.resource://com.alcedo.marty.interphone/"+R.raw.fetedetrop4
                    else -> print("out of bounds video index")
                }
                cpt++
                u = Uri.parse(path)
                vid.setVideoURI(u)
                vid.setVisibility(VISIBLE)
                vid.start()
                enableButton.toggleState()
            }
        }

        vid.setOnCompletionListener {
            vid.setVisibility(INVISIBLE)
        }

        Handler().postDelayed({
            //Do something after 100ms
            //Icon ring animation appear with ring song
            //Slider appear
            mediaPlayer?.start()
            animationButton.setVisibility(VISIBLE)
            enableButton.setVisibility(VISIBLE)
        }, 5000)

        Handler().postDelayed({
            //Do something after 100ms
            //Icon ring animation appear with ring song
            //Slider appear
            mediaPlayer?.start()
            animationButton.setVisibility(VISIBLE)
            enableButton.setVisibility(VISIBLE)
        }, 30000)

        Handler().postDelayed({
            //Do something after 100ms
            //Icon ring animation appear with ring song
            //Slider appear
            mediaPlayer?.start()
            animationButton.setVisibility(VISIBLE)
            enableButton.setVisibility(VISIBLE)
        }, 70000)

        Handler().postDelayed({
            //Do something after 100ms
            //Icon ring animation appear with ring song
            //Slider appear
            mediaPlayer?.start()
            animationButton.setVisibility(VISIBLE)
            enableButton.setVisibility(VISIBLE)
        }, 90000)

        //My messages
        messagesButton.setOnClickListener {
            val intent = Intent(applicationContext, MessagesActivity::class.java)
            intent.putExtra("MY_KEY", cpt)
            startActivity(intent)
        }

    }
}