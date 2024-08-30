package com.example.kotlin_study

// java 에서 처럼 main() 메소드 역활을 한다.
// run 했을때 실행의 흐름이 시작되는 도입점
fun main(){
    println("Hello, World!")
    //정수를 담을수 있는 num 이라는 변수를 만들어서 10 대입하기
    //int num=10;  => java
    var num:Int = 10  // kotlin

    //실수를 담을수 있는 num2 라는 이름의 변수를 만들어서 10.1 대입하기
    //double num2=10.1 => java
    var num2:Double = 10.1

    //문자열을 담을수 있는 myName 이라는 이름의 변수를 만들어서 "김구라" 대입하기
    var myName:String = "김구라"

    // myName 은 변수(var) 이기 때문에 변경 가능
    myName = "에이콘"
    // num 도 변수(var) 이기 때문에 type 만 맞으면 값 변경 가능
    num=99
    // num3 를 정수를 저장할수 있는 상수로 지정
    val num3:Int = 8888

    //num3 = 9999 //상수니깐 값 변경 불가
}