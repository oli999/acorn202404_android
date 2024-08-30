package com.example.kotlin_study

fun main(){
    //type 추론(infer) 가 가능한 경우에는 type 생략 가능
    var num1=10 //Int type
    var num2=10.1 //Double type
    var isRun=true //Boolean type
    var myName="김구라" //String type

    //변수를 미리 선언하고 값을 나중에 대입 할수도 있다
    var num3:Int // type 추론이 안될때는 data type 을 반드시 선언해야 한다.
    num3=10
    var yourName:String
    yourName="해골"

    //상수도 미리 선언하고 값을 나중에 대입 할수도 있다.
    val PI:Float
    PI=3.14159f
    //변수 혹은 상수에 들어있는 값을 콘솔에 출력
    println(myName)
}
