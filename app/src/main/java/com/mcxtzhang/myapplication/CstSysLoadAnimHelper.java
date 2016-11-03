package com.mcxtzhang.myapplication;

import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.View;

import com.mcxtzhang.pathanimlib.PathAnimHelper;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：zhangxutong@imcoming.com
 * 时间： 2016/11/3.
 */

public class CstSysLoadAnimHelper extends PathAnimHelper {
    public CstSysLoadAnimHelper(View view, Path sourcePath, Path animPath) {
        super(view, sourcePath, animPath);
    }

    public CstSysLoadAnimHelper(View view, Path sourcePath, Path animPath, long animTime, boolean isInfinite) {
        super(view, sourcePath, animPath, animTime, isInfinite);
    }

    @Override
    public void onPathAnimCallback(View view, Path sourcePath, Path animPath, PathMeasure pathMeasure, ValueAnimator animation) {
        float value = (float) animation.getAnimatedValue();
        //获取一个段落
        float end = pathMeasure.getLength() * value;
        float begin = (float) (end - ((0.5 - Math.abs(value - 0.5)) * pathMeasure.getLength()));
        animPath.reset();
        animPath.lineTo(0, 0);
        pathMeasure.getSegment(begin, end, animPath, true);
    }
}