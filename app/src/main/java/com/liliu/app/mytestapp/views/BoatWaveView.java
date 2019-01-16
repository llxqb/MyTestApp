package com.liliu.app.mytestapp.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.liliu.app.mytestapp.util.DensityUtil;


/**
 * Created by li.liu on 2019/1/14.
 * 画贝塞尔曲线
 */

public class BoatWaveView extends View {

    /**
     * 画图路径
     */
    private Path mPath;
    /**
     * 画布
     */
    private Canvas mCanvas;
    /**
     * 画笔
     */
    private Paint mPaint;
    private Context mContext;

    /**
     * 点位信息
     */
    private int ax;
    private int ay;
    private int bx;
    private int by;
    private int cx;
    private int cy;
    /**
     * 路径测量
     */
    private PathMeasure mPathMeasure;

    /**
     * @param context
     */
    float mCurrentPosition[];

    public BoatWaveView(Context context) {
        this(context, null);
    }

    public BoatWaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BoatWaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        // 初始化 路径对象
        mPath = new Path();
        //初始化  画布
        mCanvas = new Canvas();

        //初始化  画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        // 抗锯齿
        mPaint.setAntiAlias(true);
        // 防抖动
        mPaint.setDither(true);
        mPaint.setStrokeWidth(DensityUtil.dip2px(mContext, 2));

        ax = DensityUtil.dip2px(mContext, 100);
        ay = DensityUtil.dip2px(mContext, 200);
        bx = DensityUtil.dip2px(mContext, 200);
        by = 0;
        cx = DensityUtil.dip2px(mContext, 300);
        cy = DensityUtil.dip2px(mContext, 200);


        mPathMeasure = new PathMeasure(mPath, false);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
                mPathMeasure.getPosTan(value, mCurrentPosition, null);
                mPath.lineTo(mCurrentPosition[0], mCurrentPosition[1]);
                postInvalidate();
            }
        });
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);//无限循环
        valueAnimator.start();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                bx = (int) event.getX();
                by = (int) event.getY();
                // 重置路径
                mPath.reset();
                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint.setColor(Color.GREEN);
        // 绘制一个填充色为蓝色的矩形
//        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        mPaint.setColor(Color.RED);
        mPath.moveTo(ax, ay);
        // 填充二阶贝塞尔曲线的另外两个控制点 B(bx,by) 和 C(cx,cy)，切记顺序不能变
        mPath.quadTo(bx, by, cx, cy);
        start(canvas);
//        canvas.drawCircle(0,0,50,mPaint);
    }

    public void start(Canvas canvas) {
        // 将 贝塞尔曲线 绘制至画布
        canvas.drawPath(mPath, mPaint);
        mPaint.setColor(Color.BLACK);
        // 画辅助点
        canvas.drawPoint(bx, by, mPaint);
//        canvas.drawCircle(DensityUtil.dip2px(mContext,100),DensityUtil.dip2px(mContext,100),DensityUtil.dip2px(mContext,80),mPaint);
    }

}
