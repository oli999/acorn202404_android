package com.example.step09gameview;

//미사일 하나의 정보를 객체로 관리하기 위해
public class Missile {
    //미사일의 좌표를 저장할 필드
    public int x;
    public int y;
    public boolean isDead=false; //화면에서 제거 할지 여부
    //생성자
    public Missile(int x, int y){
        this.x=x;
        this.y=y;
    }
}
