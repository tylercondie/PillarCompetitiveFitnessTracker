package com.pillarproductivity.pillar_competitivefitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent signIntent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(signIntent);
    }
}

