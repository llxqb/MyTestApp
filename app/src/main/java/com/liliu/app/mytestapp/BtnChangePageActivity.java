package com.liliu.app.mytestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liliu.app.mytestapp.adapter.BtnChangePageAdapter;

import java.util.ArrayList;
import java.util.List;

public class BtnChangePageActivity extends AppCompatActivity {

    List<Integer> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_change_page);

        initView();
        initData();
    }


    private void initView() {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        BtnChangePageAdapter btnChangePageAdapter = new BtnChangePageAdapter(mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(btnChangePageAdapter);
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            mList.add(i);
        }
    }
}
