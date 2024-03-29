package com.example.hackathon2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class storygeneral extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storygeneral);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button alphabet = findViewById(R.id.button);
        alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(storygeneral.this,storyvideo.class);
                startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button v = findViewById(R.id.button2);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(storygeneral.this,storyquiz.class);
                startActivity(intent);
            }
        });
    }
}