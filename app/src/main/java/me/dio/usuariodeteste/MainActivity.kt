package me.dio.usuariodeteste

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {
    //lateinit var testAdapter: TestAdapter
    //lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        rv_test.setHasFixedSize(true)
//        linearLayoutManager = LinearLayoutManager(this)
//        rv_test.layoutManager = linearLayoutManager

        getMyData()
    }

    private fun getMyData() {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getTest()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(call: Call<List<MyDataItem>?>, response: Response<List<MyDataItem>?>) {
                val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()

                for(myData in responseBody){
                    myStringBuilder.append(myData.body)
                    myStringBuilder.append(myData.userId)
                }

                tv_name.text = myStringBuilder
                tv_selecao.text = myStringBuilder
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                d("Main Activity", "onFailure" + t.message)
            }


        })
        }
    }

