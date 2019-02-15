package com.liliu.app.mytestapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.liliu.app.mytestapp.BaseActivity;
import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.util.ImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 自定义View
 */
public class MyViewActivity extends BaseActivity {

    @BindView(R.id.casish_img)
    ImageView mCasishImg;
    @BindView(R.id.start_move)
    Button mStartMove;
    @BindView(R.id.end_move)
    Button mEndMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        ImageUtils.loadIntoUseFitWidth(this, R.mipmap.main_top_icon,R.mipmap.ic_launcher, mCasishImg);
    }

    private void initData() {
    }


    @OnClick({R.id.start_move, R.id.end_move})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start_move:
                break;
            case R.id.end_move:
                break;
        }
    }
}
