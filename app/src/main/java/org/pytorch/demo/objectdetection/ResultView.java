// Copyright (c) 2020 Facebook, Inc. and its affiliates.
// All rights reserved.
//
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree.

package org.pytorch.demo.objectdetection;

import static android.os.SystemClock.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import android.media.AudioManager;
import android.media.SoundPool;
import android.content.Context;

import android.os.VibrationEffect;
import android.os.Vibrator;


public class ResultView extends View {

    private final static int TEXT_X = 20;
    private final static int TEXT_Y = 35;
    private final static int TEXT_WIDTH = 260;
    private final static int TEXT_HEIGHT = 50;

    private Paint mPaintRectangle;
    private Paint mPaintText;
    private ArrayList<Result> mResults;

    //private Vibrator vibrator;

    public ResultView(Context context) {
        super(context);
    }

    public ResultView(Context context, AttributeSet attrs){
        super(context, attrs);
        mPaintRectangle = new Paint();
        mPaintRectangle.setColor(Color.YELLOW);
        mPaintText = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mResults == null) return;
        for (Result result : mResults) {
            mPaintRectangle.setStrokeWidth(5);
            mPaintRectangle.setStyle(Paint.Style.STROKE);
            canvas.drawRect(result.rect, mPaintRectangle);

            @SuppressLint("DrawAllocation") Path mPath = new Path();
            @SuppressLint("DrawAllocation") RectF mRectF = new RectF(result.rect.left, result.rect.top, result.rect.left + TEXT_WIDTH,  result.rect.top + TEXT_HEIGHT);
            mPath.addRect(mRectF, Path.Direction.CW);
            //mPaintText.setColor(Color.MAGENTA);
            mPaintText.setColor(Color.RED);
            canvas.drawPath(mPath, mPaintText);

            mPaintText.setColor(Color.WHITE);
            mPaintText.setStrokeWidth(0);
            mPaintText.setStyle(Paint.Style.FILL);
            mPaintText.setTextSize(32);
            //canvas.drawText(String.format("%s %.2f", PrePostProcessor.mClasses[result.classIndex], result.score), result.rect.left + TEXT_X, result.rect.top + TEXT_Y, mPaintText);
            canvas.drawText(String.format("%s", PrePostProcessor.mClasses[result.classIndex]), result.rect.left + TEXT_X, result.rect.top + TEXT_Y, mPaintText);
            if(PrePostProcessor.mClasses[result.classIndex].equals("bollard")){

                @SuppressLint("DrawAllocation") SoundPool soundPool = new SoundPool.Builder().build();
                int soundId = soundPool.load(getContext(),R.raw.child,5);
                soundPool.setOnLoadCompleteListener((soundPool1, soundId1, status) -> soundPool1.play(soundId1, 1.0f, 1.0f, 5, 0, 1.0f));

                //sleep(1000);
                Vibrator vibrator = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(VibrationEffect.createOneShot(1000, 100));
            }
        }
    }

    public void setResults(ArrayList<Result> results) {
        mResults = results;
    }
}
