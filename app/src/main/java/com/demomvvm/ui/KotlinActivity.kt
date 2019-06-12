package com.demomvvm.ui
import android.os.Bundle
import android.widget.Toast
import com.demomvvm.Interface.APIHelp
import com.demomvvm.R
import com.demomvvm.base.BaseActivity
import com.demomvvm.databinding.KotlinTestLayoutBinding
import com.demomvvm.http.RetrofitUtils
import com.qubuxing.qbx.HttpService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

/**
 * Created by Adminidtrator on 2017/11/17.
 */
class KotlinActivity : BaseActivity() {
    override fun overridePendingTransitionMode(): TransitionMode {
        return TransitionMode.BOTTOM
    }

    lateinit var binding : KotlinTestLayoutBinding
    override fun initViewModel() {
        binding = initBinding(R.layout.kotlin_test_layout)
    }

    override fun configTitleBar() {

        setTitle("mer测试,分支删除修改名字")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.test.setOnClickListener {
            var call = RetrofitUtils.getInstance().createService(HttpService::class.java).getAdSplashs()
            call.enqueue(object : Callback<Any>{
                override fun onFailure(call: Call<Any>, t: Throwable) {

                }

                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                }
            })

            var fileCall = RetrofitUtils.getInstance().createService(HttpService::class.java).getFile(File("AAA") , 1 , "dec" )
            fileCall.enqueue(object  : Callback<ResponseBody>{
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                }
            })
        }
    }


}