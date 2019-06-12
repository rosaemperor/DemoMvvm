package com.qubuxing.qbx

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.io.File

interface HttpService {


    @GET()
     fun getAdSplashs() : Call<Any>

    @POST("url地址")
    fun getFile(@Body pfile : File , pversion : Int ,  ptype : String) : Call<ResponseBody>
}