package com.example.kitchenitto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mSignupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsernameEditText = findViewById(R.id.username_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);
        mSignupButton = findViewById(R.id.signup_button);

        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Handle sign-up button click here
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                Toast.makeText(MainActivity.this, "Username: " + username + "\nPassword: " + password, Toast.LENGTH_SHORT).show();

            }
        });
        TextView loginLink = findViewById(R.id.login_link);
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle login link click here
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);

            }
        });

    }
}
