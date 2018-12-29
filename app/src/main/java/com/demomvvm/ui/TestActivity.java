package com.demomvvm.ui;

import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.demomvvm.R;
import com.demomvvm.base.BaseActivity;
import com.demomvvm.databinding.ActivityTestLayoutBinding;

/**
 * Created by Adminidtrator on 2017/11/11.
 */

public class TestActivity extends BaseActivity{
    private ActivityTestLayoutBinding binding;
    int titleHeight;
    float startTop=-1;
    @Override
    public void configTitleBar() {
          setTitle("测试");
          Log.d("AAA","titleBar高度"+titleHeight);
          titleBar.setVisibility(View.GONE);
    }

    @Override
    protected TransitionMode overridePendingTransitionMode() {
        return TransitionMode.BOTTOM;
    }

    @Override
    protected void initViewModel() {
       binding= initBinding(R.layout.activity_test_layout);
       binding.test.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              Intent intent = new Intent();
              intent.setClass(TestActivity.this,KotlinActivity.class);
              startActivity(intent);
           }
       });
       binding.LineLayout.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View view, MotionEvent motionEvent) {
               switch (motionEvent.getAction()){
                   case MotionEvent.ACTION_DOWN:
                       startTop = motionEvent.getY();
                       break;
                   case MotionEvent.ACTION_MOVE:
                       binding.LineLayout.layout(binding.LineLayout.getLeft(),
                               getTop(motionEvent.getY(),startTop,binding.LineLayout.getTop()),
                               binding.LineLayout.getRight(),
                               binding.LineLayout.getBottom()+(int)(motionEvent.getY()-startTop));
                       Log.d("AAA",""+getTop(motionEvent.getY(),startTop,binding.LineLayout.getTop()));
                       return true;
               }
               return true;
           }
       });
    }
    public int getTop(float nowY,float startTop,float nowTop){
        if(nowTop != titleHeight || nowY-startTop>0){
            if(nowTop + nowY-startTop>=titleHeight){
                return (int)(nowTop+nowY-startTop);
            }

        }
        return titleHeight;
    }
}
