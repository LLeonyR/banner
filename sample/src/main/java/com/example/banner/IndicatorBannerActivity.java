package com.example.banner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.banner.entity.BanneModel;
import com.example.banner.entity.DateBox;

import cn.ymex.widget.banner.Banner;
import cn.ymex.widget.banner.callback.BindViewCallBack;
import cn.ymex.widget.banner.callback.OnClickBannerListener;

public class IndicatorBannerActivity extends AppCompatActivity {
    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_banner_user);

        banner = (Banner) findViewById(R.id.banner);

        banner.bindView(new BindViewCallBack<AppCompatImageView, BanneModel>() {

            @Override
            public void bindView(AppCompatImageView view, BanneModel data, int position) {//图片处理
                //使用glide 加载图片到 view组件，data 是你的数据 。
                Glide.with(view.getContext()).load(data.getUrl()).into(view);
            }

        }).setOnClickBannerListener(new OnClickBannerListener<View, BanneModel>() {

            @Override
            public void onClickBanner(View view, BanneModel data, int position) {//点击事件
                Toast.makeText(view.getContext(), "click position ：" + position +"\n标题："+ data.getTitle(), Toast.LENGTH_SHORT).show();
            }

        }).execute(DateBox.banneModels());//填充数据
    }
}
