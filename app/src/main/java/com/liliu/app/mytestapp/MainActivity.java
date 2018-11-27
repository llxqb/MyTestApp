package com.liliu.app.mytestapp;

import android.os.Bundle;
import android.widget.Button;

import com.jakewharton.rxbinding2.view.RxView;
import com.liliu.app.mytestapp.activity.DialogActivity;
import com.liliu.app.mytestapp.activity.IOSDialogActivity;
import com.liliu.app.mytestapp.activity.TriangleLabelActivity;

import java.util.concurrent.TimeUnit;


public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    protected void initView() {
        Button mainBtn1 = findViewById(R.id.main_btn_1);
        Button mainBtn2 = findViewById(R.id.main_btn_2);
        Button mainBtn3 = findViewById(R.id.main_btn_3);
        Button mainBtn4 = findViewById(R.id.main_btn_4);
        Button mainBtn5 = findViewById(R.id.main_btn_5);
        Button mainBtn6 = findViewById(R.id.main_btn_6);
        RxView.clicks(mainBtn1).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn1());
        RxView.clicks(mainBtn2).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn2());
        RxView.clicks(mainBtn3).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn3());
        RxView.clicks(mainBtn4).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn4());
        RxView.clicks(mainBtn5).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn5());
    }

    protected void initData() {

    }

    private void startBtn1() {
        start(this, TensileAnimActivity.class);
    }

    private void startBtn2() {
        start(this, BtnChangePageActivity.class);
    }

    private void startBtn3() {
        start(this, TriangleLabelActivity.class);
    }

    private void startBtn4() {
        start(this, DialogActivity.class);
    }

    private void startBtn5() {
        start(this, IOSDialogActivity.class);
    }

}
