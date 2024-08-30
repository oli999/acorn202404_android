package com.example.kotlin_study

import com.example.kotlin_study.mypac.MyUtil

// Step15_Companion.kt

fun main(){
    // MyUtil 클래스의 동반객체의 필드 참조
    var v=MyUtil.version
    // MyUtil 클래스의 동반잭체의 메소드 호출
    MyUtil.send()
}