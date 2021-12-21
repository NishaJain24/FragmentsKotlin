package com.nishajain.fragmentskotlin.ImageOpacity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import com.nishajain.fragmentskotlin.R

class OpacityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opacity)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val imageView = findViewById<ImageView>(R.id.image)

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                //This is for set the opacity to progress (i.e. opacity(40%))
                imageView.setAlpha(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
//          Write your custom code (When you start the track)

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
//           Write your own custom code on stop of tracking
             }

        })
    }
}
