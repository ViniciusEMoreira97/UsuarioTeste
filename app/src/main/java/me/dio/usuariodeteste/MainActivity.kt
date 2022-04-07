package me.dio.usuariodeteste

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import me.dio.usuariodeteste.domain.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://sportsmatch.com.br/teste/teste.json/"

class MainActivity : AppCompatActivity() {
    lateinit var testAdapter: TestAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_test.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        rv_test.layoutManager = linearLayoutManager

        getMyData()
    }

    private fun getMyData() {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getTest()

        retrofitData.enqueue(object : Callback<List<Test>?> {
            override fun onResponse(call: Call<List<Test>?>, response: Response<List<Test>?>) {
                val responseBody = response.body()!!

                    testAdapter = TestAdapter(baseContext, responseBody)
                    testAdapter.notifyDataSetChanged()
                    rv_test.adapter = testAdapter
            }

            override fun onFailure(call: Call<List<Test>?>, t: Throwable) {
                d("Main Activity", "onFailure" + t.message)
            }
        })
        }
    }

