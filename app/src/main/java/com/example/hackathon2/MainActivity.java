package com.example.hackathon2;

import android.annotation.SuppressLint;
//import android.content.Intent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth=FirebaseAuth.getInstance();

        Button mathematicsButton = findViewById(R.id.mathematicsButton);
        mathematicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Mathematics.class);
                startActivity(intent);
            }
        });

        Button literacyButton = findViewById(R.id.literacyButton);
        literacyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Literacy.class);
                startActivity(intent);
            }
        });

        Button logicalButton = findViewById(R.id.logicalButton);
        logicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Logical.class);
                startActivity(intent);
            }
        });

        ImageView profileIcon = findViewById(R.id.profileIcon);
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView tour = findViewById(R.id.challenge);
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "tournament", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView comm = findViewById(R.id.community);
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "community", Toast.LENGTH_SHORT).show();
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView leader = findViewById(R.id.leader);
        leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(MainActivity.this, "leaderboard", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, MainActivity.class);
               startActivity(intent);
            }
        });


        ImageView chatbot = findViewById(R.id.chatbot);
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage();
            }
        });



    }
    public void openWebPage(){
        String url = "https://chatbot-eutgdfckgd2i4prevvtux8.streamlit.app/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
