package com.codekul.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.EditText;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by aniruddha on 5/1/17.
 */

public final class OurView extends EditText {

    private Paint paint;
    private int cx = 0, cy = 0, rad = 30, dx = 5 , dy = 5;
    private int width, height;

    public OurView(Context context) {
        super(context);
 // code
        initPaint();
        initRun();
    }

    public OurView(Context context, AttributeSet attr) {
        super(context,attr);

        // xmls
        initPaint();

        initRun();

        width = 800;
        height = 800;
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    private void initRun() {
        updateBouncingBall()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnNext(vals -> {

                    int r = (int) (Math.random() * 256);
                    int g = (int) (Math.random() * 256);
                    int b = (int) (Math.random() * 256);
                    paint.setColor(Color.rgb(r,g,b));
                    invalidate();
                })
                .subscribe();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(cx,cy,30,paint);
        //canvas.drawText("{Code}Kul;",50,40,paint);
    }

    private Observable<Integer> updateBouncingBall() {
        return Observable.create(subscriber -> {
            while(true) {

                if(cx >= width) dx = -2; //throw new Exception();
                if(cx <= 0) dx = 3;
                if(cy >= height) dy = -1;
                if(cy <= 0) dy = 4;

                cx += dx;
                cy += dy;

                Thread.sleep(10);

                subscriber.onNext(0);
            }
            //subscriber.onComplete();
        });
    }
}
