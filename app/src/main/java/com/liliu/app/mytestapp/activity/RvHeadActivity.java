package com.liliu.app.mytestapp.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.liliu.app.mytestapp.BaseActivity;
import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.adapter.ExpandGroupItemEntity;
import com.liliu.app.mytestapp.adapter.PatrolGroupAdapter;
import com.liliu.app.mytestapp.entity.PatrolItem;
import com.liliu.app.mytestapp.pinnedheader.PinnedHeaderItemDecoration;
import com.liliu.app.mytestapp.pinnedheader.PinnedHeaderRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView顶部悬浮
 */

public class RvHeadActivity extends BaseActivity {
    private PinnedHeaderRecyclerView mRecyclerView;
    private LinearLayoutManager      mLayoutManager;
    private PatrolGroupAdapter       mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_head);

        initView();
        initEvent();
        initData();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_order_list);
        mRecyclerView.setLayoutManager(mLayoutManager = new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new PinnedHeaderItemDecoration());
    }

    private void initEvent() {
        /**
         * 当标题栏被悬浮的时候的点击功能
         */
        mRecyclerView.setOnPinnedHeaderClickListener(new PinnedHeaderRecyclerView.OnPinnedHeaderClickListener() {
            @Override
            public void onPinnedHeaderClick(int adapterPosition) {

                mAdapter.switchExpand(adapterPosition);
                //标题栏被点击之后，滑动到指定位置
                mLayoutManager.scrollToPositionWithOffset(adapterPosition, 0);
            }
        });
    }

//    private void addChildListData(){
//        for (int i=0;i<10;i++){
//            ExpandGroupItemEntity<String, PatrolItem> groupItem = new ExpandGroupItemEntity<>();
//            groupItem
//        }
//    }
    private void initData() {
        mAdapter = new PatrolGroupAdapter(this);
        mAdapter.setData(obtainDataList());
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<ExpandGroupItemEntity<String, PatrolItem>> obtainDataList() {
        List<ExpandGroupItemEntity<String, PatrolItem>> dataList = new ArrayList<>();

        for (int group = 0; group < 10; group++) {
            ExpandGroupItemEntity<String, PatrolItem> groupItem = new ExpandGroupItemEntity<>();
            groupItem.setExpand(false);
            groupItem.setParent("分组 " + group);
//            List<PatrolItem> childList = new ArrayList<>();
//            for (int child = 0; child < group + 1; child++) {
//                PatrolItem childItem = new PatrolItem();
//                childItem.setTime("2018-04-20 15:00");
//                childItem.setFactoryName((2000 + child) + " 项目");
//                childItem.setUser("电工 " + child);
//                childItem.setState(child % 5);
//                childList.add(childItem);
//            }
//            groupItem.setChildList(childList);
            dataList.add(groupItem);
        }

        return dataList;
    }
}
