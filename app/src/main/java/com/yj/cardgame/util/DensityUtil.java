package com.yj.cardgame.util;


import com.yj.cardgame.APP;

/**
 * Created by yangjie on 2018/7/29.
 */

public class DensityUtil {
    public static int px2dp(float pxValue){
        float density = APP.getContext().getResources().getDisplayMetrics().density;//得到设备的密度
        return (int) (pxValue/density+0.5f);
    }
    public static int dp2px(float dpValue){
        float density = APP.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue*density+0.5f);
    }
    public static int px2sp(float pxValue){
        float scaleDensity = APP.getContext().getResources().getDisplayMetrics().scaledDensity;//缩放密度
        return (int) (pxValue/scaleDensity+0.5f);
    }
    public static int sp2px(float spValue) {
        float scaleDensity = APP.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue*scaleDensity+0.5f);
    }
}
