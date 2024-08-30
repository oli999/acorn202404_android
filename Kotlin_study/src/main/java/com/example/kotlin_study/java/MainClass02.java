package com.example.kotlin_study.java;

import com.example.kotlin_study.MyPerson;
import com.example.kotlin_study.MyTool;
import com.example.kotlin_study.OurPerson;
import com.example.kotlin_study.OurTool;
import com.example.kotlin_study.YourPerson;
import com.example.kotlin_study.YourTool;

public class MainClass02 {
    public static void main(String[] args) {
        MyPerson p1=new MyPerson();
        MyPerson p2=new MyPerson("kim");
        MyPerson p3=new MyPerson("park", 30);
        //한가지 모양의 생성자만 존재한다.
        YourPerson p4=new YourPerson("park", 30);
        //@JvmOverloads 어노테이션이 붙어 있어서 다양한 모양으로 객체 생성 가능
        OurPerson p5 = new OurPerson();
        OurPerson p6 = new OurPerson("kim");
        OurPerson p7 = new OurPerson("park", 30);

        MyTool mt = new MyTool();
        mt.make();
        mt.make(10);
        mt.make(10, "망치");

        YourTool yt=new YourTool();
        yt.make(10, "망치");

        OurTool ot=new OurTool();
        //@JvmOverloads 어노테이션이 붙어 있어서 다양한 모양으로 메소드 호출가능
        ot.make();
        ot.make(10);
        ot.make(10, "망치");
    }
}
