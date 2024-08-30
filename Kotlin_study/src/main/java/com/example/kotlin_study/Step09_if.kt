package com.example.kotlin_study

fun main(){
    val num=11
    //변수나 상수 선언을 미리하고
    val result:String
    //조건부로 다른 값을 대입
    if(num%2 == 1){
        result="$num 은 홀수 입니다"
    }else{
        result="$num 은 짝수 입니다"
    }

    //3항 연산자? 없다
    //val result2 = num%2 == 1 ? "$num 은 홀수 입니다" : "$num 은 짝수 입니다"

    val result2 = if(num%2==1) "$num 은 홀수 입니다" else "$num 은 짝수 입니다"
}












