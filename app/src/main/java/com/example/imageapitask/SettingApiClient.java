package com.example.imageapitask;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SettingApiClient {

    public static String BASE_URL = "https://livedio.in/manish/Fitness/Api/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOkHttpClient())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        addHeader(okHttpClient);
        return okHttpClient.build();
    }

    public static void addHeader(OkHttpClient.Builder okHttpClient) {
        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("app_id", "livideoreversevideo")
                        .addHeader("country", "IN")
                        .addHeader("dversion", "Samsung")
                        .addHeader("identity", "NA")
                        .addHeader("launchcount", "1")
                        .addHeader("osversion", "23")
                        .addHeader("screen", "XHDPI")
                        .addHeader("os", "1")
                        .build();
                return chain.proceed(request);
            }
        });
    }
}
