package com.example.kotlin_study.java;

import com.example.kotlin_study.Phone;
import com.example.kotlin_study.mypac.MyUtil;
import com.example.kotlin_study.mypac.YourUtil;

public class MainClass01 {
    public static void main(String[] args) {
        // kotlin 클래스 import 해서 사용해보기
        Phone p1=new Phone();
        p1.call();
        // companion object 의 필드참조, 메소드 호출
        String v = MyUtil.Companion.getVersion();
        MyUtil.Companion.send();

        String v2 = YourUtil.getVersion();
        YourUtil.send();
    }
}
