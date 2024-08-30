package com.example.kotlin_study

// Step03_Interface2.kt

fun main(){
    /*
        in java

        final Remocon r1 = new Remocon(){
            void up(){ }
            void down(){ }
        }
     */

    //익명 클래스를 이용해서 Remocon type 의 참조값 얻어내기
    //익명 클래스를 정의함과 동시에 객체를 생성하는것이 object 키워드이다
    val r1:Remocon = object : Remocon{
        override fun up() {
            println("체널을 올려요!")
        }
        override fun down() {
            println("체널을 내려요!")
        }
    }
    r1.up()
    r1.down()
}