package com.example.axtonsun.androidimmersive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by AxtonSun on 2016/9/1.
 */
public class HideStaActActivity extends AppCompatActivity {
    /**
     * One
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hide_status_action);
        //隐藏状态栏
        View decorView = getWindow().getDecorView();//获取当前界面的DecorView
        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;//全屏显示 隐藏状态栏
        decorView.setSystemUiVisibility(option);//设置系统UI元素的可见性
        //隐藏ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
