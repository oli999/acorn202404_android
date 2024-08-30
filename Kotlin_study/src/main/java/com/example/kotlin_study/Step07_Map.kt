package com.example.kotlin_study

fun main(){

    // read only Map type 객체 만들기
    // key 의 generic : String
    // value 의 generic : Any
    // kotlin 에서 Any 는  java 의 Object 와 비슷하다
    val mem = mapOf<String, Any>("num" to 1, "name" to "김구라", "isMan" to true)
    // .get(key) 를 이용해서 데이터 참조가능 , 리턴 type 은 Any? type 이다.
    val num1:Any? = mem.get("num")
    val num2:Any? = mem["num"]  //이렇게도 가능하다
    val num3:Int = mem.get("num") as Int // as 를 이용해서 type casting 을 할수 있다.

    val name1:Any? = mem.get("name")
    val name2:Any? = mem["name"]
    val name3:String = mem.get("name") as String

    val isMan:Boolean = mem.get("isMan") as Boolean

}








