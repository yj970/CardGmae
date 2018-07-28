package com.yj.cardgame.util;

import android.util.DisplayMetrics;

import com.yj.cardgame.APP;

/**
 * Created by yangjie on 2018/7/29.
 */

public class DisplayMetricsUtil {

    public static int getScreenWidth() {
        DisplayMetrics dm = APP.getContext().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        DisplayMetrics dm = APP.getContext().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
}
