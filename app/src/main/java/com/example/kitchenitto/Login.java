package com.example.kitchenitto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    TextView clickSignUP;
    TextInputEditText emailTxt, passwordTxt;
    Button login_btn;
    FirebaseAuth mAuth;
    ProgressBar progressB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailTxt.findViewById(R.id.email);
        passwordTxt.findViewById(R.id.password);
        login_btn.findViewById(R.id.btn_login);
        clickSignUP.findViewById(R.id.clicktoSignup);
        clickSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
                finish();
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailA, passW;
                emailA = String.valueOf(emailTxt.getText());
                passW = String.valueOf(passwordTxt.getText());
                progressB.setVisibility(View.VISIBLE);

                if (TextUtils.isEmpty(emailA)) {
                    Toast.makeText(Login.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                }
                if (TextUtils.isEmpty(passW)) {
                    Toast.makeText(Login.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                }

            }
        });
    }
}