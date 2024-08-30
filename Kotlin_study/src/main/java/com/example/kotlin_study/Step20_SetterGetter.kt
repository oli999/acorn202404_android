package com.example.kotlin_study

// Step20_SetterGetter.kt

// StarBucks 클래스 정의하기
class StarBucks{
    //위치
    var location:String? = null
        set(value) {
            //필드에 값이 대입되는 시점에 여기가 호출되고 value 를 대입될 예정인 값이다.
            field = "$value 지점"  //필드는 해당필드, 즉 location 을 의미한다
        }
        get() {
            //필드를 참조하는 시점에 여기가 호출되고 return 해주는 값이 필드에 참조되는 값이다
            if(field == null){
                return "지점명이 없는"
            }else{
                return field
            }
        }

    fun showInfo(){
        println("$location StaBucks 입니다")
    }
}

//생성자를 선언함과 동시에 필드가 자동으로 만들어 지게 한다
data class Rect(val width:Int, val height:Int){
    // width*height 된 사각형의 면적
    val area:Int
        get(){
            return width*height
        }

    fun showInfo(){
        println("폭:$width , 높이:$height , 면적:$area")
    }
}

fun main(){
    val s1 = StarBucks()
    s1.location="강남"

    val s2 = StarBucks()
    s2.location="논현"

    val s3 = StarBucks()

    s1.showInfo()
    s2.showInfo()
    s3.showInfo()

    val r1=Rect(10, 20)
    val r2=Rect(30, 40)

    println(r1)
    println(r2)

    r1.showInfo()
    r2.showInfo()
}








