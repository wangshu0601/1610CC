package com.baway.yuekao.model;

import android.os.Handler;
import android.os.Message;

import com.baway.yuekao.bean.ProductBean;
import com.baway.yuekao.util.OkHttpUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/4 9:12
 * @Description：描述信息
 */
public class MyModel {
    MyCallBack myCallBack;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String json= (String) msg.obj;
            int type=msg.arg1;
            if(type==1){
                Gson gson=new Gson();
                ProductBean productBean= gson.fromJson(json,ProductBean.class);
                myCallBack.success(productBean);
            }
            if(type==2){
                try {
                    JSONObject object=new JSONObject(json);
                    String me=object.getString("message");
                    myCallBack.success(me);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    };
    public void setMyCallBack(MyCallBack myCallBack){
        this.myCallBack=myCallBack;
    }
    public void getRequest(){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.doGet(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Message message=new Message();
                message.obj=string;
                message.arg1=1;
                handler.sendMessage(message);
            }
        });
    }

    public void postRequest(String phone,String pwd,String url){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.doPost(phone, pwd, url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Message message=new Message();
                message.obj=string;
                message.arg1=2;
                handler.sendMessage(message);
            }
        });
    }
    public interface MyCallBack{
        public void success(Object o);
    }
}
