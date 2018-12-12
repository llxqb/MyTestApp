package com.liliu.app.mytestapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.entity.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li.liu on 2018/12/4.
 */

public class MultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    private List<Order> mOrderList = new ArrayList<>();

    public MultAdapter(List<Order> orderList, Context context) {
        this.mContext = context;
        mOrderList = orderList;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if (viewType == Order.BEAN_TOP) {
//            return new TopHolder(LayoutInflater.from(mContext).inflate(R.layout.mult_item_top, parent, false));
//        } else {
//        }
        return new BottomHolder(LayoutInflater.from(mContext).inflate(R.layout.mult_item_bottom, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Order order = mOrderList.get(position);

//        ((BottomHolder) holder).date.setText(order.da);
//        ((BottomHolder) holder).num.setText(order.num + "单");
    }

    @Override
    public int getItemCount() {
        return mOrderList.size();
    }

//    @Override
//    public int getItemViewType(int position) {
//        return mOrderList.get(position).showType;
////        if (mOrderList.get(position).showType == 0) {
////            return Order.BEAN_TOP;
////        } else if (mOrderList.get(position).showType == 1) {
////            return Order.BEAN_BOTTOM;
////        }
////        return 0;
//    }

    class TopHolder extends RecyclerView.ViewHolder {
        TextView month;

        public TopHolder(View itemView) {
            super(itemView);
            month = itemView.findViewById(R.id.month);
        }
    }

    class BottomHolder extends RecyclerView.ViewHolder {
        TextView date;
        TextView num;

        public BottomHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            num = itemView.findViewById(R.id.num);
        }
    }
}
