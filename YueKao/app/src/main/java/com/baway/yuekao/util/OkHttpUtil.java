package com.baway.yuekao.util;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/4 9:08
 * @Description：描述信息
 */
public class OkHttpUtil {
    OkHttpClient okHttpClient;
    static OkHttpUtil Utile;
    private OkHttpUtil(){
        okHttpClient=new OkHttpClient.Builder().addInterceptor(new MyInterceptor()).build();
    }
    public static synchronized OkHttpUtil getInstance(){
        if(Utile ==null){
            Utile=new OkHttpUtil();
        }
        return Utile;
    }
    public void doGet(Callback callback){
        Request request=new Request.Builder()
                .url("http://172.17.8.100/ks/product/getCarts?uid=51")
                .get()
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);

    }
    public void doPost(String phone,String pwd,String url,Callback callback){
        RequestBody body=new FormBody.Builder()
                    .add("phone",phone)
                    .add("pwd",pwd)
                    .build();
        Request request=new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    public class MyInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request=chain.request();
            Response response=chain.proceed(request);
            return response;
        }
    }
}
