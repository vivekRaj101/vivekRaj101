package com.example.imageapitask;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

import model.Setting;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingApiActivity extends AppCompatActivity {

    public static final String TAG = "SettingApiActivity";
    ImageView imageView;
    //public SettingApiAdapter settingApiAdapter = new SettingApiAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingapi_activity);
        imageView=findViewById(R.id.img);


       /* settingsrecyclerView.setAdapter(settingApiAdapter);
        settingsrecyclerView.setLayoutManager(new LinearLayoutManager(this));*/



        SettingApiInterface settingApiInterface = SettingApiClient.getClient().create(SettingApiInterface.class);

        Call<Setting> lstSetting = settingApiInterface.getSetting();
        lstSetting.enqueue(new Callback<Setting>() {
            @Override
            public void onResponse(Call<Setting> call, Response<Setting> response) {

                Log.d(TAG, "onResponse: response..1"+response.body());
                Log.d(TAG, "onResponse: response..1"+response.raw().request().url());
//                img.setimaguri(uri.parse(response.body.getstatus()))
                imageView.setImageURI(Uri.parse(response.body().getSplash()));
//                imageView.setImageDrawable(new BitmapDrawable(response.body().getSplash()));
                Glide.with(SettingApiActivity.this).load(response.body().getSplash())
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(imageView);
//                settingApiAdapter.settingList(response.body());
//                settingApiAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Setting> call, Throwable t) {
                Log.d(TAG, "onFailure: "+call.request().url());
                Log.d(TAG, "onResponse: response..2"+t.getMessage());
            }
        });
    }
}
