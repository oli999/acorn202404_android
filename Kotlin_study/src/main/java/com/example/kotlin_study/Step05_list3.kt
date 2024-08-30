package com.example.kotlin_study

fun main(){
    // read only  문자열 List
    val names = listOf<String>("김구라", "해골", "원숭이")
    // read only  숫자 List
    val nums = listOf<Int>(10, 20, 30)
    //names List 의 0 번 index 참조하는 방법1
    val a=names.get(0)
    //names List 의 0 번 index 참조하는 방법2
    val b=names[0]
    //names 의 item 갯수 참조
    val c=names.size
    //names 의 마지막 인덱스 참조
    val d=names.lastIndex
    //names 의 인덱스들
    val indexs = names.indices
    println(indexs)

    for(i in 0..2){
        val tmp=names.get(i)
        println("$i 번째 인덱스 의 값 : $tmp")
    }
    println("-----")
    for(i in names.indices){
        val tmp=names.get(i)
        println("$i 번째 인덱스 의 값 : $tmp")
    }
    println("-----")
    for(i in 0..names.lastIndex){
        val tmp=names.get(i)
        println("$i 번째 인덱스 의 값 : $tmp")
    }

    println("-----")
    for(i in names.lastIndex downTo 0){
        val tmp=names.get(i)
        println("$i 번째 인덱스 의 값 : $tmp")
    }
}









