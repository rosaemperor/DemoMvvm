package com.demomvvm.http;


import com.demomvvm.config.Config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/8/25.
 */

public class RetrofitUtils {
    private Retrofit retrofit;

    private OkHttpClient client;
    private HttpLoggingInterceptor loggingInterceptor;
    private static final RetrofitUtils utils = new RetrofitUtils();
    private RetrofitUtils(){
        init();
    }

    private void init() {
        //创造打印拦截器
        loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建okhtpClient
        client=new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //自定义拦截器，可以为请求添加公共headers
                //自定义拦截器，可以解析json的公共部分
                Response response = chain.proceed(chain.request());

                Request request = chain.request().newBuilder()
                        .addHeader("Content-Type", "text/html; charset=UTF-8")
                        .build();

                return chain.proceed(request);
            }
        })
                .retryOnConnectionFailure(true)
                .connectTimeout(3, TimeUnit.SECONDS)//设置超时时间
                .build();
        //添加打印拦截器
        client.interceptors().add(loggingInterceptor);
        retrofit=new Retrofit.Builder()
                .baseUrl(Config.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())//设置解析的为GSON
                .client(client)//将联网对象设置给retrofit
                .build();

    }

    public static RetrofitUtils getInstance(){
        return utils;
    }
    public <T> T createService(final Class<T> service){
        return retrofit.create(service);
    }



}
