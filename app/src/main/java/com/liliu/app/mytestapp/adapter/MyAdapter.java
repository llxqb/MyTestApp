package com.liliu.app.mytestapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.entity.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li.liu on 2018/12/27.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    List<City> mCities = new ArrayList<>();

    public MyAdapter(List<City> cityList) {
        mCities = cityList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        City city = mCities.get(position);
        MyHolder myHolder = holder;
        myHolder.mTextView.setText(city.name);
    }


    @Override
    public int getItemCount() {
        return mCities.size();
    }


    class MyHolder extends ViewHolder {
        TextView mTextView;

        MyHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.my_item_text);
        }
    }
}
