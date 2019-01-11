package com.liliu.app.mytestapp;

import android.os.Bundle;
import android.widget.Button;

import com.jakewharton.rxbinding2.view.RxView;
import com.liliu.app.mytestapp.activity.DialogActivity;
import com.liliu.app.mytestapp.activity.IOSDialogActivity;
import com.liliu.app.mytestapp.activity.LoadMoreActivity;
import com.liliu.app.mytestapp.activity.MultItemActivity;
import com.liliu.app.mytestapp.activity.SlideMenuActivity;
import com.liliu.app.mytestapp.activity.SortActivity;
import com.liliu.app.mytestapp.activity.TopActivity;
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
        Button mainBtn7 = findViewById(R.id.main_btn_7);
        Button mainBtn8 = findViewById(R.id.main_btn_8);
        Button mainBtn9 = findViewById(R.id.main_btn_9);
        Button mainBtn10 = findViewById(R.id.main_btn_10);
        RxView.clicks(mainBtn1).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn1());
        RxView.clicks(mainBtn2).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn2());
        RxView.clicks(mainBtn3).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn3());
        RxView.clicks(mainBtn4).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn4());
        RxView.clicks(mainBtn5).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn5());
        RxView.clicks(mainBtn6).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn6());
        RxView.clicks(mainBtn7).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn7());
        RxView.clicks(mainBtn8).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn8());
        RxView.clicks(mainBtn9).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn9());
        RxView.clicks(mainBtn10).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startBtn10());
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

    private void startBtn6() {
        start(this, SlideMenuActivity.class);
    }
    private void startBtn7() {
        start(this, MultItemActivity.class);
    }
    private void startBtn8() {
        start(this, SortActivity.class);
    }
    private void startBtn9() {
        start(this, LoadMoreActivity.class);
    }
    private void startBtn10() {
        start(this, TopActivity.class);
    }

}
