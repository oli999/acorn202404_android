package com.example.kotlin_study

import com.example.kotlin_study.mypac.Car
import com.example.kotlin_study.mypac.Member
import com.example.kotlin_study.mypac.Member2

// Step11_Class3.kt

fun main(){
    val m1=Member(1, "김구라", "노량진")
    val m2=Member(2, "해골", "행신동")
    //data class 로 정의 했기 때문에 참조값을 출력해도 객체 안에 저장된 내용이 출력된다.
    println(m1)
    println(m2)
    //생성자의 매개 변수에 default 값이 설정되어 있기 때문에 다양한 모양으로 객체를 생성할수 있다.
    val m3=Member2()
    val m4=Member2(3)
    val m5=Member2(4, "원숭이")
    val m6=Member2(5,"주뎅이", "상도동")

    val c1=Car()
    val c2=Car("소나타")
    c1.drive()
    c2.drive()
}