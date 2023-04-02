package com.example.kitchenitto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity {
    TextInputEditText emailTxt,passwordTxt,phoneNumber;
    Button signup_btn;
    FirebaseAuth mAuth;
    ProgressBar progressB;
    TextView clickTolog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        emailTxt = findViewById(R.id.email);
        passwordTxt = findViewById(R.id.password);
        signup_btn  = findViewById(R.id.btn_signup);
        phoneNumber = findViewById(R.id.phonenumber);
        progressB = findViewById(R.id.progBar);
        clickTolog = findViewById(R.id.clicktoSignup);
        clickTolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });



        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailA, phoneNUM, passW;
                emailA = String.valueOf(emailTxt.getText());
                phoneNUM = String.valueOf(phoneNumber.getText());
                passW = String.valueOf(passwordTxt.getText());
                progressB.setVisibility(View.VISIBLE);

                if(TextUtils.isEmpty(emailA)){
                    Toast.makeText(Signup.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }else{

                }
                if(TextUtils.isEmpty(passW)){
                    Toast.makeText(Signup.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }else{

                }
                if(TextUtils.isEmpty(phoneNUM)){
                    Toast.makeText(Signup.this, "Please enter phonenumber", Toast.LENGTH_SHORT).show();
                    return;
                }

                //create user in DB
                mAuth.createUserWithEmailAndPassword(emailA, passW)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressB.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    //If sign in is good, display a message to the user.

                                    Toast.makeText(Signup.this, "Account created successfully",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Signup.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}