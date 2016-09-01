## AndroidImmersive
沉浸式模式的理解学习
****

###学习来源
[ Android状态栏微技巧，带你真正理解沉浸式模式 ](http://blog.csdn.net/guolin_blog/article/details/51763825 "郭霖的CSDN")

###截图
![](https://github.com/Axtonsun/AndroidImmersive/blob/master/app/src/main/res/drawable/image.png)

###学到的知识
* 隐藏ActionBar
  * 原文是这样的:`ActionBar actionBar = getSupportActionBar();`  
          `actionBar.hide();`
  * 这样其实也可以`supportRequestWindowFeature(Window.FEATURE_NO_TITLE);`    
  **但要放在`setContentView(R.layout.activity_main);`之前**
* 获取当前界面的DecorView
  * `View decorView = getWindow().getDecorView();`
* 设置Flag
  * `int option = View.SYSTEM_UI_FLAG_FULLSCREEN;//全屏显示隐藏状态栏`
  * 
  ```
   //会让应用的主体内容占用系统状态栏的空间
            int option =View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;//两者结合使用
  ```
  * 
  ```
   //让应用的主体内容占用系统导航栏的空间
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
  ```
* 最后要设置系统UI的可见性
  * `decorView.setSystemUiVisibility(option);`
* 将状态栏和导航栏分别设置为透明色
  * `getWindow().setStatusBarColor(Color.TRANSPARENT);`
  * `getWindow().setNavigationBarColor(Color.TRANSPARENT);`
  
###真正的沉浸式
**只需要重写Activity的onWindowFocusChanged()方法**
* 竖屏模式
```
@Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
```
* 横屏模式
  * 只需在在竖屏模式下多个一下的代码就OK了
```
<activity android:name=".HorizontalActivity"
            android:screenOrientation="landscape">
       ...
</activity>
```
    
