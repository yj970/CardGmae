package com.yj.cardgame.util;

import android.widget.Toast;

import com.yj.cardgame.APP;

/**
 * Created by yangjie on 2018/7/14.
 */

public class ToastUtil {

    public static void show(String msg) {
        Toast.makeText(APP.getContext(), msg, Toast.LENGTH_LONG).show();
    }
}
