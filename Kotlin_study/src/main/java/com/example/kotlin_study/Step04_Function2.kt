package com.example.kotlin_study

fun main(){
    /*
        in java => public void a(){ }
        in kotlin => fun a():Unit{ }  or  fun a(){ }
        코틀린에서 Unit 은 원시 type 이라고 지칭하고 java 의 void 와 비슷한 역활을 한다.
     */
    // 함수명( ):리턴type { }
    fun a():Unit{
        println("a 함수 호출됨!")
    }
    // 이름이 없는 함수를 만들어서 그 참조값을 변수에 담기
    var b = fun(){ }
    /*
        [ 함수의 type 정의하는 방법 ]

        (매개변수의 모양) -> 리턴type
     */
    var c:()->Unit = fun():Unit{ }

    //String type 을 전달 받아서 해당 문자열의 길이를 리턴하는 함수를 변수에 담아보세요
    //함수의 type 을 정확히 명시해서
    var f:(String)->Int = fun(str:String):Int{
        return str.length
    }
}