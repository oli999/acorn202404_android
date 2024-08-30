package com.example.kotlin_study

// Step19_Array.kt

/*
    Array  => 아이템 수정가능, 아이템 추가 불가
    List   => 아이템 수정불가, 이이템 추가 불가
    MuatableList => 아이템 수정가능, 아이템 추가 가능
 */


fun main(){
    //정수 배열(array) 객체 생성하기
    val nums:Array<Int> = arrayOf(10, 20, 30)
    val nums2:List<Int> = listOf(10, 20, 30)
    val nums3:MutableList<Int> = mutableListOf(10, 20, 30)

    // Array 의  0 번방 아이템 수정
    nums[0] = 100
    // List 의 0 번방 아이템 수정 (불가)
    //nums2[0] = 100
    // MutableList 의 0 번방 아이템 수정
    nums3[0] = 100

    //MutableList type 만 item 을 추가 할수 있다.
    nums3.add(40)
    nums3.add(50)
}







