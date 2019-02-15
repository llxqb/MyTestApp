package com.liliu.app.mytestapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liliu.app.mytestapp.BaseActivity;
import com.liliu.app.mytestapp.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
