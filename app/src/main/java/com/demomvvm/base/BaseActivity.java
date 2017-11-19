package com.demomvvm.base;

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
        iniTitleBar();

    }

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
    

}
