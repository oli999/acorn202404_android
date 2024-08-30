package com.example.step07customlistview

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
/*
     [ json 문자열 사용하기 ]

     [ ]  =>  JSONArray  객체로 변환
     { }  =>  JSONObject  객체로 변환
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //MutableList 객체 생성
        val list:MutableList<MemberDto> = mutableListOf()

        //ListView 에 연결할 아답타 객체 생성해서
        val adapter = MemberAdapter(this, R.layout.listview_cell, list)
        //ListView 에 연결하기
        val listView:ListView = findViewById(R.id.listView)
        listView.adapter = adapter

        //EditText 객체의 참조값
        val inputName:EditText = findViewById(R.id.inputName)
        val inputAddr:EditText = findViewById(R.id.inputAddr)
        //버튼의 참조값 얻어와서 리스너 등록
        val addBtn:Button = findViewById(R.id.addBtn)
        addBtn.setOnClickListener{
            //입력한 이름과 주소를 읽어와서
            val name=inputName.text.toString()
            val addr=inputAddr.text.toString()
            //Post 방식으로 서버에 전송하기
            lifecycleScope.launch(Dispatchers.Main) {
                val result = addMember(name, addr)
                Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()
            }
        }

        // http://192.168.0.181:8888/members 요청을 해서 응답되는 json 문자열을 Log 창에 출력해 보세요
        lifecycleScope.launch(Dispatchers.Main) {
            val result = getMember()
            Log.d("MaiActivity", result)
            //응답받은 문자열의 형식이 [{},{},{}...] 이기 때문에 해당 문자열을 이용해서 JSONArray 객체를 생성
            val array=JSONArray(result)
            //반복문 돌면서
            for(i in 0 until array.length()){
                //i 번째 JSONObject 객체를 얻어와서
                val tmp:JSONObject = array.getJSONObject(i)
                //MemberDto 에 num, name, addr 을 담는다.
                val mem = MemberDto().apply {
                    num=tmp.getInt("num")
                    name=tmp.getString("name")
                    addr=tmp.getString("addr")
                }
                //MutableList 에 누적시킨다.
                list.add(mem)
            }
            //반복문 돌고나서 Adapter 에 데이터가 수정되었다고 알린다. (UI 업데이트를 위해)
            adapter.notifyDataSetChanged()
        }
    }

    //이름과 주소를 post 방식  /members  요청을 하면서 요청의 body 에 json 문자열 전송하기
    suspend fun addMember(name:String, addr:String):String{

        val result= withContext(Dispatchers.IO){
            //문자열을 누적할 객체
            val builder = StringBuilder()

            try {
                //요청 url 을 생성자의 인자로 전달하면서 URL 객체를 생성한다
                val url = URL("http://192.168.0.181:8888/members")
                //URLConnection 객체를 원래 type (자식 type) 으로 casting 해서 받는다.
                val conn = url.openConnection() as HttpURLConnection
                if (conn != null) {
                    conn.connectTimeout = 20000 //응답을 기다리는 최대 대기 시간
                    conn.requestMethod = "POST" // 요청 메소드 설정 (Default 는 GET)
                    conn.useCaches = false //케쉬 사용 여부
                    conn.setRequestProperty("Content-Type","application/json")
                    //문자열을 출력하기 위한 객체
                    val osw=OutputStreamWriter(conn.outputStream)
                    osw.write("""
                        {
                            "name":"$name",
                            "addr":"$addr"
                        }
                    """.trimIndent())
                    osw.flush()
                    //응답 코드를 읽어온다.
                    val responseCode = conn.responseCode
                    if (responseCode == HttpURLConnection.HTTP_OK) { //정상 응답이라면 (200)
                        //문자열을 읽어들일수 있는 객체의 참조값 얻어오기
                        val br =
                            BufferedReader(InputStreamReader(conn.inputStream))
                        //반복문 돌면서
                        while (true) {
                            //문자열을 한줄씩 읽어 들인다.
                            val line = br.readLine() ?: break
                            //StringBuilder 객체에 누적 시키기
                            builder.append(line)
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("MainActivity", e.message!!)
            } //try~catch

            // 여기서 리턴되는 문자열이 withContext(){} 의 리턴 데이터가 된다.
            builder.toString()
        }
        return result
    }

    suspend fun getMember():String{
        val result= withContext(Dispatchers.IO){
            //문자열을 누적할 객체
            val builder = StringBuilder()

            try {
                //요청 url 을 생성자의 인자로 전달하면서 URL 객체를 생성한다
                val url = URL("http://192.168.0.181:8888/members")
                //URLConnection 객체를 원래 type (자식 type) 으로 casting 해서 받는다.
                val conn = url.openConnection() as HttpURLConnection
                if (conn != null) {
                    conn.connectTimeout = 20000 //응답을 기다리는 최대 대기 시간
                    conn.requestMethod = "GET" // 요청 메소드 설정 (Default 는 GET)
                    conn.useCaches = false //케쉬 사용 여부
                    //응답 코드를 읽어온다.
                    val responseCode = conn.responseCode
                    if (responseCode == HttpURLConnection.HTTP_OK) { //정상 응답이라면 (200)
                        //문자열을 읽어들일수 있는 객체의 참조값 얻어오기
                        val br =
                            BufferedReader(InputStreamReader(conn.inputStream))
                        //반복문 돌면서
                        while (true) {
                            //문자열을 한줄씩 읽어 들인다.
                            val line = br.readLine() ?: break
                            //StringBuilder 객체에 누적 시키기
                            builder.append(line)
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("MainActivity", e.message!!)
            } //try~catch

            // 여기서 리턴되는 문자열이 withContext(){} 의 리턴 데이터가 된다.
            builder.toString()
        }
        return result
    }
}







