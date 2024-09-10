package com.example.step09gameview;

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

        //시작 버튼
        Button startBtn=findViewById(R.id.startBtn);
        //버튼을 눌렀을때 리스너 등록하기
        startBtn.setOnClickListener(view->{
            //GameActivity 시작하기
            startActivity(new Intent(this, GameActivity.class));
        });

        //소리를 재생할 준비를 한다.
        SoundManager sm=new SoundManager(this);
        sm.addSound(1, R.raw.birddie);
        sm.addSound(2, R.raw.laser1);
        sm.addSound( 3, R.raw.shoot1);

        Button playBtn=findViewById(R.id.playBtn);
        playBtn.setOnClickListener(view -> {
            sm.playSound(2);
        });
    }
}







