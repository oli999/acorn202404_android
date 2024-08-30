package com.example.step02event;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{ //Activity 를 OnClickListener type  으로 만든다
    /*
        MainActivity 가 활성화 될때 최초 호출되는 onCreate() 메소드
        - 레이아웃 정보를 전달해서 화면 구성을 해야한다.
        - UI 에 관련된 준비 작업을 주로 여기서 한다.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // res/layout/activity_main.xml 문서를 전개해서 화면 구성하기
        setContentView(R.layout.activity_main);
        /*
            레이아웃 문서가 전개된다는 의미는 xml 문서에 명시된 모든 UI 객체가
            생성된다라는 의미도 포함하고 있다.
            따라서 해당 객체의 참조값이 필요하다면 UI 에 지정한 id 를 이용하면된다.
         */
        // id 가 sendBtn 인 UI 의 참조값을 얻어와서 Button type 으로 담기
        Button sendBtn = findViewById(R.id.sendBtn);
        //버튼을 클릭했을때 리스너 역활을 할 객체를 등록
        sendBtn.setOnClickListener(this);

        Button saveBtn = findViewById(R.id.saveBtn);
        //익명 클래스를 이용해서 만든 객체를 이용해서 리스너 등록하기
        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "저장 합니다", Toast.LENGTH_SHORT).show();
            }
        });

        Button deleteBtn=findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener((view)->{
            Toast.makeText(this, "삭제합니다", Toast.LENGTH_SHORT).show();
        });

    }
    // View.OnClickListener 인터페이스를 구현했기 때문에 강제로 재정의한 메소드
    @Override
    public void onClick(View view) {
        //버튼을 클릭하면 여기가 실행된다.
        Toast.makeText(this, "전송합니다", Toast.LENGTH_SHORT).show();
    }
}






