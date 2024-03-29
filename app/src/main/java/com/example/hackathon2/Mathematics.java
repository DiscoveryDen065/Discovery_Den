package com.example.hackathon2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

public class Mathematics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematics);

        // Initialize image views
        ImageView challenge = findViewById(R.id.challenge);
        ImageView leader = findViewById(R.id.leader);
        ImageView home = findViewById(R.id.home);

        // Set click listeners for image views
        challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Mathematics.this, "Challenge", Toast.LENGTH_SHORT).show();
            }
        });

        leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Mathematics.this, "Leader", Toast.LENGTH_SHORT).show();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mathematics.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button learn = findViewById(R.id.learn);
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mathematics.this, Mathgeneral.class);
                startActivity(intent);
            }
        });
    }

    public void openWebsite(View view) {
        String url = "https://elgoog.im/2048/"; // Replace this with your website URL
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}