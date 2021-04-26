package com.joka.train.utils;

import lombok.experimental.UtilityClass;
import okhttp3.*;

/**
 * Created on 2021/4/26 21:23.
 *
 * @author zhaozengjie
 * Description :
 */
@UtilityClass
public class HttpUtils {

    private static final OkHttpClient CLIENT = new OkHttpClient();

    private OkHttpClient getInstance(){
        return CLIENT;
    }

    public void doGetAsync(String url, Callback callback){

        OkHttpClient client = getInstance();

        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();

        Call call = client.newCall(request);

        call.enqueue(callback);
    }

    public void doGetAsync(String url, Headers headers, Callback callback){

        OkHttpClient client = getInstance();

        final Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .get()//默认就是GET请求，可以不写
                .build();

        Call call = client.newCall(request);

        call.enqueue(callback);
    }

    public String doGet(String url){

        OkHttpClient client = getInstance();

        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();


        Call call = client.newCall(request);

        try {
            Response execute = call.execute();
            return execute.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException("do get fail");
    }

    public String doPost(String url, RequestBody body){

        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = CLIENT.newCall(request);

        try {
            Response execute = call.execute();
            return execute.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException("do get fail");
    }

    public void doPostJsonAsync(String url,String json,Headers headers, Callback callback){

        MediaType JSON = MediaType.parse("application/json;charset=utf-8");

        RequestBody requestBody = RequestBody.create(JSON, json);

        final Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .post(requestBody)//默认就是GET请求，可以不写
                .build();

        Call call = CLIENT.newCall(request);

        call.enqueue(callback);
    }

}
