package com.alcedo.marty.interphone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import com.ebanx.swipebtn.SwipeButton
import kotlinx.android.synthetic.main.activity_main.*

class MessagesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        //video
        val vid = findViewById(R.id.videoView2) as VideoView
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
        val playMessageButton1 = findViewById(R.id.playMessageButton1) as Button
        playMessageButton1.setOnClickListener {
            playMessageButton1.setVisibility(View.INVISIBLE)
            path = "android.resource://com.alcedo.marty.interphone/"+R.raw.fetedetrop1
            u = Uri.parse(path)
            vid.setVideoURI(u)
            vid.setVisibility(View.VISIBLE)
            vid.start()
        }

    }
}
