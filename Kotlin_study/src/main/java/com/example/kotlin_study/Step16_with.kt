package com.example.kotlin_study

// Step16_with.kt

fun main(){

    class Member{
        var num:Int?=null
        var name:String?=null
        var isMan:Boolean?=null
        fun showInfo(){
            println("${this.num} , ${this.name}, ${this.isMan}")
        }
    }

    val m1 = Member()
    m1.num=1
    m1.name="김구라"
    m1.isMan=true
    m1.showInfo()

    val m2 = Member()
    //특정 객체와 함께할 작업을 { } 안에 모아 놓고 일괄 실행 할수 있다.
    with(m2){  // scope 함수
        num=2
        name="해골"
        isMan=false
        showInfo()
    }

    val m3 = Member()
    val result=with(m3){
        num=3
        name="원숭이"
        isMan=true
        "가장 마지막에 있는 데이터가 with scope 함수의 리턴값이다"
    }
    println(result)
}






