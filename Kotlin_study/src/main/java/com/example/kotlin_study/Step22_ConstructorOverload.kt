package com.example.kotlin_study

class MyPerson{
    //생성자 다중정의(overload)
    constructor()
    constructor(name:String)
    constructor(name:String, age:Int)
}
class YourPerson{
    //매개 변수에 기본값을 설정하면 다중 정의된 효과를 낼수 있다.
    constructor(name:String="", age:Int=0)
}

class YourPerson2{
    // @JvmOverloads 를 추가하면 java 에서 이 클래스를 사용할때도 다양한 방법으로 객체 생성이 가능하다
    @JvmOverloads  constructor(name:String="", age:Int=0)
}

// primary 생성자도 당연히 가능하다
class OurPerson @JvmOverloads constructor(var name:String="",var age:Int=0)

fun main(){
    //객체를 생성하는 방법이 3가지가 있다.
    MyPerson()
    MyPerson("kim")
    MyPerson("park", 30)

    YourPerson()
    YourPerson("kim")
    YourPerson("park", 30)

    OurPerson()
    OurPerson("kim")
    OurPerson("park", 30)

}





