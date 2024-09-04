package com.example.step07gallery

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // DetailActivity 가 활성화 되기 위해서 전달 받은 Intent 객체의 참조값
        //val i : Intent = getIntent()
        //val i = intent
        //자세히 보여줄 Gallery 의 pk
        val num = intent.getLongExtra("num", 0)
        // activity_detail.xml 로 만들어진 UI 의 참조값 얻어내기
        val imageView:ImageView = findViewById(R.id.imageView)
        val textWriter:TextView = findViewById(R.id.writer)
        val textCaption:TextView = findViewById(R.id.caption)
        val textRegdate:TextView = findViewById(R.id.regdate)

        lifecycleScope.launch(Dispatchers.Main) {
            // json 문자열
            val result = RestApiClient.get("http://192.168.0.181:8888/gallery/$num")
            // json 문자열은 { } 구조 이기때문에 JSONObject 객체를 생성한다
            val jsonObj = JSONObject(result)
            textWriter.text = jsonObj.getString("writer")
            textCaption.text = jsonObj.getString("caption")
            textRegdate.text = jsonObj.getString("regdate")
            // Glide 를 이용해서 ImageView 에 이미지 출력하기
            Glide.with(this@DetailActivity)
                .load("http://192.168.0.181:8888/upload/images/${jsonObj.getString("saveFileName")}")
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)
        }
    }
}








