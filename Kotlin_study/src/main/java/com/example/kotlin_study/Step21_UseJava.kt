package com.example.kotlin_study

import com.example.kotlin_study.java.CafeDto

// Step21_UseJava

// java 클래스도 import 해서 사용할수 있다.

fun main(){
    val dto = CafeDto()
    dto.setNum(1)
    dto.setWriter("김구라")
    dto.setTitle("제목1")

    val dto2 = CafeDto()
    //setter 메소드 호출하는 것 대신에 아래와 같이 사용할수 있다.
    dto.num=2
    dto.writer="해골"
    dto.title="제목2"

}





