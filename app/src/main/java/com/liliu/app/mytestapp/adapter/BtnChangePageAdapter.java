package com.liliu.app.mytestapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liliu.app.mytestapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li.liu on 2018/11/13.
 * BtnChangePageAdapter
 */

public class BtnChangePageAdapter extends RecyclerView.Adapter<BtnChangePageAdapter.MyHolder> {

    private List<Integer> mList = new ArrayList<>();

    public BtnChangePageAdapter(List<Integer> list) {
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LinearLayout.inflate(parent.getContext(), R.layout.item_btn_change_page, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        MyHolder myHolder = holder;
        myHolder.mText.setText("当前值：" + mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView mText;

        MyHolder(View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.text);
        }


    }
}
