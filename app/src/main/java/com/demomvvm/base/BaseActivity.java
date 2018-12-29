package com.demomvvm.base;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.demomvvm.R;
import com.demomvvm.weidget.TitleBar;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * Created by Adminidtrator on 2017/11/11.
 */

public abstract class BaseActivity extends AutoLayoutActivity{
    private LinearLayout mainView;
    protected TitleBar titleBar;
    protected enum TransitionMode{
            LEFT,RIGHT,BOTTOM,TOP
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainView = new LinearLayout(this);
        mainView.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
        , LinearLayout.LayoutParams.MATCH_PARENT);
        mainView.setLayoutParams(layoutParams);
        mainView.setFitsSystemWindows(true);
        setContentView(mainView);
        overridePendingTransitionMode();
        iniTitleBar();

    }

    /**
     * 选择activity的跳出方向和跳出方向动画
     * @return
     */
    protected abstract TransitionMode overridePendingTransitionMode();

    protected abstract void initViewModel();

    protected  void iniTitleBar() {
        titleBar= new TitleBar(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        titleBar.setLayoutParams(params);
        mainView.addView(titleBar);
        configTitleBar();
        initViewModel();
    }

    public abstract void configTitleBar();

    public <T extends ViewDataBinding> T initBinding(int layoutId ) {
        return DataBindingUtil.inflate(LayoutInflater.from(this),layoutId,
                mainView,true);
    }
    public void setTitle(CharSequence title){
        titleBar.setTitle(title);
    }
    public void setTitle(String title){
        titleBar.setTitle(title);
    }
    public void startActivity(Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(this,cls);
        startActivity(intent);
    }
    public void startActivity(Class<?> cls,Bundle bundle) throws Exception {
        if(null == bundle){
            throw new Exception("can not start an activity with null bundle");
        }
        Intent intent = new Intent();
        intent.setClass(this,cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        switch (overridePendingTransitionMode()){
            case BOTTOM:
                overridePendingTransition(R.anim.slide_bottom_in,R.anim.slide_bottom_out);
                break;
            case TOP:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
            default:
                break;
        }
    }
}
