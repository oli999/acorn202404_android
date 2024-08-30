package com.example.step05httprequest2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.step05httprequest2.databinding.ActivityMain2Binding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity2 : AppCompatActivity() {
    //필드
    lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // getLayoutInflater() 메소드 대신에 layoutInflater 로 작성할수 있다.
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //버튼에 리스너 등록하기
        /*
        binding.requestBtn.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {

            }
        })
         */

        //버튼에 리스너 등록하기
        binding.requestBtn.setOnClickListener{
            val url = "https://acornacademy.co.kr"
            makeHttpRequest(url)
        }
    }

    // http 요청을 하는 메소드
    fun makeHttpRequest(url: String) {
        //새로운 스레드에서 http 요청을 한다.
        RequestThread(url).start()
    }

    //다른 스레드에서 메세지를 받아서 UI 를 업데이터 할 Handler 객체
    var handler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            //여기는 메인스레드(UI 스레드) 이다
            //Message 객체에 담겨온 문자열을 얻어내서
            val data = msg.obj as String
            //출력한다.
            binding.editText.setText(data)
        }
    }

    //스레드 클래스
    inner class RequestThread (var url: String) : Thread() {
        override fun run() {
            //문자열을 누적할 객체
            val builder = StringBuilder()

            try {
                //요청 url 을 생성자의 인자로 전달하면서 URL 객체를 생성한다
                val url = URL(this.url)
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

            //응답된 문자열을 log 창에 출력해 보기
            val result = builder.toString()
            Log.d("응답된 결과", result)

            //Message 객체에 응답된 문자열을 담아서
            val msg = Message()
            msg.what = 0
            //Object 를 담을수 있는 공간에 String type 을 담아서
            msg.obj = builder.toString()
            //Handler 객체에 보낸다
            handler.sendMessage(msg)
        }
    }
}