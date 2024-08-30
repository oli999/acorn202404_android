package com.example.kotlin_study

// Step17_apply.kt

fun main(){
    class Member{
        var num:Int?=null
        var name:String?=null
        var isMan:Boolean?=null
        fun showInfo(){
            println("${this.num} , ${this.name}, ${this.isMan}")
        }
    }
    // m1 에는 번호, 이름, 주소가 들어있는 Member 객체의 참조값이 들어 있다.
    val m1 = Member().apply {
        num=1
        name="김구라"
        isMan=true
        showInfo()
        //apply 는 this (Member 객체) 를 리턴해준다.
    }
    // with 를 apply 처럼 사용해보기 ( apply 대신에 이렇게 사용하지는 않는다)
    val m2 = with(Member()){
        num=2
        name="해골"
        isMan=false
        showInfo()
        this //with 는 가장 마지막 라인에 있는 값이 리턴된다.
    }
}