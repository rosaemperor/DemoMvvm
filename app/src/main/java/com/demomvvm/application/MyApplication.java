package com.demomvvm.application;

import android.app.Application;
import android.content.Context;

import com.dodola.rocoofix.RocooFix;
//import com.facebook.drawee.backends.pipeline.Fresco;
//import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
//import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.zhy.autolayout.config.AutoLayoutConifg;

import okhttp3.OkHttpClient;

/**
 * Created by Adminidtrator on 2017/11/11.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        initFresco();
    }

    /**
     * 初始化fresco
     */
    private void initFresco() {
//        OkHttpClient httpClient= new OkHttpClient();
//        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory
//                .newBuilder(this,httpClient)
//                .build();
//        Fresco.initialize(this,config);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
