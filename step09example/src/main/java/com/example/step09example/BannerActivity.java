package com.example.step09example;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        // BannerActivity 가 활성화 되는데 사용된 Intent 객체의 참조값 얻어내기
        Intent i=getIntent();
        // 문자열 얻어내기
        String bannerText=i.getStringExtra("bannerText");
        // Banner(View 객체의 참조값 얻어내기)
        Banner banner=findViewById(R.id.banner);
        banner.init(bannerText);
    }
}