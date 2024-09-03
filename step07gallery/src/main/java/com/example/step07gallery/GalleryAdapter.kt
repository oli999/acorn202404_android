package com.example.step07gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class GalleryAdapter(
    val context:Context,
    val layoutRes: Int,
    val list:MutableList<GalleryDto>
) : BaseAdapter() {
    //필드로 레이아웃 전개자 객체 저장하기
    val inflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(p0: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(p0: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("Not yet implemented")
    }

}