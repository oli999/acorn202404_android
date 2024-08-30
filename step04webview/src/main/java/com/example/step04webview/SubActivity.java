package com.example.step04webview;

import android.app.Activity;
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

import com.example.step04webview.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySubBinding binding=ActivitySubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        WebView webView=binding.webView;
        //WebView 설정 객체 얻어오기
        WebSettings ws=webView.getSettings();
        //javascript 해석가능하도록 설정
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        //WebView 클라이언트 객체를 생성해서 넣어주기
        webView.setWebViewClient(new WebViewClient(){
            //재정의 하고 싶은 메소드가 있으면 여기서 해준다.
        });
        webView.setWebChromeClient(new WebChromeClient());
        // 웹페이지 로딩하기
        webView.loadUrl("http://192.168.0.181:8888/boot11");

        binding.finishBtn.setOnClickListener(view->{
            // Activity 의 finish() 메소드를 호출하면 액티비티(SubActivity) 가 종료 된다.
            finish();
        });
    }
}









