package com.example.step07gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class GalleryAdapter(
    val context:Context, // 액티비티의 참조값
    val layoutRes: Int, // listview_cell.xml  문서의 리소스 아이디 전달
    val list:MutableList<GalleryDto>  // cell 에 출력할 데이터를 담고 있는 모델
) : BaseAdapter() {
    //필드로 레이아웃 전개자 객체 저장하기
    val inflater = LayoutInflater.from(context)

    //모델의 갯수를 리턴
    override fun getCount(): Int {
        return list.size
    }
    //매개변수로 전달되는 인덱스에 해당하는 아이템 리턴
    override fun getItem(index: Int): Any {
       return list.get(index)
    }
    //매개변수로 전달되는 인덱스에 해당하는 아이템의 아이디(PK) 리턴
    override fun getItemId(index: Int): Long {
        return list.get(index).num.toLong()
    }
    //첫번째 매개 변수로 전달되는 인덱스에 해당하는 View 객체를 리턴해야 한다.
    override fun getView(index: Int, convertView: View?, parent: ViewGroup?): View {
        //상수에 있는 값을 변수에 일단 담는다
        var convertView2 = convertView
        //만일 null 이라면
        if(convertView2 == null){
            // layout xml 문서를 (listview_cell.xml) 전개해서 View 객체를 만든다
            convertView2 = inflater.inflate(layoutRes, parent, false)
        }
        //index 에 해당하는 GalleryDto 를 얻어와서
        val dto=list.get(index)
        // View 객체 있는 UI 의 참조값을 id 를 이용해서 얻어낸다. !! => null 일 가능성이 없으니 걱정말고 사용해!
        val imageView:ImageView = convertView2!!.findViewById(R.id.imageView)
        val textWriter:TextView = convertView2.findViewById(R.id.writer)
        val textCaption:TextView = convertView2.findViewById(R.id.caption)
        val textRegdate:TextView = convertView2.findViewById(R.id.regdate)
        // UI 에 데이터 출력 해서
        textWriter.text=dto.writer
        textCaption.text=dto.caption
        textRegdate.text=dto.writer
        //ImageView 에는 Glide 를 이용해서 이미지 출력하기
        Glide.with(context) //해당 context(액티비티) 의 생명주기 내에서 동작
            .load(dto.imagePath) // "http://xxx:8888/upload/images/xxxx"
            .centerCrop() // 이미지 크기를 어떻게 조절해서 출력할것인지
            .placeholder(R.drawable.ic_launcher_background) // 로딩 완료전에 출력할 로딩 이미지
            .into(imageView) //로딩이 완료되면 어디에 출력할 것인지

        //리턴해 준다.
        return convertView2
    }

}










