package com.example.kotlin_study.mypac
/*
    java 에서 static 필드, static 초기화, static 메소드 정의 하는 것과 비슷하다
    class MyUtil{
        static String version="1.0";
        static{
           System.out.println("xxx");
        }
        public static void send(){
            System.out.println("전송합니다");
        }
    }
 */

class MyUtil {
    //이클래스(MyUtil) 의 동반 객체를 정의할수 있다.
    companion object{
        //필드
        var version:String="1.0"
        //초기화 블럭
        init {
            println("MyUtil companion init{}")
        }
        //메소드
        fun send(){
            println("전송합니다.")
        }
    }
}