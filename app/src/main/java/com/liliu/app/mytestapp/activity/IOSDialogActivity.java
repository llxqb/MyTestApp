package com.liliu.app.mytestapp.activity;

import android.os.Bundle;
import android.widget.Button;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.jakewharton.rxbinding2.view.RxView;
import com.liliu.app.mytestapp.BaseActivity;
import com.liliu.app.mytestapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class IOSDialogActivity extends BaseActivity {

    private static final String DIALOG_TAG = "buttom_dialog";
    private String[] items = {"选项1", "选项2", "选项3"};
    private Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iosdialog);

        btnClick =  findViewById(R.id.btn_click);
        RxView.clicks(btnClick).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> selectedEducation());
    }


    private void selectedEducation() {
        List<String> showOrderNumberList = new ArrayList<>();
        String[] showOrderNumbers = getResources().getStringArray(R.array.education);
        for (int i = 0; i < showOrderNumbers.length; i++) {
            showOrderNumberList.add(showOrderNumbers[i]);
        }
        OptionsPickerView pvNoLinkOptions = new OptionsPickerBuilder(this, (options1, options2, options3, v) -> {
            //TODO 操作
        }).setOptionsSelectChangeListener((options1, options2, options3) -> {
        }).build();
        pvNoLinkOptions.setPicker(showOrderNumberList);
        pvNoLinkOptions.setSelectOptions(0);
        pvNoLinkOptions.show();
    }

}
