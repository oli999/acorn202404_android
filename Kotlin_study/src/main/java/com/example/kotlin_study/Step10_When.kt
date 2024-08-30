package com.example.kotlin_study

import java.util.Scanner

/*
    kotlin <=> java 서로 import 해서 클래스를 사용할수 있다.

    kotlin 도 compile 하면   xxx.class 파일로 변경
    java 도 compile 하면 xxx.class 파일로 변경
    class 파일을 동일한 jvm 에서 실행하기 때문에 상호 호환이 된다.

    kotlin 에서 객체생성은 new 예약어 없이  클래스명( )  해서 객체 생성을 한다
 */

fun main(){
    //java
    //Scanner scan=new Scanner(System.in);

    /*
        - new 예약어 없이 객체 생성
        - in 은 kotlin 에서 예약어임으로  escape 하기 위해 backtick 으로 감싸준다.
     */
    val scan=Scanner(System.`in`)
    println("Gun:1, Sword:2, Arrow:3")
    println("무기를 선택하세요( 1 or 2 or 3)")
    val weapon = scan.nextInt()
    // kotlin 에서는 switch() 문 대신에 when() 을 사용한다.
    when(weapon){
        1 -> {
            println("총으로 공격해요")
        }
        2 -> {
            println("칼로 공격해요")
        }
        3 -> println("활로 공격해요") //실행할 code 가 1 줄이면 중괄호 생략가능
        else -> { //위의 조건이 모두 안맞으면  실행할 default 실행 블럭
            println("주먹으로 공격해요")
        }
    }

    //대입연산자의 우측에 when() 문을 작성할수도 있다.
    val selectedWeapon = when(weapon){
        1 -> "총"
        2 -> "칼"
        3 -> "활"
        else -> "주먹"
    }

}










