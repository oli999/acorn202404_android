package com.example.kotlin_study.mypac

class YourUtil {
    companion object{
        //java 에서 static 필드 , static 메소드 처럼 사용할수 있도록
        @JvmStatic var version:String="1.0"
        @JvmStatic fun send(){
            println("send!")
        }
    }
}