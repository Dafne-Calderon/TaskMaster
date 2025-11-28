package com.example.taskmaster.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.example.taskmaster.R;
import com.example.taskmaster.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int DURATION = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_splash);
        } catch (Exception e) {
            // Si falla el splash, abre directo el Main
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return;
        }

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, DURATION);
    }
}
