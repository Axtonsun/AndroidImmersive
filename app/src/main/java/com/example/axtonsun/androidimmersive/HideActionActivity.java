package com.example.axtonsun.androidimmersive;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by AxtonSun on 2016/9/1.
 */
public class HideActionActivity extends AppCompatActivity{
    /**
     * Two
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hide_action);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();//获取当前界面的DecorView
            //会让应用的主体内容占用系统状态栏的空间
            int option =View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;//两者结合使用
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);//将状态栏设置成透明色
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
