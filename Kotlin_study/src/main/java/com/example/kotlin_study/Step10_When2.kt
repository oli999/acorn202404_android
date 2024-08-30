package com.example.kotlin_study

import java.util.Scanner

fun main(){
    val scan=Scanner(System.`in`)
    println("점수 입력:")
    val jumsu=scan.nextInt()
    when(jumsu){
        in 90..100 -> println("90 에서 100 사이 입니다")
        in 80..90 -> println("80 에서 90 사이 입니다")
        else -> println("80 아래 입니다")
    }
    println("-----")
    when{
        jumsu >= 90 -> println("점수는 90 이상 입니다")
        jumsu >= 80 -> println("점수는 80 이상 입니다")
        else -> println("점수는 80 아래 입니다")
    }
}