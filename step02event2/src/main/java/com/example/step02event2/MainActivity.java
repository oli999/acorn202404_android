package com.example.step02event2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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

        //공부하기 버튼의 참조값 얻어오기
        Button moveBtn=findViewById(R.id.moveBtn);
        //버튼에 클릭 리스너 등록하기
        moveBtn.setOnClickListener(view->{
            /*
                액티비티를 이동하겠다는 Intent(의도) 객체 생성하기
                new Intent( Context type, 이동할 Activity class type )
                Context type 이 필요한 곳에는 액티비티의 참조값을 전달하면된다.
             */
            Intent i=new Intent(this, StudyActivity.class);
            startActivity(i);
        });
    }
}