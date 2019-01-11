package com.liliu.app.mytestapp.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gavin.com.library.PowerfulStickyDecoration;
import com.gavin.com.library.StickyDecoration;
import com.gavin.com.library.listener.GroupListener;
import com.gavin.com.library.listener.OnGroupClickListener;
import com.gavin.com.library.listener.PowerGroupListener;
import com.google.gson.Gson;
import com.liliu.app.mytestapp.BaseActivity;
import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.adapter.MultAdapter;
import com.liliu.app.mytestapp.entity.City;

import java.util.ArrayList;
import java.util.List;

public class MultItemActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    //    List<Order> mOrders = new ArrayList<>();
    private MultAdapter mMultAdapter;
    List<City> mOrders = new ArrayList<>();
    PowerfulStickyDecoration decoration = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mult_item);
//        iniData();
        initView();
    }
    View view;
    ImageView ivExpanded;
    TextView month;
    private void initView() {
        mRecyclerView = findViewById(R.id.cstFullShowListView);
        String[] showOrderNumbers = getResources().getStringArray(R.array.hotcity);
        String[] names = getResources().getStringArray(R.array.A);
//        mOrders = Arrays.asList(showOrderNumbers);
        for (int i = 0; i < showOrderNumbers.length; i++) {
            City city = new City();
            city.isShow = true;
            city.province = showOrderNumbers[i];
            city.provinceNum = "10";
            mOrders.add(city);
//            for (int j = 0; j < 15; j++) {
//                City city = new City();
//                city.isShow = true;
//                city.province = showOrderNumbers[i];
//                city.provinceNum = "10";
//                city.city = city.province + "---" + j;
//                city.cityNum = "" + j;
//                mOrders.add(city);
//            }
        }


        PowerGroupListener listener = new PowerGroupListener() {
            @Override
            public String getGroupName(int position) {
                //获取分组名
                return mOrders.get(position).province;
            }

            @Override
            public View getGroupView(int position) {
                //获取自定定义的组View
                view = getLayoutInflater().inflate(R.layout.history_order_month_layout, null, false);
                String monthValue = mOrders.get(position).province;
                String dayValue = mOrders.get(position).provinceNum + "城";
                month = view.findViewById(R.id.month);
                month.setText(monthValue);
                ((TextView) view.findViewById(R.id.month_order_num)).setText(dayValue);
                ivExpanded = view.findViewById(R.id.img_arrow);
                return view;
            }
        };
        decoration = PowerfulStickyDecoration.Builder
                .init(listener)
                //重置span（注意：使用GridLayoutManager时必须调用）
                //.resetSpan(mRecyclerView, (GridLayoutManager) manager)
                .setOnClickListener((position, id) -> {

            Toast.makeText(this,"pos:"+position,Toast.LENGTH_SHORT).show();
//                    City city = mOrders.get(position);
                    City city = new City();
                    city.province = "河北省";
                    city.provinceNum="11";
                    city.cityNum ="11";
                    city.city = "张三市";
                    city.isShow = true;
                    mMultAdapter.addDate(0,city);

//                    changeExpandedState(position);
////                    //修改悬浮窗
//                    View view = getLayoutInflater().inflate(R.layout.history_order_month_layout, null, false);
//                    String monthValue = mOrders.get(position).province;
//                    String dayValue = mOrders.get(position).provinceNum + "城";
//                    ((TextView) view.findViewById(R.id.month)).setText(monthValue);
//                    ((TextView) view.findViewById(R.id.month_order_num)).setText(dayValue);
//                    ImageView ivExpanded = view.findViewById(R.id.img_arrow);
//                    int rotation = city.isShow ? 0 : 180;
//                    ivExpanded.setRotation(rotation);
//                    //修改数据后，刷新指定的悬浮窗
//                    decoration.notifyRedraw(mRecyclerView, view, position);
                    mMultAdapter.notifyDataSetChanged();
                }).build();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//需要在setLayoutManager()之后调用addItemDecoration()
        mRecyclerView.addItemDecoration(decoration);
        mMultAdapter = new MultAdapter(mOrders, this);
        mRecyclerView.setAdapter(mMultAdapter);
    }


    /**
     * 修改数据
     *
     * @param position
     */
    private void changeExpandedState(int position) {
        if (mOrders.size() > position) {
            City city = mOrders.get(position);
            city.isShow = !city.isShow;
            position++;
            if (mOrders.size() > position) {
                //下个是当前分组
                City city2 = mOrders.get(position);
                if (TextUtils.equals(city.province, city2.province)) {
                    changeExpandedState(position);
                }
            }
        }
    }

}
