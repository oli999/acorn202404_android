package com.example.kotlin_study

fun main(){
    //변수를 미리선언
    var a:String
    //선언과 동시에 값을 대입
    var b:String = "kim"
    //선언과 동시에 null 값 대입? type 이 맞지 않아서 안들어간다.
    //var c:String = null
    // null 값을 허용하려면  data type 뒤에 suffix 로 ? 를 붙여야 한다.
    // String type 과 String? type 은 엄연히 다른 type
    var c:String? = null
    c="abcd1234"
    /*
       c?.length 의 의미는 "c가 null 이 아닌 경우에만 length 를 참조해라" 라는 의미
       만일 c가 null 이라면  c?.length 위치에는 null 이 리턴된다(null 이 남는다)
    */
    println("$b 의 길이는 ${b.length}")
    println("$c 의 길이는 ${c?.length}")


}