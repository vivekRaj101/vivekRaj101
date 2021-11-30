package com.example.imageapitask;

import java.util.List;

import model.Setting;
import retrofit2.Call;
import retrofit2.http.POST;

public interface SettingApiInterface {

    @POST("settings")
    Call<Setting> getSetting();
}
