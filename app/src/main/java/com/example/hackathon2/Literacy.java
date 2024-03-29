package com.example.hackathon2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Literacy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_literacy);

//        ImageView profileIcon = findViewById(R.id.profileIcon);
//        profileIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Perform action when profile icon is clicked
//                Toast.makeText(MainActivity.this, "Profile icon clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView challenge = findViewById(R.id.challenge);
        challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when profile icon is clicked
                Toast.makeText(Literacy.this, "challenge", Toast.LENGTH_SHORT).show();
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView leader = findViewById(R.id.leader);
        leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when profile icon is clicked
                Toast.makeText(Literacy.this, "challenge", Toast.LENGTH_SHORT).show();
//               Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//               startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Literacy.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Literacy.this, Englishquiz.class);
                startActivity(intent);
            }
        });

        Button learn = findViewById(R.id.learn);
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Literacy.this, literacygeneral.class);
                startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button story = findViewById(R.id.story);
        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Literacy.this, storygeneral.class);
                startActivity(intent);
            }
        });

    }
}