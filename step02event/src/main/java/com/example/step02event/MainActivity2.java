package com.example.step02event;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    //카운트 값을 필드로 관리
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        //버튼의 참조값
        Button countBtn=findViewById(R.id.countBtn);
        countBtn.setOnClickListener(view->{
            //카운트값 1 증가 시키기
            this.count++;
            //문자열로 바꾸기
            String str = Integer.toString(count);
            //문자열을 이용해서 버튼의 text 변경하기
            countBtn.setText(str);
        });
    }
}










