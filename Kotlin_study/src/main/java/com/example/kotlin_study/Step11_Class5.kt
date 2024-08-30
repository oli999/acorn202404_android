package com.example.kotlin_study

class User constructor(){ //primary 생성자

    init {
        println("primary 생성자는 반드시 호출되어야 객체가 생성된다.")
    }
    //일반 생성자
    constructor(num:Int, name:String):this(){ // :this() 는 primary 생성자를 호출하는 표현식이다
        println("일반생성자 호출됨!")
    }
}

fun main(){
    val u1=User()
    val u2=User(1, "김구라")
}