package com.example.step07gallery

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    //필요한 필드 정의하기
    val list = mutableListOf<GalleryDto>()
    lateinit var adapter: GalleryAdapter
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ListView 에 연결할 Adapter 객체 생성해서 참조값을 필드에 넣기
        adapter = GalleryAdapter(this, R.layout.listview_cell, list)
        // ListView 의 참조값
        listView = findViewById(R.id.listView)
        // ListView 에 아답타 연결하기
        listView.adapter=adapter
        // refresh() 함수 호출해서 API 서버로 부터 데이터 받아오기
        refresh()
    }

    fun refresh(){
        // coroutine 는 스레드 보다 가볍게 동작하는 기능을 가지고 있다.
        lifecycleScope.launch(Dispatchers.Main) {
            // RestApiClient 의 기능을 이용해서 데이터를 받아와서
            val result = RestApiClient.get("http://192.168.0.181:8888/gallery?pageNum=1")
            // MutableList 에 넣어주고
            val jsonObj = JSONObject(result)
            // "list" 라는 키값으로 들어 있는 배열 얻어내기
            val arr = jsonObj.getJSONArray("list")
            // 반복문 돌면서
            for(i in 0 until arr.length()){
                // i 번째 JSONObject 객체를 얻어내서
                val tmp = arr.getJSONObject(i)
                // GalleryDto 에 담는다.
                val dto = GalleryDto().apply {
                    num=tmp.getInt("num")
                    writer=tmp.getString("writer")
                    caption=tmp.getString("caption")
                    regdate=tmp.getString("regdate")
                    imagePath="http://192.168.0.181:8888/upload/images/${tmp.getString("saveFileName")}"
                }
                //MutableList 에 누적 시킨다.
                list.add(dto)
            }
            // Adapter 에  데이터가 변경 되었다고 알리면 UI 가 업데이트 된다.
            adapter.notifyDataSetChanged()

        }
    }
}









