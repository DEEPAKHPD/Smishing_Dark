package com.example.smishingdetectionapp;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smishingdetectionapp.ui.account.AccountActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.util.Log;
public class SettingsActivity extends AppCompatActivity {
    public static final int THEME_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.settings_activity);
        setContentView(R.layout.activity_settings);
        /*if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_settings, new SettingsActivity())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }*/

        BottomNavigationView nav = findViewById(R.id.bottom_navigation);

        nav.setSelectedItemId(R.id.nav_settings);

        nav.setOnItemSelectedListener(menuItem -> {

            int id = menuItem.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(0,0);
                finish();
                return true;
            } else if (id == R.id.nav_news) {
                startActivity(new Intent(getApplicationContext(), NewsActivity.class));
                overridePendingTransition(0,0);
                finish();
                return true;
            } else if (id == R.id.nav_settings) {
                return true;
            }

            return false;
        });

        //Account button to switch to account page
        Button accountBtn = findViewById(R.id.accountBtn);
        accountBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, AccountActivity.class));
            finish();
        });
        //Filtering button to switch to smishing rules page
        Button filteringBtn = findViewById(R.id.filteringBtn);
        filteringBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, SmishingRulesActivity.class));
            finish();
        });
        //Report button to switch to reporting page
        Button reportBtn = findViewById(R.id.reportBtn);
        reportBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, ReportingActivity.class));
            finish();
        });

        // Theme button to switch to theme selection page
        Button themeBtn = findViewById(R.id.themeBtn);
        themeBtn.setOnClickListener(v -> {
            Log.d("ThemeButton", "Theme button clicked");
            Intent intent = new Intent(SettingsActivity.this, ThemeSelectionActivity.class);
            startActivityForResult(intent, THEME_REQUEST_CODE);
        });
        //Notification button to switch to notification page

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == THEME_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            boolean themeChanged = data.getBooleanExtra("themeChanged", false);
            if (themeChanged) {
                Log.d("SettingsActivity", "Theme has been changed");

            }
        }
    }

    //Notification button to switch to notification page
    public void openNotificationsActivity(View view) {
        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
    }
}

