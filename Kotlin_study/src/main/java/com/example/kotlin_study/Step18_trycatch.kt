package com.example.kotlin_study

import java.util.Scanner

// Step18_trycatch.kt

fun main(){
    val scan=Scanner(System.`in`)
    print("숫자입력:")
    //숫자 형식의 문자열을 입력 받아서
    val result:String = scan.nextLine()
    try {
        //정수로 변환
        val num=Integer.parseInt(result)
        if (num % 2 == 1) {
            println("$num 은 홀수 입니다.")
        } else {
            println("$num 은 짝수 입니다.")
        }
    }catch (nfe:NumberFormatException){
        nfe.printStackTrace()
    }
    println("main 함수가 정상적으로 종료 됩니다")
}

