package com.alcedo.marty.interphone

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.ebanx.swipebtn.SwipeButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_messages.*

class MessagesActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_messages)

        //Init
        val cpt = intent.getExtras().getInt("MY_KEY")
        val vid = findViewById(R.id.videoView2) as VideoView
        val image = findViewById(R.id.image) as ImageView
        val image2 = findViewById(R.id.image2) as ImageView
        val image3 = findViewById(R.id.image3) as ImageView
        val image4 = findViewById(R.id.image4) as ImageView
        val title = findViewById(R.id.textView) as TextView
        val title2 = findViewById(R.id.textView3) as TextView
        val title3 = findViewById(R.id.textView5) as TextView
        val title4 = findViewById(R.id.textView7) as TextView
        val duration = findViewById(R.id.textView2) as TextView
        val duration2 = findViewById(R.id.textView4) as TextView
        val duration3 = findViewById(R.id.textView6) as TextView
        val duration4 = findViewById(R.id.textView8) as TextView
        val separator = findViewById(R.id.separator) as View
        val separator2 = findViewById(R.id.separator2) as View
        val separator3 = findViewById(R.id.separator3) as View
        val separator4 = findViewById(R.id.separator4) as View
        val playMessageButton1 = findViewById(R.id.playMessageButton1) as Button
        val playMessageButton2 = findViewById(R.id.playMessageButton2) as Button
        val playMessageButton3 = findViewById(R.id.playMessageButton3) as Button
        val playMessageButton4 = findViewById(R.id.playMessageButton4) as Button
        val backButton = findViewById(R.id.backButton) as ImageButton

        //Back button
        backButton.setOnClickListener {
            this.finish()
        }

        //Hide and show UI
        fun hideUI() {
            //block1
            image.setVisibility(View.INVISIBLE)
            title.setVisibility(View.INVISIBLE)
            duration.setVisibility(View.INVISIBLE)
            playMessageButton1.setVisibility(View.INVISIBLE)
            separator.setVisibility(View.INVISIBLE)
            //block2
            image2.setVisibility(View.INVISIBLE)
            title2.setVisibility(View.INVISIBLE)
            duration2.setVisibility(View.INVISIBLE)
            playMessageButton2.setVisibility(View.INVISIBLE)
            separator2.setVisibility(View.INVISIBLE)
            //block3
            image3.setVisibility(View.INVISIBLE)
            title3.setVisibility(View.INVISIBLE)
            duration3.setVisibility(View.INVISIBLE)
            playMessageButton3.setVisibility(View.INVISIBLE)
            separator3.setVisibility(View.INVISIBLE)
            //block4
            image4.setVisibility(View.INVISIBLE)
            title4.setVisibility(View.INVISIBLE)
            duration4.setVisibility(View.INVISIBLE)
            playMessageButton4.setVisibility(View.INVISIBLE)
            separator4.setVisibility(View.INVISIBLE)
        }

        fun showUI() {
            if (cpt >= 1) {
                image.setVisibility(View.VISIBLE)
                title.setVisibility(View.VISIBLE)
                duration.setVisibility(View.VISIBLE)
                playMessageButton1.setVisibility(View.VISIBLE)
                separator.setVisibility(View.VISIBLE)
            }
            if (cpt >= 2) {
                image2.setVisibility(View.VISIBLE)
                title2.setVisibility(View.VISIBLE)
                duration2.setVisibility(View.VISIBLE)
                playMessageButton2.setVisibility(View.VISIBLE)
                separator2.setVisibility(View.VISIBLE)
            }
            if (cpt >= 3) {
                image3.setVisibility(View.VISIBLE)
                title3.setVisibility(View.VISIBLE)
                duration3.setVisibility(View.VISIBLE)
                playMessageButton3.setVisibility(View.VISIBLE)
                separator3.setVisibility(View.VISIBLE)
            }
            if (cpt >= 4) {
                image4.setVisibility(View.VISIBLE)
                title4.setVisibility(View.VISIBLE)
                duration4.setVisibility(View.VISIBLE)
                playMessageButton4.setVisibility(View.VISIBLE)
                separator4.setVisibility(View.VISIBLE)
            }
        }

        hideUI()
        showUI()

        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //video
        vid.setMediaController(null)
        var path = ""
        var u = Uri.parse(path)
        vid.setVideoURI(u)
        vid.setVisibility(View.INVISIBLE)
        vid.setOnCompletionListener {
            vid.setVisibility(View.INVISIBLE)
        }

        //Buttons
        playMessageButton1.setOnClickListener {
            playMessageButton1.setVisibility(View.INVISIBLE)
            playMessageButton2.setVisibility(View.INVISIBLE)
            playMessageButton3.setVisibility(View.INVISIBLE)
            playMessageButton4.setVisibility(View.INVISIBLE)
            path = "android.resource://com.alcedo.marty.interphone/"+R.raw.fetedetrop1
            u = Uri.parse(path)
            vid.setVideoURI(u)
            vid.setVisibility(View.VISIBLE)
            vid.start()
        }

        playMessageButton2.setOnClickListener {
            playMessageButton1.setVisibility(View.INVISIBLE)
            playMessageButton2.setVisibility(View.INVISIBLE)
            playMessageButton3.setVisibility(View.INVISIBLE)
            playMessageButton4.setVisibility(View.INVISIBLE)
            path = "android.resource://com.alcedo.marty.interphone/"+R.raw.fetedetrop2
            u = Uri.parse(path)
            vid.setVideoURI(u)
            vid.setVisibility(View.VISIBLE)
            vid.start()
        }

        playMessageButton3.setOnClickListener {
            playMessageButton1.setVisibility(View.INVISIBLE)
            playMessageButton2.setVisibility(View.INVISIBLE)
            playMessageButton3.setVisibility(View.INVISIBLE)
            playMessageButton4.setVisibility(View.INVISIBLE)
            path = "android.resource://com.alcedo.marty.interphone/"+R.raw.fetedetrop3
            u = Uri.parse(path)
            vid.setVideoURI(u)
            vid.setVisibility(View.VISIBLE)
            vid.start()
        }

        playMessageButton4.setOnClickListener {
            playMessageButton1.setVisibility(View.INVISIBLE)
            playMessageButton2.setVisibility(View.INVISIBLE)
            playMessageButton3.setVisibility(View.INVISIBLE)
            playMessageButton4.setVisibility(View.INVISIBLE)
            path = "android.resource://com.alcedo.marty.interphone/"+R.raw.fetedetrop4
            u = Uri.parse(path)
            vid.setVideoURI(u)
            vid.setVisibility(View.VISIBLE)
            vid.start()
        }



    }

}
