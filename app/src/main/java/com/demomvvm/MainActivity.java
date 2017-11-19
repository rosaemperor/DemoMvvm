package com.demomvvm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.demomvvm.base.BaseActivity;
import com.demomvvm.databinding.ActivityMainBinding;
import com.demomvvm.ui.TestActivity;
import com.zhy.autolayout.AutoLayoutActivity;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;


    @Override
    protected void initViewModel() {
        binding = initBinding(R.layout.activity_main);
    }

    @Override
    public void configTitleBar() {
       setTitle("主页");
       titleBar.setLeftGone();
    }

    public void helloClick(View view){
        Intent intent= new Intent();
        intent.setClass(MainActivity.this, TestActivity.class);
        startActivity(intent);
    }

}
