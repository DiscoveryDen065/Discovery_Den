package com.example.hackathon2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class alphabet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet )

        val alpha=Array<String>(26){""}
        var j=65
        for(i in 0..25){
            alpha[i]=Character.toString(j.toChar())
            j++
        }

//        grid=findViewById<>()
        val gridview: GridView = findViewById(R.id.gridview)

        val adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,alpha)
        gridview.adapter = adapter

        gridview.setOnItemClickListener { adapterView, view, i, l ->
            var intent = Intent(applicationContext,Alphabet2::class.java)
            intent.putExtra("name",alpha[i])
            startActivity(intent)

        }
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_alphabet)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}