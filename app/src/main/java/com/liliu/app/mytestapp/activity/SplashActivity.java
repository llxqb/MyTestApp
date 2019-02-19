package com.liliu.app.mytestapp.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

import com.liliu.app.mytestapp.BaseActivity;
import com.liliu.app.mytestapp.MainActivity;
import com.liliu.app.mytestapp.R;

public class SplashActivity extends BaseActivity {
    private Handler handler;
    private ImageView ivSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();
        ivSplash = findViewById(R.id.iv_splash);

        //设置淡入
        ivSplash.setAlpha(0f);
        ivSplash.animate().alpha(1f).setDuration(2500);

        Runnable runnable = () -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();
        };

        handler.postDelayed(runnable, 2500);
    }
}
