package com.example.step07customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

// BaseAdapter 추상클래스를 상속 받아서 만든다.
class MemberAdapter(val context:Context, val layoutRes:Int, val list:List<MemberDto>) : BaseAdapter(){
    /*
        LayoutInflater 객체는  layout xml 문서를 전개해서 실제 View 객체를 만들어 주는 객체
     */
    //레이아웃 전개자 객체를 미리 준비해둔다.
    val inflater:LayoutInflater = LayoutInflater.from(context)

    // 데이터 전체의 갯수를 리턴해준다.
    override fun getCount(): Int {
        //전체 모댈의 갯수를 리턴해 주면 된다.
        return list.size
    }

    // 인자로 전달되는 인덱스에 해당하는 데이터를 리턴해준다.
    override fun getItem(i: Int): Any {
        //모델에서 인덱스에 해당하는 MemberDto 객체를 리턴해주면 된다.
        return list.get(i)
    }
    // 인자로 전달되는 인덱스에 해당하는 데이터의 pk 를 리턴해준다
    override fun getItemId(i: Int): Long {
        //인덱스에 해당하는 아이템의 pk (num)
        return list.get(i).num.toLong()
    }
    // 인자로 전달되는 인덱스에 해당하는 cell view 를 만들어서 리턴해준다.
    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        //매개변수는 val 로 만들어지기 때문에 값 수정 불가
        var convertView = view
        //만일 view 가 null 이면
        if(view == null){
            // res/layout/listview_cell.xml 문서를 전개해서 View 객체를 만들어서 변수에 담기
            convertView = inflater.inflate(layoutRes, viewGroup, false)
        }
        // i 에 해당하는 MemberDto 객체
        val dto = list.get(i)
        //View 객체 안에 있는 3 개의 TextView 의 참조값 얻어오기
        val textNum:TextView? = convertView?.findViewById(R.id.textNum)
        val textName:TextView? = convertView?.findViewById(R.id.textName)
        val textAddr:TextView? = convertView?.findViewById(R.id.textAddr)
        //TextView 에 데이터 출력하기
        textNum?.text=Integer.toString(dto.num)
        textName?.text=dto.name
        textAddr?.text=dto.addr

        //만든 View 를 리턴해주기
        return convertView!! // 여기서 !! 는  null 이  아니라는 단언
    }

}









