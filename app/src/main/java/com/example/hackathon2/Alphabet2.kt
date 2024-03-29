package com.example.hackathon2

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hackathon2.R.layout
import java.util.Locale

class Alphabet2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(layout.activity_alphabet2)

        var name= intent.getStringExtra("name")?.lowercase()
        Toast.makeText(applicationContext,name,Toast.LENGTH_LONG).show()

        var id=resources.getIdentifier(name,"drawable",packageName)

        val imageView: ImageView = findViewById(R.id.imageView2)

        imageView.setImageResource(id)

        var mid = resources.getIdentifier(name,"raw",packageName)
        var mp = MediaPlayer.create(applicationContext,mid)
        mp.start()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}