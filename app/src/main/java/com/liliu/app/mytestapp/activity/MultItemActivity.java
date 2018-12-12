package com.liliu.app.mytestapp.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.gavin.com.library.StickyDecoration;
import com.gavin.com.library.listener.GroupListener;
import com.google.gson.Gson;
import com.liliu.app.mytestapp.BaseActivity;
import com.liliu.app.mytestapp.MainActivity;
import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.adapter.MultAdapter;
import com.liliu.app.mytestapp.entity.Order;
import com.mcxtzhang.nestlistview.NestFullListView;
import com.mcxtzhang.nestlistview.NestFullListViewAdapter;
import com.mcxtzhang.nestlistview.NestFullViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultItemActivity extends BaseActivity {

    private NestFullListView mRecyclerView;
    List<Order> mOrders = new ArrayList<>();
    private MultAdapter mMultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mult_item);
        iniData();
        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.cstFullShowListView);
        mRecyclerView.setAdapter(new NestFullListViewAdapter<Order>(R.layout.mult_item_top, mOrders) {
            @Override
            public void onBind(int i, Order order, NestFullViewHolder holder) {
                holder.setText(R.id.month, order.month + "月");
                ((NestFullListView) holder.getView(R.id.cstFullShowListView2)).setAdapter(new NestFullListViewAdapter<Order.OrderInfo>(R.layout.mult_item_bottom, order.mOrderInfos) {
                    @Override
                    public void onBind(int pos, Order.OrderInfo orderInfo, NestFullViewHolder holder) {
                        holder.setText(R.id.date, orderInfo.date);
                        holder.setText(R.id.num, orderInfo.num + "次");
                    }
                });
            }

        });

//        String[] showOrderNumbers = getResources().getStringArray(R.array.education);
//        List<String> mList = Arrays.asList(showOrderNumbers);
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        GroupListener groupListener = position -> {
//            //获取分组名
//            return mOrders.get(position).month + "月";
//        };
//        StickyDecoration decoration = StickyDecoration.Builder
//                .init(groupListener)
//                //重置span（使用GridLayoutManager时必须调用）
//                //.resetSpan(mRecyclerView, (GridLayoutManager) manager)
//                .setGroupHeight(60)   //设置高度
//                .setGroupBackground(getResources().getColor(R.color.colorPrimary))
//                .build();
//        mRecyclerView.setLayoutManager(manager);
////需要在setLayoutManager()之后调用addItemDecoration()
//        mRecyclerView.addItemDecoration(decoration);
//        mMultAdapter = new MultAdapter(mOrders, this);
//        mRecyclerView.setAdapter(mMultAdapter);
    }

    private void iniData() {
        List<Order.OrderInfo> orderInfoList = null;
        for (int i = 1; i <= 12; i++) {
            Order order = new Order();
            order.month = i;
            order.numTotal = 100;
            orderInfoList = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                Order.OrderInfo orderInfo = new Order.OrderInfo();
                orderInfo.date = "2018-01-" + j;
                orderInfo.num = 10 + j;
                orderInfoList.add(orderInfo);
            }
            order.mOrderInfos = orderInfoList;
            mOrders.add(order);
        }
        Log.e("ddd", "orderList:" + new Gson().toJson(mOrders));

    }
}
