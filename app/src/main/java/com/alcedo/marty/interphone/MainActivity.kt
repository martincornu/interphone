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
import com.airbnb.lottie.LottieAnimationView
import com.ebanx.swipebtn.OnStateChangeListener
import com.ebanx.swipebtn.SwipeButton
import android.media.MediaPlayer.OnCompletionListener
import android.view.*
import java.lang.Compiler.enable
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.widget.*

//Version 2
class MainActivity : AppCompatActivity() {

    private var counter = 0
    private var hasAnswer = false
    private var cpt = 0
    private var hour = 8
    private var counterText : TextView? = null
    private var minuteUpdateReceiver : BroadcastReceiver? = null
    private var mediaPlayer: MediaPlayer? = null

    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init
        cpt = 0
        counterText = findViewById(R.id.txt_time)

        //video
        val vid = findViewById(R.id.videoView) as VideoView
        vid.setMediaController(null)
        var path = ""
        var u = Uri.parse(path)
        vid.setVideoURI(u)
        vid.setVisibility(INVISIBLE)

        //Buttons
        val enableButton = findViewById(R.id.swipe_btn) as SwipeButton
        enableButton?.setVisibility(INVISIBLE)
        val animationButton= findViewById(R.id.animation_view) as LottieAnimationView
        animationButton.setVisibility(INVISIBLE)
        val messagesButton = findViewById(R.id.imageBtn) as ImageButton

        //Calls
        enableButton?.setOnStateChangeListener { active ->

            if (active) {
                hasAnswer = true
                animationButton.setVisibility(INVISIBLE)
                enableButton?.setVisibility(INVISIBLE)
                if (mediaPlayer?.isPlaying() == true) {
                    mediaPlayer?.pause()
                }

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
                enableButton?.toggleState()
            }
        }

        vid.setOnCompletionListener {
            vid.setVisibility(INVISIBLE)
            if (!hasAnswer) {
                mediaPlayer?.start()
            }
        }

        //Call at 15min
        Handler().postDelayed({
            //Do something after 100ms
            //Icon ring animation appear with ring song
            //Slider appear
            mediaPlayer?.start()
            animationButton.setVisibility(VISIBLE)
            enableButton?.setVisibility(VISIBLE)
        }, 900000) //900000

        //Call at 30min
        Handler().postDelayed({
            //Do something after 100ms
            //Icon ring animation appear with ring song
            //Slider appear
            if (hasAnswer) {
                hasAnswer = false
                if (!vid.isShown()) {
                    mediaPlayer?.start()
                }
                animationButton.setVisibility(VISIBLE)
                enableButton?.setVisibility(VISIBLE)
            }

        }, 1800000) //1800000

        //Call at 45min
        Handler().postDelayed({
            //Do something after 100ms
            //Icon ring animation appear with ring song
            //Slider appear
            if (hasAnswer) {
                hasAnswer = false
                if (!vid.isShown()) {
                    mediaPlayer?.start()
                }
                animationButton.setVisibility(VISIBLE)
                enableButton?.setVisibility(VISIBLE)
            }
        }, 2700000) //2700000

        //Call at 55min
        Handler().postDelayed({
            //Do something after 100ms
            //Icon ring animation appear with ring song
            //Slider appear
            if (hasAnswer) {
                hasAnswer = false
                if (!vid.isShown()) {
                    mediaPlayer?.start()
                }
                animationButton.setVisibility(VISIBLE)
                enableButton?.setVisibility(VISIBLE)
            }
        }, 3300000) //3300000

        //My messages
        messagesButton.setOnClickListener {
            val intent = Intent(applicationContext, MessagesActivity::class.java)
            intent.putExtra("MY_KEY", cpt)
            startActivity(intent)
        }

    }

    //Update minutes for time
    fun startMinuteUpdater() {
        var intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_TIME_TICK)
        minuteUpdateReceiver = object : BroadcastReceiver() {
            override fun onReceive(contxt: Context?, intent: Intent?) {
                counter++
                var text = "0" + hour + ":0" + counter
                if (counter >= 10 && counter < 60) {
                    text = "0" + hour + ":" + counter
                } else if (counter >= 60) {
                    counter = 0
                    hour++
                    text = "0" + hour + ":00"
                }
                counterText?.setText(text)
            }
        }
        registerReceiver(minuteUpdateReceiver, intentFilter)
    }

    override fun onStart() {
        super.onStart()
        startMinuteUpdater()
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.ring)
            mediaPlayer?.setLooping(false)
            mediaPlayer?.start()
            mediaPlayer?.pause()
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(minuteUpdateReceiver)
    }

    override fun onStop() {
        super.onStop()
        if (mediaPlayer != null) {
            mediaPlayer?.pause()
        }
    }
}