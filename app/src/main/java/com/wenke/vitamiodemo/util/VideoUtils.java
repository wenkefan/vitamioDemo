package com.wenke.vitamiodemo.util;

import android.app.Activity;
import android.util.DisplayMetrics;

import testlibrary.hylk.com.loginlibrary.utils.LK_LogUtil;

/**
 * Created by wenke on 2017/8/2.
 */

public class VideoUtils {

    private static VideoUtils mVideoUtils;

    private Activity context;

    private VideoUtils(Activity context) {
        this.context = context;
    }

    public static VideoUtils getIntance(Activity context) {
        if (mVideoUtils == null) {
            synchronized (VideoUtils.class) {
                if (mVideoUtils == null) {
                    mVideoUtils = new VideoUtils(context);
                }
            }
        }
        return mVideoUtils;
    }

    public int[] getDisplay() {
        int [] pixels = new int[2];
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        int height = metric.heightPixels;   // 屏幕高度（像素）
        LK_LogUtil.D("宽：===" + width);
        height = width / 16 * 9;
        LK_LogUtil.D("高：===" + height);
        pixels[0] = width;
        pixels[1] = height;
        return pixels;
    }

}
