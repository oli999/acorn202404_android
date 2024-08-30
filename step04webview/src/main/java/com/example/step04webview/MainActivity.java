package com.example.step04webview;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.step04webview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        setContentView(R.layout.activity_main);
        Button enterBtn=findViewById(R.id.enterBtn);
        enterBtn.setOnClickListener(view->{
            //버튼을 눌렀을때 SubActivity 로 이동하도록 한다
            Intent i=new Intent(this, SubActivity.class);
            startActivity(i);
        });
        */
        //view binding 기능 활용해 보기
        ActivityMainBinding binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.enterBtn.setOnClickListener(view->{
            //버튼을 눌렀을때 SubActivity 로 이동하도록 한다
            Intent i=new Intent(this, SubActivity.class);
            startActivity(i);
        });
    }
}











