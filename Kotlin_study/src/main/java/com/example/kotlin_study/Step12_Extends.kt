package com.example.kotlin_study

/*
    클래스 선언시 기본값은 상속을 받지 못하게 되어 있다.
    마치 java 에서  final class Phone{ } 처럼...
    상속을 받을수 있게 하려면 open 이라는 예약어를 붙여 준다.
 */
open class Phone{
    fun call(){
        println("전화를 걸어요")
    }
}

// Phone 클래스를 상속받은 HandPhone 클래스 정의하기
open class HandPhone : Phone(){
    fun mobileCall(){
        println("이동중에 전화를 걸어요!")
    }
    open fun takePicture(){
        println("100 만 화소의 사진을 찍어요!")
    }
}

class SmartPhone : HandPhone(){
    fun doInternet(){
        println("인터냇을 해요!")
    }
    // override 라는 예약어를 이용해서 open 된 메소드를 오버라이드 할수가 있다.
    override fun takePicture() {
        super.takePicture() //필요시 부모의 메소드를 호출할수도 있다. (java 와 동일)
        println("1000 만 화소의 사진을 찍어요!")
    }
}


fun main(){
    val p1=Phone()
    val p2=HandPhone()
    val p3=SmartPhone()

    p3.call()
    p3.takePicture()
    p3.doInternet()
}












