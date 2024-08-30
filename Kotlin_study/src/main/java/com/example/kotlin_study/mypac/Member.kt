package com.example.kotlin_study.mypac

// data 예약어를 붙이면 toString() 메소드가 자동 재정의 되고 copy() 메소드가 생긴다
data class Member (var num:Int, var name:String, var addr:String)

/*

위의 표현은 아래의 줄인 표현이다

data class Member(num:Int, name:String, addr:String){
    var num:Int
    var name:String
    var addr:String
    init{
        this.num=num
        this.name=name
        this.addr=addr
    }
}
*/
