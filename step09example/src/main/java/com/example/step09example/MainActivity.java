package com.example.step09example;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText inputBanner=findViewById(R.id.inputBanner);
        Button startBtn=findViewById(R.id.startBtn);
        startBtn.setOnClickListener(view->{
            //입력한 문자열을 읽어온다.
            String bannerText = inputBanner.getText().toString();
            //BannerActivity 로 이동할 의도(Intent) 객체 생성
            Intent i=new Intent(this, BannerActivity.class);
            //Intent 객체에 Extra 로 문자열(String type)을 담는다.
            i.putExtra("bannerText", bannerText);
            //액티비티 시작 시키기
            startActivity(i);
        });
    }
}