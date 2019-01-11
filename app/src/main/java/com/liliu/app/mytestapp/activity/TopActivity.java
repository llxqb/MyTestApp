package com.liliu.app.mytestapp.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liliu.app.mytestapp.BaseActivity;
import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.adapter.MyAdapter;
import com.liliu.app.mytestapp.entity.City;

import java.util.ArrayList;
import java.util.List;

/**
 * 悬浮Activity
 */
public class TopActivity extends BaseActivity {
    private RecyclerView mFeedList;
    private TextView mProvince;
    private TextView mProvinceNum;
    private ImageView mSuspensionIv;
    private int mCurrentPosition = 0;
    private MyAdapter mMyAdapter;
    private RelativeLayout mSuspensionBar;

    private int mSuspensionHeight;
    private List<City> mCities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            City city = null;
            city = new City();
            city.province = "湖南";
            city.provinceNum = "10";
            city.city = "长沙";
            city.cityNum = "1";
//            if (i == 0) {
//                city = new City();
//                city.province = "湖南";
//                city.provinceNum = "10";
//                city.city = "长沙";
//                city.cityNum = "1";
//            } else if (i == 1) {
//                city = new City();
//                city.province = "湖北";
//                city.provinceNum = "20";
//                city.city = "武汉";
//                city.cityNum = "1";
//            }
            mCities.add(city);
        }
    }

    private void initView() {
        mSuspensionBar = findViewById(R.id.suspension_bar);
        mProvince = findViewById(R.id.province);
        mProvinceNum = findViewById(R.id.province_num);
        mFeedList = findViewById(R.id.feed_list);
        mMyAdapter = new MyAdapter(mCities);
        mFeedList.setLayoutManager(new LinearLayoutManager(this));
        mFeedList.setAdapter(mMyAdapter);
        mFeedList.setHasFixedSize(true);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mFeedList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mSuspensionHeight = mSuspensionBar.getHeight();
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);
                if (view != null) {
                    if (view.getTop() <= mSuspensionHeight) {
                        mSuspensionBar.setY(-(mSuspensionHeight - view.getTop()));
                    } else {
                        mSuspensionBar.setY(0);
                    }
                }

                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition();

                    updateSuspensionBar();
                    mSuspensionBar.setY(0);
                }
            }
        });

        updateSuspensionBar();
    }

    private void updateSuspensionBar() {
        Log.e("ddd", "updateSuspensionBar: " + mCurrentPosition);
        mProvince.setText(mCities.get(mCurrentPosition).province);
        mProvinceNum.setText(mCities.get(mCurrentPosition).provinceNum);
    }
}
