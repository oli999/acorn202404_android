package com.example.kotlin_study

// Step11_Class2.kt

class Person constructor(name:String){
    //필드 선언
    var name:String
    init{
        //생성자에 전달된 값을 필드에 저장
        this.name=name
    }
}

//위의 코드를 줄이면 아래와 같다
class Person2 constructor(var name:String)
class Person3 (var name:String) //constructor 예약어 생략 가능
class Person4 (val name:String) //상수 필드를 만들고 싶으면 val 로 선언하면 된다.


fun main(){
    val p1=Person("김구라")
    val p2=Person2("해골")
    val p3=Person3("원숭이")
    val p4=Person4("주뎅이")
}

