package com.liliu.app.mytestapp.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.liliu.app.mytestapp.BaseActivity;
import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.adapter.MyAdapter;
import com.liliu.app.mytestapp.entity.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Android 侧滑栏实现
 */
public class SlideMenuActivity extends BaseActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    //    private SystemBarTintManager tintManager;
    private NavigationView navigationView;
    Button menu;
    XRecyclerView mRecyclerView;
    MyAdapter mMyAdapter = null;
    List<City> cityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_slide_menu);
        initData();
        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMyAdapter = new MyAdapter(cityList);
        mRecyclerView.setAdapter(mMyAdapter);
        mRecyclerView.setLoadingMoreEnabled(false);

        drawerLayout = findViewById(R.id.activity_na);
        navigationView = findViewById(R.id.nav);
        menu = findViewById(R.id.top_btn);
        View headerView = navigationView.getHeaderView(0);//获取头布局
        menu.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //item.setChecked(true);
                Toast.makeText(SlideMenuActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });
    }


    private void initData() {
        for (int i = 0; i < 20; i++) {
            City city = new City();
            city.city = "item" + i;
            cityList.add(city);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_btn://点击菜单，跳出侧滑菜单
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawer(navigationView);
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
                break;
        }
    }

    private void initWindow() {//初始化窗口属性，让状态栏和导航栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            tintManager = new SystemBarTintManager(this);
//            int statusColor = Color.parseColor("#1976d2");
//            tintManager.setStatusBarTintColor(statusColor);
//            tintManager.setStatusBarTintEnabled(true);
        }
    }
}
