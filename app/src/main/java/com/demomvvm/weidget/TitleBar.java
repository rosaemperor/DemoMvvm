package com.demomvvm.weidget;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.demomvvm.R;
import com.demomvvm.databinding.TitleBarBinding;

/**
 * Created by Adminidtrator on 2017/11/11.
 */

public class TitleBar extends RelativeLayout implements View.OnClickListener{
    private TitleBarBinding binding;
    public TitleBar(Context context) {
        super(context);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.title_bar,
                null,true);
        binding.setEvent(this);
        addView(binding.getRoot().getRootView());
    }

    public void setTitle(CharSequence title){
        binding.title.setText(title);
    }
    public void setTitle(String title){
        binding.title.setText(title);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_arrow:
                ((Activity)view.getContext()).finish();
                break;
        }
    }
    public void setLeftGone(){
        binding.leftArrow.setVisibility(View.GONE);
    }
}
