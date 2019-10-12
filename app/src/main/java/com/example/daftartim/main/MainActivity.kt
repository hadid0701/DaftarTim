package com.example.daftartim.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.daftartim.R
import com.example.daftartim.data.model.TeamResponse
import com.example.daftartim.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }
    private fun getData(){
        ApiClient.create().ambilDatatim()
            .enqueue(object:Callback<TeamResponse>{
                override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                    Log.e("Error",t.message)
                }

                override fun onResponse(
                    call: Call<TeamResponse>,
                    response: Response<TeamResponse>
                ) {
                    if (response.isSuccessful){
                        Log.d("Hasil request",response.body()!!
                            .toString())
                    }
                    else{
                        Log.d("Hasi request",response.message())
                    }
                }

            }
            )


    }
}
