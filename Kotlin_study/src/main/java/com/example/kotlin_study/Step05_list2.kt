package com.example.kotlin_study

fun main(){
    //read only List<Int>
    val nums:List<Int> = listOf(1,2,3,4,5,6,7,8,9,10)

    // List 를 이용해서 새로운 List 얻어내기
    val result=nums.map(fun(item):Int{
        return item*2
    })
    println(result)

    val result2 = nums.map {
        //여기는 람다 함수내부 이기때문에 return 예약어는 사용하지 않는다
        it*2
    }
    println(result2)
    // List 에서 5 이상인 아이템만 남긴다음 해당아이템에 2 를 곱한 새로운 List 얻어내기
    val result3 = nums.filter { it>=5 }.map { it*2 }
    println(result3)
}





