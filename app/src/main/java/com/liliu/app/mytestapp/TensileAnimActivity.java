package com.liliu.app.mytestapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TensileAnimActivity extends BaseActivity {

    private LinearLayout mLlBgGround;
    private TextView mTensileTvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tensile_anim);
        initView();
        initData();
    }

    protected void initView() {
        mTensileTvText = findViewById(R.id.tensile_tv_text);
        mLlBgGround = findViewById(R.id.ll_bgGround);
        Button mBtnTensile = findViewById(R.id.btn_tensile);
        RxView.clicks(mBtnTensile).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> startTensile());
    }


    protected void initData() {
    }

    private void startTensile() {
        startAnim();
    }

    private void startAnim() {
//        mTensileTvText.setClickable(false);
        ValueAnimator animator = ValueAnimator.ofInt(0, 100);
        animator.setDuration(500);
        animator.addUpdateListener(animation -> {
            int magrin = (int) animation.getAnimatedValue();
            Log.e("TAG", "magrin:" + magrin);
            LinearLayout.LayoutParams paramsLike = (LinearLayout.LayoutParams) mTensileTvText.getLayoutParams();
            paramsLike.leftMargin = magrin;
            paramsLike.rightMargin = magrin;
            mTensileTvText.setLayoutParams(paramsLike);
        });
        animator.start();
    }


}
