package com.example.smishingdetectionapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.smishingdetectionapp.ui.login.LoginActivity;
import com.google.android.material.snackbar.Snackbar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.widget.ImageButton;
import android.widget.Button;
import com.example.smishingdetectionapp.databinding.ActivitySignupBinding;
import android.widget.CheckBox;
public class SignupActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton imageButton = findViewById(R.id.signup_back);
        imageButton.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

        TextView termsTextView = findViewById(R.id.terms_conditions);
        termsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open TermsAndConditionsActivity
                Intent intent = new Intent(SignupActivity.this, TermsAndConditionsActivity.class);
                startActivity(intent);
            }
        });

        CheckBox termsCheckbox = findViewById(R.id.terms_conditions_checkbox);
        Button registerButton = findViewById(R.id.registerBtn);

        termsCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            registerButton.setEnabled(isChecked);
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_signup);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}