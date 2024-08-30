package com.example.step05httprequest2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.step05httprequest2.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // view binding 의 기능을 이용해서 화면 구성하기
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //버튼에 클릭 리스너 등록하기
        binding.requestBtn.setOnClickListener(view->{
            String url="https://acornacademy.co.kr";
            makeHttpRequest(url);
        });

        //두번째 버튼에 클릭 리스너 등록하기
        binding.requestBtn2.setOnClickListener(view->{
            String url="https://acornacademy.co.kr";
            makeHttpRequest2(url);
        });

    }
    // Executor 객체를 이용해서 새로운 스레드에서 작업하기
    public void makeHttpRequest2(String urlAddr){
        Executor executor= Executors.newSingleThreadExecutor();
        executor.execute(()->{
            //여기는 새로운 스레드 이다
            //문자열을 누적할 객체
            StringBuilder builder=new StringBuilder();

            try {
                //요청 url 을 생성자의 인자로 전달하면서 URL 객체를 생성한다
                URL url = new URL(urlAddr);
                //URLConnection 객체를 원래 type (자식 type) 으로 casting 해서 받는다.
                HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                if(conn != null){
                    conn.setConnectTimeout(20000); //응답을 기다리는 최대 대기 시간
                    conn.setRequestMethod("GET");// 요청 메소드 설정 (Default 는 GET)
                    conn.setUseCaches(false);//케쉬 사용 여부
                    //응답 코드를 읽어온다.
                    int responseCode=conn.getResponseCode();
                    if(responseCode == HttpURLConnection.HTTP_OK) { //정상 응답이라면 (200)
                        //문자열을 읽어들일수 있는 객체의 참조값 얻어오기
                        BufferedReader br=
                                new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        //반복문 돌면서
                        while(true){
                            //문자열을 한줄씩 읽어 들인다.
                            String line=br.readLine();
                            if(line==null)break;
                            //StringBuilder 객체에 누적 시키기
                            builder.append(line);
                        }
                    }
                }
            }catch(Exception e){
                Log.e("MainActivity", e.getMessage());
            }//try~catch

            // UI 스레드에서 동작하는 함수에서 UI 업데이트 하기
            runOnUiThread(()->{
                binding.editText.setText(builder.toString());
            });
        });

    }

    //다른 스레드에서 메세지를 받아서 UI 를 업데이터 할 Handler 객체
    Handler handler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            //여기는 메인스레드(UI 스레드) 이다
            //Message 객체에 담겨온 문자열을 얻어내서
            String data = (String)msg.obj;
            //출력한다.
            binding.editText.setText(data);
        }
    };

    // http 요청을 하는 메소드
    public void makeHttpRequest(String url){
        //새로운 스레드에서 http 요청을 한다.
        new RequestThread(url).start();
    }
    //스레드 클래스
    class RequestThread extends Thread{
        String url;
        //생성자
        public RequestThread(String url){
            this.url=url;
        }
        @Override
        public void run() {
            //문자열을 누적할 객체
            StringBuilder builder=new StringBuilder();

            try {
                //요청 url 을 생성자의 인자로 전달하면서 URL 객체를 생성한다
                URL url = new URL(this.url);
                //URLConnection 객체를 원래 type (자식 type) 으로 casting 해서 받는다.
                HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                if(conn != null){
                    conn.setConnectTimeout(20000); //응답을 기다리는 최대 대기 시간
                    conn.setRequestMethod("GET");// 요청 메소드 설정 (Default 는 GET)
                    conn.setUseCaches(false);//케쉬 사용 여부
                    //응답 코드를 읽어온다.
                    int responseCode=conn.getResponseCode();
                    if(responseCode == HttpURLConnection.HTTP_OK) { //정상 응답이라면 (200)
                        //문자열을 읽어들일수 있는 객체의 참조값 얻어오기
                        BufferedReader br=
                                new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        //반복문 돌면서
                        while(true){
                            //문자열을 한줄씩 읽어 들인다.
                            String line=br.readLine();
                            if(line==null)break;
                            //StringBuilder 객체에 누적 시키기
                            builder.append(line);
                        }
                    }
                }
            }catch(Exception e){
                Log.e("MainActivity", e.getMessage());
            }//try~catch
            //응답된 문자열을 log 창에 출력해 보기
            String result = builder.toString();
            Log.d("응답된 결과", result);

            //Message 객체에 응답된 문자열을 담아서
            Message msg=new Message();
            msg.what=0;
            //Object 를 담을수 있는 공간에 String type 을 담아서
            msg.obj=builder.toString();
            //Handler 객체에 보낸다
            handler.sendMessage(msg);
        }
    }
}








