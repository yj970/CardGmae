package com.yj.cardgame.eventbus;

/**
 * Created by yangjie on 2018/7/22.
 */

public class BuffEffectEventbus{
    private int viewID;

    public BuffEffectEventbus(int viewID) {
        this.viewID = viewID;
    }

    public int getViewID() {
        return viewID;
    }
}
