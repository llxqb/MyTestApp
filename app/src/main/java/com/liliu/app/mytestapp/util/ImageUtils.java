package com.liliu.app.mytestapp.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.liliu.app.mytestapp.GlideApp;
import com.liliu.app.mytestapp.R;

/**
 * Created by li.liu on 2019/1/21.
 * Image处理类
 */

public class ImageUtils {

    public static void displayMatchImage(final Context context, Object path, final ImageView imageView) {
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        SimpleTarget<GlideDrawable> simpleTarget = new SimpleTarget<GlideDrawable>() {
//            @Override
//            public void onResourceReady(GlideDrawable resource, GlideAnimation glideAnimation) {
//                int width = SystemUtils.getScreenWidth(context);//屏幕的宽度
//                imageView.setImageDrawable(resource);
//                ViewGroup.LayoutParams linearParams = imageView.getLayoutParams();
//                linearParams.height = (int) ((float) resource.getMinimumHeight() / (float) resource.getMinimumWidth() * width);// 控件的宽强制设成适应
//                imageView.setLayoutParams(linearParams);
//            }
//        };
//        GlideArms.with(context).load(path).placeholder(R.drawable.default_img_big)
//                .error(R.drawable.default_img_big).dontAnimate().
//                into(simpleTarget);
    }


    public static void loadImg(Context context, Object path, ImageView imageView) {
        //into中用Target，占位符（placeholder、error）需要在回调中设置
        Glide.with(context)
                .load(path)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .apply(new RequestOptions().centerInside())
                .thumbnail(Glide.with(context).load(R.mipmap.ic_launcher))
                .into(imageView);
    }


    /**
     * 自适应宽度加载图片。保持图片的长宽比例不变，通过修改imageView的高度来完全显示图片。
     */
    public static void loadIntoUseFitWidth(Context context, final Object imageUrl, int errorImageId, final ImageView imageView) {
        GlideApp.with(context)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        if (imageView == null) {
                            return false;
                        }
                        if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        }
                        ViewGroup.LayoutParams params = imageView.getLayoutParams();
                        int vw = imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
                        float scale = (float) vw / (float) resource.getIntrinsicWidth();
                        int vh = Math.round(resource.getIntrinsicHeight() * scale);
                        params.height = vh + imageView.getPaddingTop() + imageView.getPaddingBottom();
                        imageView.setLayoutParams(params);
                        return false;
                    }
                })
                .placeholder(errorImageId)
                .error(errorImageId)
                .into(imageView);
    }

}
