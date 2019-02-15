package com.liliu.app.mytestapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.adapter.BtnChangePageAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BtnChangePageActivity extends AppCompatActivity {

    List<Integer> mList = new ArrayList<>();
    RecyclerView mRecyclerView;
    int totalScroll;
    int rvHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_change_page);

        initView();
        initData();
    }


    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        ImageView mImg = findViewById(R.id.img);
        mImg.setImageResource(R.mipmap.ic_launcher);
        Button leftBtn = findViewById(R.id.left_btn);
        Button rightBtn = findViewById(R.id.right_btn);
        RxView.clicks(leftBtn).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> leftBtn());
        RxView.clicks(rightBtn).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> rightBtn());
        BtnChangePageAdapter btnChangePageAdapter = new BtnChangePageAdapter(mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
                super.onMeasure(recycler, state, widthSpec, heightSpec);
                rvHeight = mRecyclerView.getHeight();
            }
        });
        mRecyclerView.setAdapter(btnChangePageAdapter);
    }

    private void initData() {
        for (int i = 0; i < 40; i++) {
            mList.add(i);
        }
    }

    private void leftBtn() {
        if (mRecyclerView.canScrollVertically(-1)) {
            mRecyclerView.smoothScrollBy(0, -rvHeight);
        } else {
            Toast.makeText(this, "已經是頂部了", Toast.LENGTH_SHORT).show();
        }
    }

    private void rightBtn() {
        Log.e("BtnChangePageActivity", "rvHeight:" + rvHeight);
        if (mRecyclerView.canScrollVertically(1)) {
            mRecyclerView.smoothScrollBy(0, rvHeight);
        } else {
            Toast.makeText(this, "已經是底部了", Toast.LENGTH_SHORT).show();
        }
    }


}
