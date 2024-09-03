package com.example.step07gallery

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

object RestApiClient {

    // JWT 토큰을 저장할 필드
    private var jwtToken: String? = null

    // JWT 토큰 설정 메소드
    fun setJwtToken(token: String) {
        jwtToken = token
    }

    // GET 요청 메소드
    suspend fun get(url: String): String {
        return makeRequest("GET", url)
    }

    // POST 요청 메소드
    suspend fun post(url: String, jsonBody: String): String {
        return makeRequest("POST", url, jsonBody)
    }

    // PUT 요청 메소드
    suspend fun put(url: String, jsonBody: String): String {
        return makeRequest("PUT", url, jsonBody)
    }

    // DELETE 요청 메소드
    suspend fun delete(url: String): String {
        return makeRequest("DELETE", url)
    }

    // 실제로 요청을 처리하는 메소드
    private suspend fun makeRequest(method: String, urlString: String, jsonBody: String? = null): String {
        return withContext(Dispatchers.IO) {
            val stringBuilder = StringBuilder()
            var conn: HttpURLConnection? = null
            try {
                // URL 객체 생성
                val url = URL(urlString)
                conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = method
                conn.connectTimeout = 15000
                conn.readTimeout = 15000
                conn.doInput = true

                //jwt 토큰이 존재한다면 같이 요청 헤더에 포함해서 가도록 한다.
                if(jwtToken != null){
                    conn.setRequestProperty("Authorization", jwtToken)
                }

                // JSON Body가 있으면 (POST, PUT의 경우) OutputStream에 쓰기
                if (jsonBody != null) {
                    conn.doOutput = true
                    conn.setRequestProperty("Content-Type", "application/json")
                    val outputStream = OutputStreamWriter(conn.outputStream)
                    outputStream.write(jsonBody)
                    outputStream.flush()
                    outputStream.close()
                }
                // 응답 코드 확인
                val responseCode = conn.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                    //문자열을 읽어들일수 있는 객체의 참조값 얻어오기
                    val br = BufferedReader(InputStreamReader(conn.inputStream))
                    //반복문 돌면서
                    while (true) {
                        //문자열을 한줄씩 읽어 들인다.
                        val line = br.readLine() ?: break
                        //StringBuilder 객체에 누적 시키기
                        stringBuilder.append(line)
                    }
                } else {
                    throw Exception("HTTP error code: $responseCode")
                }
            } catch (e: Exception) {
                throw Exception("Error making $method request to $urlString: ${e.message}", e)
            } finally {
                conn?.disconnect()
            }
            // withContext(){} 의 리턴값
            stringBuilder.toString()
        }
    }
}