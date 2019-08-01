package com.alcedo.marty.interphone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.ebanx.swipebtn.SwipeButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_messages.*

class MessagesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        //Init
        val cpt = getIntent().getExtras().getInt("MY_KEY")
        val vid = findViewById(R.id.videoView2) as VideoView
        val image = findViewById(R.id.image) as ImageView
        val image2 = findViewById(R.id.image2) as ImageView
        val title = findViewById(R.id.textView) as TextView
        val title2 = findViewById(R.id.textView3) as TextView
        val duration = findViewById(R.id.textView2) as TextView
        val duration2 = findViewById(R.id.textView4) as TextView
        val separator = findViewById(R.id.separator) as View
        val separator2 = findViewById(R.id.separator2) as View
        val playMessageButton1 = findViewById(R.id.playMessageButton1) as Button
        val playMessageButton2 = findViewById(R.id.playMessageButton2) as Button

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
        }

        hideUI()
        showUI()


        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //video
        val mediaController = MediaController(this)
        mediaController.setAnchorView(vid)
        vid.setMediaController(mediaController)
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
            path = "android.resource://com.alcedo.marty.interphone/"+R.raw.fetedetrop1
            u = Uri.parse(path)
            vid.setVideoURI(u)
            vid.setVisibility(View.VISIBLE)
            vid.start()
        }

        playMessageButton2.setOnClickListener {
            playMessageButton1.setVisibility(View.INVISIBLE)
            playMessageButton2.setVisibility(View.INVISIBLE)
            path = "android.resource://com.alcedo.marty.interphone/"+R.raw.fetedetrop2
            u = Uri.parse(path)
            vid.setVideoURI(u)
            vid.setVisibility(View.VISIBLE)
            vid.start()
        }



    }

}
