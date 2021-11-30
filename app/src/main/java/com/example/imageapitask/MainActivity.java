package com.example.imageapitask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import galleryImageFetching.ImageActivity;

public class MainActivity extends AppCompatActivity {

    Button apiImageButton, gallerryImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiImageButton = findViewById(R.id.btn_Api);
        gallerryImageButton = findViewById(R.id.btn_galleryImage);
        apiImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, SettingApiActivity.class));
            }
        });

        gallerryImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, ImageActivity.class));
            }
        });
    }
}