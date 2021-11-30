package com.example.imageapitask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import model.Setting;

public class SettingApiAdapter extends RecyclerView.Adapter<SettingApiAdapter.ViewHolder> {


    public List<Setting> settingList = new ArrayList<>();

    public void settingList(List<Setting> body) {
        settingList =  body;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_settingapi,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.settingText.setText(settingList.get(position).getStatus());
        Glide.with(holder.settingImage.getContext()).load(settingList.get(position).getSplash())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.settingImage);

    }

    @Override
    public int getItemCount() {
        return settingList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView settingImage;
        TextView settingText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            settingImage = itemView.findViewById(R.id.srow_image);
            settingText = itemView.findViewById(R.id.srow_textview);

        }
    }
}
