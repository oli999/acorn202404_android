package com.example.kotlin_study

fun main(){
    //read only List<Int>
    val nums:List<Int> = listOf(1,2,3,4,5,6,7,8,9,10)
    // 0 번방의 아이템 참조
    val item1 = nums.get(0)
    val item2 = nums[0] // 이렇게도 참조 가능하다
    //List 객체의 forEach() 함수를 이용해서 모든 아이템을 순서대로 참조
    nums.forEach(fun(item){
        println(item)
    })
    println("---------")
    nums.forEach { item ->
        println(item)
    }
    println("---------")
    nums.forEach {
        // it 은 단일 파라미터에 대한 암시적인 이름
        println(it)
    }
}








