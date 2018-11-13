package com.liliu.app.mytestapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by li.liu on 2018/11/2.
 * BaseActivity
 */

public abstract class BaseActivity extends Activity {

    public static void start(Context context, Class B){
        Intent intent =new Intent(context,B);
        context.startActivity(intent);
    }


}
