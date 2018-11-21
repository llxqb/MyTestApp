package com.liliu.app.mytestapp.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.liliu.app.mytestapp.BaseActivity;
import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.views.CornerLabelView;

/**
 * 三角形标签
 */
public class TriangleLabelActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_label);

        initView();
        initData();
    }

    private void initView() {
       TextView mLabel1 = findViewById(R.id.label1);
       CornerLabelView mCornerLabelView = findViewById(R.id.cornerLabelView);
    }

    private void initData() {
    }
}
