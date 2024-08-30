package com.example.step06coroutine

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Button 의 참조값
        val startBtn:Button = findViewById(R.id.startBtn)
        var getBtn:Button = findViewById(R.id.getBtn)
        //TextView 의 참조값
        val textView:TextView = findViewById(R.id.result)
        //회원 목록 받아오기 버튼의 리스너 등록
        getBtn.setOnClickListener{
            lifecycleScope.launch(Dispatchers.Main) {
                val result=getMembers()
                // textView.setText(result) 대신에 아래와 같이 쓸수도 있다
                textView.text=result
            }
        }

        //버튼에 리스너 등록
        startBtn.setOnClickListener{
            /*
                lifecycleScope.launch  =>  액티비티의 생명주기 안에서만 동작하기
                                           액티비티가 비활성화되면 자동 취소
                Dispatchers.Main => Main(UI) 스레드에서 동작 하도록 한다.
                                    결과 값을 이용해서 UI 를 수정하고자 할때 사용한다.
             */
            lifecycleScope.launch(Dispatchers.Main) {
                //작업의 결과값을 받아와서
                val result = doSomething() //이메소드는 리턴되는데 시간이 걸린다
                //그렇지만 리턴이 되고 다음라인이 수행될때는 Main 스레드에서 동작한다.
                //TextView 에 출력한다.
                textView.setText(result)
            }
        }
    }

    suspend fun getMembers():String{
        val result=withContext(Dispatchers.IO){
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

    // suspend fun  =>  리턴되는데 시간이 걸릴 가능성이 있는 함수
    //무언가 작업하는 메소드
    suspend fun doSomething():String{
        /*
            withContext  =>  여기서  Context 는 액티비티 임으로 액티비티의 생명 주기 안에서 동작한다.
            Dispatchers.IO  => Input Output 즉 입출력에 적합한 스레디 상에서 동작 하도록 한다.
                               http 요청 이나 파일 입출력 같은 작업을 하기에 적당하다
         */
        // withContext(){} 블럭 안쪽이 새로운 스레드에서 작업이 된다.
        val result = withContext(Dispatchers.IO){
            //스레드를 임의의로 10초 지연 시킨다 (작업이 끝나는데 10초가 걸린다고 가정)
            Thread.sleep(10000)
            //가장 마지막에 있는 데이터가 리턴된다.
            "결과 문자열 입니다.  어쩌구.. 저쩌구..."
        }

        return result
    }

}