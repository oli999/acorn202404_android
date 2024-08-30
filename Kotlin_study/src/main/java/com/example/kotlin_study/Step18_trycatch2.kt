package com.example.kotlin_study

import java.util.Scanner

// Step18_trycatch2.kt

fun main(){
    // kotlin 에서의 if 문
    val num = 10
    val result = if(num >= 0) {
        "num 은 0 이상 입니다"
    }else{
        "num 은 0 미만 입니다."
    }
    // 위와 비슷한 느낌으로 try~catch 문을 활용할수도 있다.
    val scan=Scanner(System.`in`)
    print("숫자입력:")
    val strNum = scan.nextLine()

    val result2 = try{
        println("aaa")
        println("bbb")
        //예외가 발생하지 않는 경우 대입될 값
        Integer.parseInt(strNum)
    }catch(nfe:NumberFormatException){
        0 //예외가 발생하는 경우 대입될 값
    }
    println("입력한 숫자:"+result2)
}
