package com.example.step09customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



/*
    [ Custom View 만들기 ]
    1. View 클래스를 상속 받는다.
    2. 생성자 정의하기
    3. onDraw() 메소드를 오버라이드 해서 화면을 구성한다.
 */
public class YourView extends View { //1.
    //필드
    int x=10;

    // layout  xml 없이 단독으로 화면 전체를 체울때 사용한다.
    public YourView(Context context) { //2.
        super(context);
        init();
    }
    // layout xml 에서 사용하려면 아래의 생성자가 필요하다
    public YourView(Context context, @Nullable AttributeSet attrs) {//3.
        super(context, attrs);
        init();
    }

    Handler handler=new Handler() {
        //Handler 객체에 메세지가 도착하면 호출되는 메소드
        @Override
        public void handleMessage(@NonNull Message msg) {
            x++;
            invalidate();
            handler.sendEmptyMessageDelayed(0, 10);
        }
    };

    //초기화 하는 메소드
    public void init(){
        //Handler 객체에 10/1000 초 이후에 빈 메세지 보내기
        handler.sendEmptyMessageDelayed(0, 10);
    }

    //매개변수로 전달되는 Canvas 객체를 이용해서 그림을 그리면 그린 내용이 화면에 나타난다.
    //그림 => 글자, 도형, 페인트, 로딩한 이미지 ...
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        canvas.drawColor(Color.YELLOW);
        //글자 출력하기
        Paint p=new Paint();
        p.setColor(Color.RED);
        p.setTextSize(100);
        canvas.drawText("Hello", x, 110, p);
    }
}






