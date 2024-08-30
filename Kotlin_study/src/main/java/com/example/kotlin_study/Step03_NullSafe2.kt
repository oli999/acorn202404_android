package com.example.kotlin_study

fun main(){
    var str:String = "abcde12345"
    var str2:String? = "abcde12345"

    //문자열의 길이를 참조해서 변수에 담기
    var length:Int = str.length
    // null 일 가능성이 있기때문에 length2 는 Int? type 이다.
    var length2:Int? = str2?.length
    // Elvis 연산자 ?: 는 null 일경우에 기본값을 남기는 연산자이다
    // str2?.length 가 만일 null 이면 0 을 남기기 때문에 대입연산자의 우측이 null 일 가능성은 없다
    // 따라서 length3 는 Int? 이 아닌 Int type 으로 선언할수 있는 것이다
    var length3:Int = str2?.length ?: 0
}








