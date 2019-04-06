package com.baway.yuekao.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/4 11:18
 * @Description：描述信息
 */
public class WaterView extends View {
    int w=0;
    int h=0;
    int hh=0;
    int x=0;
    Paint paint=new Paint();
    boolean isgong=true;
    public WaterView(Context context) {
        super(context);
    }

    public WaterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
    }

    public WaterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        hh=getMeasuredHeight();
        w=getMeasuredWidth();
        h=hh/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path=new Path();
        path.moveTo(-w+x,h);
        path.quadTo(-w/4*3+x,h-60,-w/2+x,h);
        path.quadTo(-w/4+x,h+60,0+x,h);
        path.quadTo(w/4+x,h-60,w/2+x,h);
        path.quadTo(w/4*3+x,h+60,w+x,h);
        path.lineTo(w,hh);
        path.lineTo(0,hh);
        path.close();
        canvas.drawPath(path,paint);
        if(isgong) {
            startAnimation();
        }

    }

    ValueAnimator valueAnimator;
    public void startAnimation() {
            isgong=false;
            valueAnimator=ValueAnimator.ofInt(0,w);
            valueAnimator.setDuration(4000);
            valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    x=(int)animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            valueAnimator.start();
        }


}
