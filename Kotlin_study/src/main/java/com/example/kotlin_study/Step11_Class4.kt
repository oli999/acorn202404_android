package com.example.kotlin_study

class Cat{
    //선언만 하고 값을 나중에 넣을 예정이라면 lateinit 이라는 예약어를 붙여주면 된다.
    //값을 나중에 넣고 싶지만 null 이 가능한 type 은 싫을때 사용한다
    lateinit var name:String

    fun putName(name:String){
        this.name=name
    }

    fun showInfo(){
        println("내 이름은 ${this.name} 야옹")
        println("내 이름은 ${this.name.length} 글짜 입니다")
    }
}

fun main(){
    val cat1 = Cat()
    cat1.putName("tomcat")
    cat1.showInfo()
}






