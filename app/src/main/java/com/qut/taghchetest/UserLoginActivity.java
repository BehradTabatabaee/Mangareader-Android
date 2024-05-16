package com.qut.taghchetest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class UserLoginActivity extends AppCompatActivity {
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "admin";
    private TextInputLayout usernameInputLayout, passwordInputLayout;
    private TextInputEditText usernameEditText, passwordEditText;
    private MaterialButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        initializeViews();

        loginButton.setOnClickListener(view -> handleLogin());
    }

    private void handleLogin() {
        String enteredUsername = Objects.requireNonNull(usernameEditText.getText()).toString().trim();
        String enteredPassword = Objects.requireNonNull(passwordEditText.getText()).toString().trim();

        if (enteredUsername.equals(CORRECT_USERNAME) && enteredPassword.equals(CORRECT_PASSWORD)) {
            Intent intent = new Intent(UserLoginActivity.this, UserDashboardActivity.class);
            intent.putExtra("USERNAME", enteredUsername);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(UserLoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    private void initializeViews() {
        usernameInputLayout = findViewById(R.id.userNameInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);
        usernameEditText = findViewById(R.id.userNameInputEditText);
        passwordEditText = findViewById(R.id.passwordInputEditText);
        loginButton = findViewById(R.id.loginButton);
    }
}