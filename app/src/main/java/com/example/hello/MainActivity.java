package com.example.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public void clicked(View v){
        //전달된 참조값을 원래 type 으로 casting
        Button btn = (Button)v;
        //버튼의 메소드를 이용해서 Button 텍스트 변경하기
        btn.setText("Clicked!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        /*
            setContentView() 는 상속관계에 의해서 사용할수 있는 부모의 메소드이다.
            이메소드를 호출하면서 화면구성을 어떻게 할것인지에 대한 정보를 전달해야 한다.
            R 은 res 폴더 , layout 은 res/layout 폴더 ,
            activity_main 은  activity_main.xml 문서를 가리킨다.
            따라서 setContextView(R.layout.activity_main)
            은 해당 xml 문서를 전개해서 화면 구성이 된다.
         */
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}