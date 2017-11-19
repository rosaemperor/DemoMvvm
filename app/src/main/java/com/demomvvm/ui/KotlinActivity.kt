package com.demomvvm.ui
import android.widget.Toast
import com.demomvvm.R
import com.demomvvm.base.BaseActivity
import com.demomvvm.databinding.KotlinTestLayoutBinding

/**
 * Created by Adminidtrator on 2017/11/17.
 */
class KotlinActivity : BaseActivity() {
    lateinit var binding : KotlinTestLayoutBinding
    override fun initViewModel() {

        binding = initBinding(R.layout.kotlin_test_layout)
    }

    override fun configTitleBar() {

        setTitle("kotlin测试")
    }
}