package com.example.kotlin_study

fun main(){
    // a 는 도대체 무슨 type 일까?
    var a = fun(){}
    //여러가지 모양의 함수 type 을 선언해서 값을 넣어보기
    var b:()->Unit = fun(){ }
    var c:()->Unit = fun():Unit{ }
    var d:()->Int = fun():Int{ return 10 }
    var e:()->String = fun():String{ return "kim"}
    var f:(Int)->Unit = fun(num1:Int){}
    var g:(String)->Unit = fun(msg:String){}
    var h:(Int, String)->Unit = fun(num1:Int, msg:String){}
    var i:(Int)->String = fun(num1:Int):String{ return "kim"}
    //d 는 변수이기 때문에 또 다른 함수도 모양만 일치하면 들어간다
    d = fun():Int{
        return 10
    }
}