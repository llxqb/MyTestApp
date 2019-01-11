package com.liliu.app.mytestapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.entity.City;
import com.liliu.app.mytestapp.entity.Order;
import com.liliu.app.mytestapp.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li.liu on 2018/12/4.
 * desc:
 */

public class MultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    private List<City> mOrderList = new ArrayList<>();

    public MultAdapter(List<City> orderList, Context context) {
        this.mContext = context;
        mOrderList = orderList;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BottomHolder(LayoutInflater.from(mContext).inflate(R.layout.mult_item_bottom, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        City city = mOrderList.get(position);
        BottomHolder myHolder = (BottomHolder) holder;
        if (city.isShow && city.city!=null) {
            ViewGroup.LayoutParams layoutParams = myHolder.itemRoot.getLayoutParams();
//            layoutParams.height = DensityUtil.dip2px(mContext, 100);
            myHolder.itemRoot.setLayoutParams(layoutParams);
            myHolder.date.setText(city.city);
            //myHolder.itemView.setVisibility(View.VISIBLE);
        } else {
            ViewGroup.LayoutParams layoutParams = myHolder.itemRoot.getLayoutParams();
            layoutParams.height = DensityUtil.dip2px(mContext, 0);
            myHolder.itemRoot.setLayoutParams(layoutParams);
            //myHolder.itemView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mOrderList.size();
    }


    class BottomHolder extends RecyclerView.ViewHolder {
        TextView date;
        TextView num;
        LinearLayout itemRoot;

        public BottomHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            num = itemView.findViewById(R.id.num);
            itemRoot = itemView.findViewById(R.id.item_root);
        }
    }


    public void removeItem(String text) {
//        notifyItemMoved(startPos, endPos);
//        notifyItemRangeRemoved(Math.min(startPos, newPosition), Math.abs(i - newPosition) +1);
//        mOrderList.remove(startPos);
        for (int i = 0; i < mOrderList.size(); i++) {
            if (mOrderList.get(i).province.equals(text)) {
                mOrderList.remove(i);
            }
        }
        notifyDataSetChanged();
    }

    /**
     * 批量删除adapter数据
     * notifyItemRemoved(int position)，把position位置的那条删除
     * notifyItemRangeChanged(int positionStart, int itemCount)
     */
    public void removelistData(String text) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < mOrderList.size(); i++) {
            if (mOrderList.get(i).province.equals(text)) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int k = Integer.parseInt(list.get(i).toString());
            notifyItemRemoved(k - i);
            notifyItemRangeChanged(k - i, mOrderList.size() - k - i);
            mOrderList.remove(k - i);
        }
        notifyDataSetChanged();
    }

    public void addDate(int pos,City city){
        mOrderList.add(pos,city);
        notifyDataSetChanged();

    }
}
