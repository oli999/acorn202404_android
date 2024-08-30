package com.example.kotlin_study

/*
    String type 의 편리한 기능 활용

    java 에서 문자열 연결, 여러줄의 문자열 작성하기가 불편했음
 */
fun main(){
    val myName="김구라"
    val yourName="해골"
    val ourName="에이콘"

    //연결연산자 가능
    val result = "내 이름은 "+myName+" 입니다"
    //새로운 기능을 이용해서 연결
    val result2 = "너의 이름은 ${yourName} 입니다"
    //따로 연산할게 없다면 {} 는 생략 가능
    val result3 = "우리의 이름은 $ourName 입니다"

    val num1=10
    val num2=20
    val result4 = "$num1 더하기 $num2 는 ${num1+num2} 입니다"

    //여러줄의 문자열을 편리하게 작성할수 있다.
    val html = """
        <div>
            <p>p요소 입니다</p>
        </div>
    """

    val html2 = """
       <div>
            <p>p요소 입니다</p>
       </div>
    """.trimIndent()

    println(html)
    println(html2)
}
