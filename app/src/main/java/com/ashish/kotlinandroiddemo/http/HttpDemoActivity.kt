package com.ashish.kotlinandroiddemo.http

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.ashish.kotlinandroiddemo.R
import kotlinx.android.synthetic.main.activity_http_demo.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class HttpDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_demo)

        ApiCall().execute()
    }

    inner class ApiCall : AsyncTask<Void, Void, ArrayList<Celeb>>() {
        override fun onPreExecute() {
            super.onPreExecute()
            progressBar.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg params: Void?): ArrayList<Celeb>? {
            val response = restCall()
            val jsonObj = JSONObject(response)
            var celebs: ArrayList<Celeb> = ArrayList<Celeb>()
            if (jsonObj.has("CelebrityValues")) {
                val jArray: JSONArray = jsonObj.getJSONArray("CelebrityValues")
                for (i in 0..jArray.length()) {
                    try {
                        val mObj: JSONObject = jArray.getJSONObject(i)
                        celebs.add(Celeb(mObj.getString("name"),
                                mObj.getInt("celebId"), mObj.getInt("price")))
                    } catch (e: Exception) {
                    }
                }
            }

            return celebs
        }

        override fun onPostExecute(result: ArrayList<Celeb>) {
            super.onPostExecute(result)
            progressBar.visibility = View.GONE

            recyclerView.adapter = CelebAdapter(this@HttpDemoActivity, result)
            recyclerView.layoutManager = LinearLayoutManager(this@HttpDemoActivity)
        }

        @Throws(IOException::class)
        fun restCall(): String {
            var inputStream: InputStream? = null
            try {
                val url = URL("https://celebritybucks.com/developers/export/JSON")
                val conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = "GET"
                conn.connect()

                inputStream = conn.inputStream
                return inputStream.bufferedReader().use { it.readText() }
            } finally {
                if (inputStream != null) {
                    inputStream.close()
                }
            }
        }

        /*fun doRequest(): String {
            val url = "https://celebritybucks.com/developers/export/JSON"
            val obj = URL(url)

            with(obj.openConnection() as HttpURLConnection) {
                // optional default is GET
                requestMethod = "GET"


                println("\nSending 'GET' request to URL : $url")
                println("Response Code : $responseCode")

                BufferedReader(InputStreamReader(inputStream)).use {
                    val response = StringBuffer()

                    var inputLine = it.readLine()
                    while (inputLine != null) {
                        inputLine = it.readLine()
                        response.append(inputLine)
                    }
                    println(response.toString())
                    return response.toString()
                }
            }
        }*/

    }
}
