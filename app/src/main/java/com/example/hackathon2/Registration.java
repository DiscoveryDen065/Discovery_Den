package com.example.hackathon2;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Registration extends AppCompatActivity {


    //    private EditText editTextRegisterFullName, editTextRegisterEmail, editTextRegisterDOB, editTextRegisterMobile, editTextRegisterPwd,
//            editTextRegisterConfirmPwd;
//    FirebaseDatabase database;
//    DatabaseReference reference;
//
//    private ProgressBar progressBar;
//    private RadioGroup radioGroupRegisterGender;
//    private RadioButton radioGroupRegisterGenderSelected;
//

    TextInputEditText editTextEmail, editTextPassword, editTextcpass;
    Button buttonreg;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth=FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonreg=findViewById(R.id.register);
        buttonreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, pass;
                email = String.valueOf(editTextEmail.getText());
                pass = String.valueOf(editTextPassword.getText());

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Registration.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(Registration.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Registration.this, "Authentication successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(Registration.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
//                if(TextUtils.isEmpty(cpass)){
//                    Toast.makeText(Registration.this,"Enter confirm password",Toast.LENGTH_SHORT).show();
//                    return;
            }
        });


    }
}
//        getSupportActionBar().setTitle("Register");
//        progressBar = findViewById(R.id.progressBar);
//        Toast.makeText(Registration.this, "You can register", Toast.LENGTH_LONG).show();
//        editTextRegisterFullName = findViewById(R.id.editText_register_full_name);
//        editTextRegisterEmail = findViewById(R.id.editText_register_email);
//        editTextRegisterDOB = findViewById(R.id.editText_register_dob);
//        editTextRegisterMobile = findViewById(R.id.editText_register_mobile);
//        editTextRegisterPwd = findViewById(R.id.editText_register_password);
//        editTextRegisterConfirmPwd = findViewById(R.id.editText_register_confirmpassword);
//        //radio button
//        radioGroupRegisterGender = findViewById(R.id.radio);
//        radioGroupRegisterGender.clearCheck();
//        Button buttonRegister = (Button) findViewById(R.id.register);
//        buttonRegister.setOnClickListener(new View.OnClickListener() {
//                                              @Override
//                                              public void onClick(View v) {
//                                                  /*int selectGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
//                                                  radioGroupRegisterGenderSelected = findViewById(selectGenderId);
//                                                  database = FirebaseDatabase.getInstance();
//                                                  reference = database.getReference("users");
//                                                  //obtain the entered area
//                                                  String textFullName = editTextRegisterFullName.getText().toString();
//                                                  String textEmail = editTextRegisterEmail.getText().toString();
//                                                  String textDOB = editTextRegisterDOB.getText().toString();
//                                                  String textMobile = editTextRegisterMobile.getText().toString();
//                                                  String textPwd = editTextRegisterPwd.getText().toString();
//                                                  String textConfirmPwd = editTextRegisterConfirmPwd.getText().toString();
//                                                  String textGender;
//                                                  if (TextUtils.isEmpty(textFullName)) {
//                                                      Toast.makeText(Registration.this, "Please enter fullname", Toast.LENGTH_LONG).show();
//                                                      editTextRegisterFullName.setError("Full name is required");
//                                                      editTextRegisterFullName.requestFocus();
//                                                  }
//                                                  if (TextUtils.isEmpty(textEmail)) {
//                                                      Toast.makeText(Registration.this, "Please enter email", Toast.LENGTH_LONG).show();
//                                                      editTextRegisterEmail.setError("Correct Email is required");
//                                                      editTextRegisterEmail.requestFocus();
//                                                  }
//                                                  if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
//                                                      Toast.makeText(Registration.this, "Please re-enter email", Toast.LENGTH_LONG).show();
//                                                      editTextRegisterEmail.setError("Correct Email is required");
//                                                      editTextRegisterEmail.requestFocus();
//                                                  }
//                                                  if (TextUtils.isEmpty(textDOB)) {
//                                                      Toast.makeText(Registration.this, "Please enter your DOB", Toast.LENGTH_LONG).show();
//                                                      editTextRegisterEmail.setError("Date OF Birth");
//                                                      editTextRegisterEmail.requestFocus();
//                                                  }
//                                                  if (radioGroupRegisterGender.getCheckedRadioButtonId() == -1) {
//                                                      Toast.makeText(Registration.this, "Please select your gender", Toast.LENGTH_LONG).show();
//                                                      editTextRegisterEmail.setError("Gender is required");
//                                                      editTextRegisterEmail.requestFocus();
//                                                  }
//                                                  if (TextUtils.isEmpty(textMobile)) {
//                                                      Toast.makeText(Registration.this, "Mobile number is mandatory", Toast.LENGTH_LONG).show();
//                                                      editTextRegisterEmail.setError("Mobile Number is required..");
//                                                      editTextRegisterEmail.requestFocus();
//                                                  }
//                                                  if (textMobile.length() != 10) {
//                                                      Toast.makeText(Registration.this, "Please enter correct mobile number", Toast.LENGTH_LONG).show();
//                                                      editTextRegisterEmail.setError("Incorrect Mobile number");
//                                                      editTextRegisterEmail.requestFocus();
//                                                  }
//                                                  if (TextUtils.isEmpty(textPwd)) {
//                                                      Toast.makeText(Registration.this, "Password required", Toast.LENGTH_LONG).show();
//                                                      editTextRegisterEmail.setError("password");
//                                                      editTextRegisterEmail.requestFocus();
//                                                  }
//                                                  if (textPwd.length() <= 6) {
//                                                      Toast.makeText(Registration.this, "Password should be atleast of 6 digits", Toast.LENGTH_LONG).show();
//                                                      editTextRegisterEmail.setError("Strong password is required");
//                                                      editTextRegisterEmail.requestFocus();
//                                                  }
//                                                  if (TextUtils.isEmpty(textConfirmPwd)) {
//                                                      Toast.makeText(Registration.this, "enter confirm password", Toast.LENGTH_LONG).show();
//                                                      editTextRegisterEmail.setError(" password is required");
//                                                      editTextRegisterEmail.requestFocus();
//                                                  }
//                                                  if (!textPwd.equals(textConfirmPwd)) {
//                                                      Toast.makeText(Registration.this, "passwords do not match!", Toast.LENGTH_LONG).show();
//                                                      editTextRegisterEmail.setError(" confirmation is required");
//                                                      editTextRegisterEmail.requestFocus();
//                                                      editTextRegisterPwd.clearComposingText();
//                                                      editTextRegisterConfirmPwd.clearComposingText();
//                                                  }
//#
//                                                  ReadwriteUserDetails readwriteUserDetails = new ReadwriteUserDetails(textFullName, textDOB, textMobile);
//                                                  reference.child("users").push().setValue(readwriteUserDetails)
//                                                          .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                              @Override
//                                                              public void onComplete(@NonNull Task<Void> task) {
//                                                                  if (task.isSuccessful()) {
//                                                                      Toast.makeText(Registration.this, "Registration successful", Toast.LENGTH_SHORT).show();
//                                                                      Intent intent = new Intent(Registration.this, MainActivity.class);
//                                                                      startActivity(intent);
//                                                                  } else {
//                                                                      Toast.makeText(Registration.this, "Registration failed", Toast.LENGTH_SHORT).show();
//                                                                  }
//                                                              }
//                                                          });#
//                                                  ReadwriteUserDetails readwriteUserDetails = new ReadwriteUserDetails(textFullName, textDOB, textMobile);
//                                                  reference.child("users").setValue(readwriteUserDetails);*/
//                                                  Toast.makeText(Registration.this, "you are signed in..", Toast.LENGTH_SHORT).show();
//                                                  Intent intent = new Intent(Registration.this, MainActivity.class);
//                                                  startActivity(intent);
//                                              }
//        });
//    }
//}
//                /*else  {
//                    textGender = radioGroupRegisterGenderSelected.getText().toString();
//                    progressBar.setVisibility(View.VISIBLE);
//                }*/
//               /* ReadwriteUserDetails readwriteUserDetails = new ReadwriteUserDetails(textFullName, textDOB, textMobile);
//                reference.child("users").setValue(readwriteUserDetails);
//                Toast.makeText(Registration.this, "you are signed in..", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Registration.this, MainActivity.class);
//                startActivity(intent);
//            }*/
//
//
//    //register using credentials given:
//    /*private void registerUser(String textFullName, String textEmail, String textDOB, String textGender, String textMobile, String textPwd) {
//registerUser(textFullName, textEmail, textDOB, textGender, textMobile, textPwd);
//        FirebaseAuth auth = FirebaseAuth.getInstance();
//        ReadwriteUserDetails readwriteUserDetails=new ReadwriteUserDetails(textFullName,textDOB,textGender,textMobile);
//
//
//        auth.createUserWithEmailAndPassword(textEmail, textPwd).addOnCompleteListener(Registration.this,
//                new OnCompleteListener<AuthResult>() {
//
//
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        FirebaseUser firebaseUser = null;
//                        if (task.isSuccessful()) {
//                            firebaseUser = auth.getCurrentUser();
//
//                            ReadwriteUserDetails writeUserDetails = new ReadwriteUserDetails(textFullName, textDOB, textMobile, textGender);
//
//                            DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Registered Users");
//                            FirebaseUser finalFirebaseUser = firebaseUser;
//                            referenceProfile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()) {
//                                        finalFirebaseUser.sendEmailVerification();
//                                        Toast.makeText(Registration.this, "User registered succesful", Toast.LENGTH_LONG).show();
//                                        Intent intent = new Intent(Registration.this, MainActivity2.class);
//                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
//                                                Intent.FLAG_ACTIVITY_NEW_TASK);
//                                        startActivity(intent);
//                                        finish();
//                                    } else {
//                                        Toast.makeText(Registration.this, "User registeration failed", Toast.LENGTH_LONG).show();
//                                        progressBar.setVisibility(View.GONE);
//                                    }
//                                }
//
//                            });
//                        } else {
//                            try {
//                                throw task.getException();
//                            } catch (FirebaseAuthWeakPasswordException e) {
//                                editTextRegisterPwd.setError("Your password is too weak");
//                                editTextRegisterPwd.requestFocus();
//                            } catch (FirebaseAuthInvalidCredentialsException e) {
//                                editTextRegisterPwd.setError("Your email is invalid or already in use");
//                                editTextRegisterPwd.requestFocus();
//                            } catch (FirebaseAuthUserCollisionException e) {
//                                editTextRegisterPwd.setError("User is already registered with this email.");
//                                editTextRegisterPwd.requestFocus();
//                            } catch (Exception e) {
//                                Log.e(TAG,e.getMessage());
//                                Toast.makeText(Registration.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                            }
//                            progressBar.setVisibility((View.GONE));
//                        }
//                    }
//                });
//    }*/

