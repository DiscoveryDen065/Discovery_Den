package com.example.hackathon2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.android.gms.tasks.OnCompleteListener;

import androidx.annotation.NonNull;

//import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity2 extends Activity {

    TextInputEditText editTextEmail, editTextPassword;
    Button buttonlog;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAuth=FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonlog=findViewById(R.id.tvLogin);
        buttonlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, pass;
                email = String.valueOf(editTextEmail.getText());
                pass = String.valueOf(editTextPassword.getText());

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(MainActivity2.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainActivity2.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }


                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity2.this, "Authentication successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity2.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, Registration.class);
                startActivity(intent);
            }
        });

    }
}